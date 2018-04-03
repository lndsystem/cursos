package br.com.alura.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;

	public DistribuirTarefas(Socket socket, ServidorTarefas servidor) {
		this.socket = socket;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		try {

			System.out.println("Distribuindo tarefa para " + socket);
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());

			while (entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				System.out.println("Comando recebido " + comando);

				switch (comando) {
				case "c1": {
					saidaCliente.println("Confirmação comando c1");
					break;
				}
				case "c2": {
					saidaCliente.println("Confirmação comando c2");
					break;
				}
				case "c3": {
					saidaCliente.println("Confirmação comando c3");
					break;
				}
				case "fim": {
					saidaCliente.println("Desligando o servidor");
					servidor.parar();
					break;
				}

				default: {
					saidaCliente.println("Comando não encontrado");
				}
				}

				System.out.println(comando);
			}

			saidaCliente.close();
			entradaCliente.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
