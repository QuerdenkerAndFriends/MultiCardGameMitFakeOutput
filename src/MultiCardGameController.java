import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComponent;


public class MultiCardGameController {
	
	private HauptmenuView hauptmenuView;
	private SpielBeitretenView spielBeitretenView;
	private SpielErstellenView spielErstellenView;
	private LobbyView lobbyView;
	private Spiel mySpiel;
	
	
	public MultiCardGameController(HauptmenuView hauptmenuView, SpielBeitretenView spielBeitretenView, SpielErstellenView spielErstellenView, LobbyView lobbyView)
	{
		//Initialisierung der übergebenen Views
		this.hauptmenuView=hauptmenuView;
		this.lobbyView=lobbyView;
		this.spielBeitretenView=spielBeitretenView;
		this.spielErstellenView=spielErstellenView;	
		//Startpunkt ist das HauptmenuView
		this.hauptmenuView.setVisible(true);
		//Übergabe der ActionListener an die Views im Sinne von MVC
		HauptmenuViewActionListener hval = new HauptmenuViewActionListener();
		this.hauptmenuView.addBSpielBeitretenActionListener(hval);
		this.hauptmenuView.addBSpielErstellenActionListener(hval);
		SpielBeitretenViewActionListener sbval = new SpielBeitretenViewActionListener();
		this.spielBeitretenView.addBRefreshActionListener(sbval);
		this.spielBeitretenView.addBAbbrechenActionListener(sbval);
		LobbyViewActionListener lval = new LobbyViewActionListener();
		this.lobbyView.addBVerlassenActionListener(lval);
		this.lobbyView.addCBBereitActionListener(lval);
		SpielErstellenViewActionListener seval = new SpielErstellenViewActionListener();
		this.spielErstellenView.addBAbbrechenActionListener(seval);
		this.spielErstellenView.addBKickActionListener(seval);
		this.spielErstellenView.addBServerOeffnenActionListener(seval);
		this.spielErstellenView.addBSpielStartenActionListener(seval);		
	}
	
	public void joint()
	{
		this.spielErstellenView.lGastName.setText(mySpiel.getSpieler2Name());
	}
	
	public void sbvRefresh()
	{
		Spiel[] spiele = null;
		
		try {
			spiele = Spiel.sucheOffeneSpiele();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SBVBBeitretenActionListener[] listeners = new SBVBBeitretenActionListener[spiele.length];
	
		
		for (int i=0; i<spiele.length; i++)
		{
			listeners[i]= new SBVBBeitretenActionListener(spiele[i]);
		}
		MultiCardGameController.this.spielBeitretenView.resetLines();
		MultiCardGameController.this.spielBeitretenView.setLines(spiele, (ActionListener[]) listeners);
		
	}


	
	class SpielBeitretenViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case "bRefresh": 
					sbvRefresh();
				break;
				
				case "bAbbrechen":
					MultiCardGameController.this.spielBeitretenView.setVisible(false);
					MultiCardGameController.this.hauptmenuView.setVisible(true);
				break;		
			}
			
		}
		
	}
	

	
	class SBVBBeitretenActionListener implements ActionListener{
		private Spiel spiel;
		
		public SBVBBeitretenActionListener(Spiel spiel)
		{
			super();
			this.spiel=spiel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			MultiCardGameController.this.spielBeitretenView.setVisible(false);
			MultiCardGameController.this.lobbyView.setVisible(true);
			MultiCardGameController.this.mySpiel = spiel;
			MultiCardGameController.this.lobbyView.gui(spiel);
	
		}
	}

	class HauptmenuViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case "bSpielBeitreten": 
					MultiCardGameController.this.hauptmenuView.setVisible(false);
					MultiCardGameController.this.spielBeitretenView.setVisible(true);
					sbvRefresh();
				break;
				case "bSpielErstellen":
					MultiCardGameController.this.hauptmenuView.setVisible(false);
					MultiCardGameController.this.spielErstellenView.setVisible(true);
				break;
			}

			
		}
		
	}
		
	class SpielErstellenViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			switch (c.getName())
			{
				case  "bKick": 
					mySpiel.setSpieler2Name("");
					MultiCardGameController.this.spielErstellenView.lGastName.setText("");
					
				break;
				case "bServerOeffnen":
					MultiCardGameController.this.mySpiel=Spiel.oeffneServer();
					MultiCardGameController.this.mySpiel.setSpieler1Name(MultiCardGameController.this.spielBeitretenView.tfSpielername.getText());
					MultiCardGameController.this.spielErstellenView.tfSpielName.setEditable(false);
					MultiCardGameController.this.spielErstellenView.tfSpielerName.setEditable(false);
					joint();
				break;
				case "bSpielStarten":
					Spielfeld spielfeld = new Spielfeld();
					spielfeld.reset();
					
				break;
				case "bAbbrechen":
					MultiCardGameController.this.mySpiel=null;
					MultiCardGameController.this.spielErstellenView.setVisible(false);
					MultiCardGameController.this.hauptmenuView.setVisible(true);		
					MultiCardGameController.this.spielErstellenView.tfSpielName.setEditable(true);
					MultiCardGameController.this.spielErstellenView.tfSpielerName.setEditable(true);
				break;
	     
			
			}
		
			
		}
		
	}

	class LobbyViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComponent c = (JComponent) e.getSource();
			
			
			switch (c.getName())
			{
				case "cbBereit":
					
				break;
				case "bVerlassen":
					MultiCardGameController.this.lobbyView.setVisible(false);
					MultiCardGameController.this.spielBeitretenView.setVisible(true);
					mySpiel=null;
					sbvRefresh();
				break;
			}
			
		}
		
	}
	
	/*
	class LVBVerlassenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class LVCBBereitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	*/
	
	/*
	class SBVBRefreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class SBVBAbbrechenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//SpielvonIndex Lobby beitreten
			
		}
	}
	
	*/
	
	/*
	class SEVBServerOeffenenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class SEVBSpielStartenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class SEVBKlickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class SEVBAbbrechenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	*/
	
	//LobbyView lv
	
	
	/*
	
	class HVBSpielBeitretenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			hauptmenuView.setVisible(false);
			spielBeitretenView.setVisible(true);
			spielBeitretenView.setLines(Spiel.SucheOffeneSpiele());
		}
	}
	
	class HVBSpielErstellenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	*/
	
	//SpielErstellenView sev
}
