package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String args[]) throws IOException {
		ServerSocket src = new ServerSocket(80);
		System.out.println("Servidor no ar...");
		while (true) {
			Socket cliente = src.accept();
			HttpRequest req = new HttpRequest(cliente);
			
			Thread t = new Thread();
			t.start();
			
		}
	}
}
