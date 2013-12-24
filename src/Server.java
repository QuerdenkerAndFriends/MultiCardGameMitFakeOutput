import java.io.*;

import java.net.*;
import java.util.*;

public class Server extends ServerSocket implements Runnable 
{	
	MultiCardGameController controller;
	List <Connection> cons = new LinkedList<Connection>();
	Server(int portNr, MultiCardGameController controller) throws Exception
	{
		super(portNr);
		this.controller=controller;
	}

	
	public void run()
	{
		Connection con = null;
		boolean nochmal = true;
		while(nochmal)
		{
			try 
			{
				 cons.add(new Connection(this.accept()));				 
			}	
			catch (IOException e)
			{
				System.out.println("Fehler - ServerSocket.accept()");
			}			
			int i=0;
			while (i<cons.size())
			{
				con = cons.get(i);
				if (con.befehle.pop().toString()=="join")
				{
					nochmal = false;
					//controller.joint(con);
		
				}
				if (con.socket.isClosed())
				{
					cons.remove(i);
					i--;
				}
				i++;
			}
		}
	}

}
