import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LobbyForm extends JFrame
{
    JButton bVerlassen = new JButton("Verlassen");
    JCheckBox cbBereit = new JCheckBox("Bereit");
    JLabel lHostname = new JLabel();
    JLabel lClientname = new JLabel();
    String clientname;
    String hostname;
    
	
	JFrame parent;
	
	public LobbyForm(JFrame parent, String hostname)
    {
        super ("Lobby");
        this.parent = parent;
        this.hostname=hostname;
        gui();
        events();
 
     }
	
	private void gui()
    {
        this.setVisible(true);
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Center
        JPanel pCenter= new JPanel();
        this.add(pCenter,BorderLayout.CENTER);
        pCenter.setLayout(new GridLayout(3, 2, 2, 10)); 
        lHostname= new JLabel(hostname);
        pCenter.add(lHostname);
        pCenter.add(new JLabel(""));
        lClientname= new JLabel(clientname);
        pCenter.add(lClientname);
        pCenter.add(cbBereit);
        cbBereit.setToolTipText("Bereitschaft dem Host übermitteln");
        pCenter.add(new JLabel(""));
        //South
        JPanel pSouth= new JPanel();
        this.add(pSouth,BorderLayout.SOUTH);
        pSouth.add(bVerlassen);
            
    }
        
    private void events()
    {
    
    	cbBereit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			//Server den Wert übermitteln
    		}
    	});
    	
    	bVerlassen.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			//Connection abbrechen
    			LobbyForm.this.parent.setVisible(true);
    			LobbyForm.this.dispose();
    			
    		}
    	});
    }
	
	
}
