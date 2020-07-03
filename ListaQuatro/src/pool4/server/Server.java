package pool4.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private ServerSocket serverSocket;
	public static List<User> clients = new ArrayList<>(); 
	
	public Server(int port) throws Exception{
		serverSocket = new ServerSocket(port);
	}
	
	public void listen() throws Exception {
		Thread action = new Thread(){
			
			public void run() {
				try {
					User client = new User(serverSocket.accept());
					clients.add(client);
					
					InputStreamReader binReader = new InputStreamReader(client.socket.getInputStream());
					
					BufferedReader buffer = new BufferedReader(binReader);
					String msg = buffer.readLine();
					
					buffer.close();
				}catch(Exception e){
					e.printStackTrace();
				}		
			};
		};
		action.start();
		Thread.sleep(500);
	}
	
	public void queryClient(User user, int index) {
		
	}
	
	public void send(String message) {
		
		for (User u : clients) {
			try {
				OutputStreamWriter binWriter = new OutputStreamWriter(u.socket.getOutputStream());
				BufferedWriter writer = new BufferedWriter(binWriter);
				writer.write(message);
				writer.close();
				
			}	catch(Exception e) {
					e.printStackTrace();
				}
		}
		
	}
	
}

