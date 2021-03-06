package br.com.alura.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

    private ServerSocket servidor;
    private ExecutorService threadPool;
    private AtomicBoolean estaRodando;
    private BlockingQueue<String> filaComandos;

    /* 1. Inicialização */
    public ServidorTarefas() throws Exception {
	System.out.println("--- Iniciando servidor ---");
	this.estaRodando = new AtomicBoolean(true);
	this.servidor = new ServerSocket(12345);
	this.threadPool = Executors.newCachedThreadPool(new FabricaDeThreads()); // newCachedThreadPool();
	this.filaComandos = new ArrayBlockingQueue<>(2);

	iniciarConsumidores();
    }

    private void iniciarConsumidores() {
	int qtdConsumidores = 2;
	for (int i = 0; i < qtdConsumidores; i++) {
	    TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
	    this.threadPool.execute(tarefa);
	}
    }

    /* 2. Rodando */
    public void rodando() throws Exception {
	while (this.estaRodando.get()) {
	    try {
		Socket socket = servidor.accept();
		System.out.println("Aceitando novo cliente na porta " + socket.getPort());
		threadPool.execute(new DistribuirTarefas(threadPool, filaComandos, socket, this));
	    } catch (SocketException e) {
		System.out.println("SocketException, Está rodando: " + this.estaRodando);
	    }
	}
    }

    /* 3. Parando */
    public void parar() throws Exception {
	this.estaRodando.set(false);
	servidor.close();
	threadPool.shutdown();
    }

    public static void main(String[] args) throws Exception {
	ServidorTarefas servidor = new ServidorTarefas();
	servidor.rodando();
	servidor.parar();

    }
}
