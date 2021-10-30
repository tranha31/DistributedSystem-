package com.hust.soict.tran_quang_ha.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			socket = new Socket("127.0.0.1", 9898);
			BufferedReader in = new BufferedReader(new
					InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			System.out.println(in.readLine());
			scanner = new Scanner(System.in);
			String message;
			do {
				message = scanner.nextLine();
				out.println(message);
				String array = in.readLine();
				System.out.println(array);
			}while(message.charAt(message.length()-1) != ' ');
			
		}
		catch(IOException ie) {
			System.out.println("Can't connect to server");
		}
		finally {
			socket.close();
			scanner.close();
		}
		
	}

}
