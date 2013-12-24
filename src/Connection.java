import java.net.*;

import java.util.*;
import java.io.*;

public class Connection extends Thread{
	
	Stack<Befehl> befehle = new Stack<Befehl>();
	Socket socket;
	PrintWriter pwOut = null;
	BufferedReader brIn = null;
	Socket _Socket = null;

	//Jede Connection braucht einen Thread und etwas das sie ausführen kann wenn was reinkommt
	

	Scanner _keyboard = new Scanner(System.in);
	
	public Connection(Socket socket)
	{
		this.socket=socket;

		try 
		{
			pwOut = new PrintWriter(socket.getOutputStream(),true);
			brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void run()
	{

		while(true)
		{
			String incoming;
			try 
				{
					incoming = brIn.readLine();
					befehle.add(new Befehl(incoming));

				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			} 
	
	}

	public void befehlSenden(Befehl befehl)
	{
		
	}
	
//	public Befehl befehlPop
	
}