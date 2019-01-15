package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSFutureBanco implements Callable<Void> {

    private Future<String> futureWS;
    private Future<String> futureBanco;
    private PrintStream saidaCliente;

    public JuntaResultadosFutureWSFutureBanco(Future<String> futureWS, Future<String> futureBanco, PrintStream saidaCliente) {
	this.futureWS = futureWS;
	this.futureBanco = futureBanco;
	this.saidaCliente = saidaCliente;
    }

    @Override
    public Void call() {
	System.out.println("Aguardando resultads do future WS e Banco");

	try {
	    String resultadoWS = futureWS.get(20, TimeUnit.SECONDS);
	    String resultadoBanco = futureBanco.get(20, TimeUnit.SECONDS);

	    this.saidaCliente.println(String.format("Resultado comando c2: %s, %s", resultadoWS, resultadoBanco));
	} catch (InterruptedException | ExecutionException | TimeoutException e) {
	    System.out.println("Timeout: Cancelando execução do comando c2");
	    this.saidaCliente.println("Timeout na execução do comando c2");
	    this.futureWS.cancel(true);
	    this.futureBanco.cancel(true);
	}

	System.out.println("Finalizou " + this.getClass().getSimpleName());
	return null;
    }

}
