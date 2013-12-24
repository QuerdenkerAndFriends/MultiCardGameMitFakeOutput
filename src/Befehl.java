

public class Befehl {
	private String befehl;
	

	
	
	
	private String typ, von, nach, mit;
	
	//Karte, List<Karte>, List<Karte>, List<Karte>;
	
	
	
	public Befehl(String befehl)
	{
		this.befehl=befehl;
		this.anfertigen();
	}
	
	@Override 
	public String toString()
	{
		return befehl;
	}
	
	public void add(String token)
	{
		befehl+= (","+token);
	}
	
	public void anfertigen()
	{
		//diverse StringOps
		if (befehl == "join")
		{
			
		}
	}
	
	public String getTyp() {
		return typ;
	}
	
	public String getMit() {
		return mit;
	}
	
	public String getNach() {
		return nach;
	}
	
	public String getVon() {
		return von;
	}
	
	
	
}
