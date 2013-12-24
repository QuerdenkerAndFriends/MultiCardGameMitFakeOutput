
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.LinkedList;
import java.util.List;


public class Spiel {

	
	private String spielName, spieler1Name, spieler2Name;
	private Befehl[] befehlsStack;
	private int spielZugZustand;
	private int spielZugAnzahl;	
	private String  hostIP, userIP;
	private Socket serverCon;
	
	

	
	
	public static Spiel[] sucheOffeneSpiele() throws UnknownHostException, IOException
	{
		Spiel spiel = new Spiel (new Socket());
		spiel.spieler1Name="Marco";
		spiel.spielName="Marcos Game";
		Spiel[] spiele = new Spiel[1];
		spiele[0]=spiel; 
		return spiele;
		/*Socket con = new Socket("127.0.0.1", 1234);
		
		con.connect(null);
		System.out.println("yolo");
		
		
		
		Spiel spiel = new Spiel(con);
		spiel.spieler1Name="Spieler1";
		spiel.spielName="Spieler1 Game";
		Spiel[] spiele = new Spiel[1];
		spiele[0]=spiel; 
		return spiele;
		*/
		/*
		System.out.println(con.getLocalAddress().toString());
		//System.out.println(con.getInetAddress().toString());
		
		
		List <Spiel> offeneSpiele = new LinkedList<Spiel>();
		
		for (int i=1; i<255; i++)
		{
			
		
			for (int j=1; j<255; j++)
			{
				
			
				for (int k=1; k<255; k++)
				{
					
					
					
				}
			}
		}
		*/
		//offeneSpiele.get(0).serverCon.
			//10.0.0.0 bis 10.255.255.255
			
			//127.0.0.0 bis 127.255.255.255
			
			//172.16.0.0 bis 172.31.255.255
			
			//192.168.0.0 bis 192.168.255.255
			
		
	}
	
	public static Spiel oeffneServer()
	{
		
		Spiel spiel = new Spiel(new Socket());
		spiel.setSpieler2Name("Marco");
		return spiel;
		/*
		try {
			
		System.out.println("qweqwe");
		//Server starten
		//Server Baut neue Cons Auf bis er angehalten wird
		//Wenn der Server einen Join hat, hört er auf zu horchen nach neuen 
		//schließe server
		int anzahlConnections = 0;
		ServerSocket ssocket = new ServerSocket(1234);
		Socket con;
		con = ssocket.accept();
		System.out.println("qweqwe");
		OutputStream clientOut[] = new OutputStream[50];
		clientOut[anzahlConnections++] = con.getOutputStream();
		
		
		spiel = new Spiel(con);
		
		} catch (IOException ee) {
			System.out.println("errorrrr");
		}
		
		return spiel;*/
	}
	
	
	public void setSpieler1Name(String spieler1Name) {
		this.spieler1Name = spieler1Name;
	}
	
	public void setSpieler2Name(String spieler2Name) {
		this.spieler2Name = spieler2Name;
	}
	
	public void setSpielName(String spielName) {
		this.spielName = spielName;
	}
	
	public String getSpieler1Name() {
		return spieler1Name;
	}
	
	public String getSpieler2Name() {
		return spieler2Name;
	}
	
	public String getSpielName() {
		return spielName;
	}
	
	

	
	public Spiel(Socket con)
	{
		this.serverCon=con;
	
		
		//Zeug holen über LAN
	}
	
	public Befehl befehlEmpfangen()
	{
		return new Befehl(new String());
	}
	
	public void befehlSpeichern(Befehl befehl)
	{
		
	}
	
	public void befehlSenden(Befehl befehl)
	{
		
	}
}
