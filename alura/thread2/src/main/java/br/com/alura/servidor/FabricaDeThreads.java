package br.com.alura.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

	private static int numero = 1;

	@Override
	public Thread newThread(Runnable r) {
		System.out.println("Iniciando a thread " + numero);
		
		Thread thread = new Thread(r, "Thread Servidor Tarefas " + numero++);
		thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
		thread.setDaemon(true);

		return thread;
	}

}
