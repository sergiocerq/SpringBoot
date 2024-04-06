package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HttpRequest implements Runnable {

	private Socket cliente;
	
	public HttpRequest(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void processRequest() {
		try {
			Scanner ler = new Scanner(cliente.getInputStream());
			String requestLine = ler.nextLine();
			System.out.println(requestLine);
			
			String headerLines = null;
			while((headerLines = ler.nextLine()).length() != 0) {
				System.out.println(headerLines);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		processRequest();
	}

}
