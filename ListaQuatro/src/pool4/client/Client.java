package pool4.client;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
	private Socket clientSocket;
	
	public Client(String ip, int port) throws Exception {
		this.clientSocket = new Socket(ip, port);
	}

	public void send(String msg) throws Exception {
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
		writer.write(crypto(msg,3));
		writer.close();
	}
	public void listen() throws Exception {
		Thread action = new Thread() {
			@Override
			public void run() {
				try {
					InputStreamReader receptor = new InputStreamReader(clientSocket.getInputStream());
					BufferedReader reader = new BufferedReader(receptor);
					String message = reader.readLine();
					System.out.println(message);					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		action.start();
		Thread.sleep(500);
	}
	
		
	public String crypto(String msg, int offset){
		StringBuilder encryptedMessage = new StringBuilder();
		for (char c : msg.toCharArray()) {
			if (Character.isLetter(c)) {
				int originPosition = c - 'a';
				int newPosition = (originPosition + offset) % 26;
				char newChar = (char) ('a' + newPosition);
				encryptedMessage.append(newChar);				
			}else {
				encryptedMessage.append(c);
			}
		}
		return encryptedMessage.toString();
	}
	
	public String theMagic(String message, int offset){
		return crypto(message, 26 - (offset % 26));
	}
}
