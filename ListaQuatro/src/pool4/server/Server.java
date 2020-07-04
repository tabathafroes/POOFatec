package pool4.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
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
					
					for(User u : clients) {
						queryClient(u);
					}
					User client = new User(serverSocket.accept());
					clients.add(client);
				}catch(Exception e){
					e.printStackTrace();
				}		
			};
		};
		action.start();
		Thread.sleep(300);
	}
	
	public void queryClient(User user) {
		Thread action = new Thread() {
			@Override
			public void run(){
				try {
					InputStream stream = user.socket.getInputStream();
					
					if (stream.available() > 0 ) {
						InputStreamReader binReader = new InputStreamReader(user.socket.getInputStream());
						BufferedReader buffer = new BufferedReader(binReader);
						String msg = buffer.readLine();
						send(msg);
						buffer.close();
					} else {
							return;
						}
					
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}			
				
			}
		};
		action.start();
	}
	
	public void send(String message) {
		
		for (User user : clients) {
			try {
				OutputStreamWriter binWriter = new OutputStreamWriter(user.socket.getOutputStream());
				BufferedWriter writer = new BufferedWriter(binWriter);
				writer.write(message);
				writer.close();
				
			}	catch(Exception e) {
					e.printStackTrace();
				}
		}
		
	}
	
}

