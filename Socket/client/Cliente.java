package client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente { 
	public static void main(String args[]) throws IOException {
		//TODO Auto-generated method sub
		
		Socket cliente = new Socket("10.133.15.1", 80);
			
		PrintWriter escrever = new PrintWriter(cliente.getOutputStream(), true);
		Scanner ler = new Scanner(cliente.getInputStream());
			
		escrever.println("Hello World!");

		System.out.println(ler.nextLine());
		
	}
}
