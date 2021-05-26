package mainServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import mainLob.GameInfo;


public class MainServerClient extends Thread{
	
	private String serverIP = GameInfo.SERVER_IP;
	private int serverPort = GameInfo.SERVERPORT;
	
	private Socket socket;
	public BufferedReader input;
	public PrintWriter output;
	public String commandType;
	
	public MainServerClient(){
		try 
		{
			System.out.println("Connecting to server");
			socket = new Socket(serverIP, serverPort);
			
			System.out.println("Connection succsess");
			output = new PrintWriter(socket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		} 
		catch (IOException e) 
		{	 
			e.printStackTrace();	
		}
		
		
	}
	
	public void run(){
		
		try 
		{	
			while(socket != null) 
			{	
				if(commandType.equals("quit")) 
				{
					break;
				}else
				{
					continue;
				}
			}
			
			input.close();
			output.close();
			socket.close();
			
		} 
		catch(IOException e)
		{
			e.printStackTrace(); 
		}

	}	
	
	public Socket getSocket() 
	{
		return socket;
	}
	
	public int getPort() 
	{
		return serverPort;
	}
	
	public String getIp() 
	{
		return serverIP;
	}
	

}
