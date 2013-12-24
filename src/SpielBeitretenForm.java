import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SpielBeitretenForm extends MyModalJFrame {	
	OffenesSpielZeile offenesSpielZeilen[];
	JButton bRefresh = new JButton("Refresh");
	JButton bAbbrechen = new JButton("Abbrechen");
	int spielAnz;
	
	public SpielBeitretenForm(JFrame parent)
	{
		super(parent);
		refresh();
		gui();
		events();
	}
	
	private void refresh()
	{
		//offene Spiele aus dem LAN
		spielAnz=5;
		offenesSpielZeilen = new OffenesSpielZeile[spielAnz];
		for (int i=0; i< spielAnz; i++)
		{
			offenesSpielZeilen[i]  = new OffenesSpielZeile("Spiel"+i,"Host"+i, "ip"+i);
			
		}
	}
	
	private void gui()
	{
		this.setVisible(true);
		this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pCenter= new JPanel();
        this.add(pCenter, BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(spielAnz+2, 3, 10, 10));
        pCenter.add(new JLabel("Spielname"));
        pCenter.add(new JLabel("Hostname"));
        pCenter.add(new JLabel(""));

        for(OffenesSpielZeile osz : offenesSpielZeilen)
        {
            pCenter.add(osz.lSpielname);
            pCenter.add(osz.lHostname);
            pCenter.add(osz.bBeitreten);
        }
        
        
        pCenter.add(new JLabel(""));
        pCenter.add(new JLabel(""));
        pCenter.add(new JLabel(""));
        
        JPanel pSouth= new JPanel();
        this.add(pSouth, BorderLayout.SOUTH);
        pSouth.add(bRefresh);
        pSouth.add(new JLabel(""));
        pSouth.add(bAbbrechen);		
	}
	
	private void events()
	{
        bRefresh.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event)
        	{
        		refresh();
        	}
        });
        
        bAbbrechen.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event)
        	{
        		SpielBeitretenForm.this.close();	
        	}
        });
	}
	
	//INNERE KLASSE
	public class OffenesSpielZeile {
		
		
		//IP-Address
		private JButton bBeitreten = new JButton("Beitreten");
		private JLabel lSpielname;
		private JLabel lHostname;
		private String ip;

		public OffenesSpielZeile(String spielname, String hostname, String ip)
		{
			lSpielname = new JLabel(spielname);
			lHostname = new JLabel(hostname);
			this.ip = ip;			
	        bBeitreten.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent event)
	        	{
	        		LobbyForm lb = new LobbyForm(SpielBeitretenForm.this, OffenesSpielZeile.this.lHostname.getText());	
	        	}
	        });
			
		}

	}

}
