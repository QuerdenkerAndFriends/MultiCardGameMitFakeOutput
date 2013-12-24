import java.io.IOException;
import java.net.*;
import java.util.*;


public class Client {
	
	List<Connection> cons =  new  LinkedList<Connection>(); 	
	public List<Connection> sucheServer()
	{
		try {
			Connection con = new Connection(new Socket("localhost", 4711));
			cons.add(con);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cons;
	}
	
	public void joinServer(Connection con)
	{
		con.pwOut.println("join");	
		
	}

}
