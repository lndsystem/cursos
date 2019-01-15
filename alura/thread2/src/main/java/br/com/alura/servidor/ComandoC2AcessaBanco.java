package br.com.alura.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String> {

    private PrintStream saida;

    public ComandoC2AcessaBanco(PrintStream saida) {
	this.saida = saida;
    }

    @Override
    public String call() throws Exception {
	System.out.println("Servidor recebeu comanod c2 - Banco");

	saida.println("processando o comando c2 - Banco");
	Thread.sleep(15000);

	Integer numero = new Random().nextInt(100) + 1;

	System.out.println("Servidor finalizou comando c2 - Banco");
	return numero.toString();
    }
}
