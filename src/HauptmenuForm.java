import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class HauptmenuForm extends JFrame
{
	JButton bSpielBeitreten =new JButton("Spiel beitreten");
	JButton bSpielErstellen =new JButton("Spiel erstellen");
	
	public HauptmenuForm()
	{
		//create
		super("Hauptmenü");
		gui();
		events();  
		//inits
	}
	
	
	private void gui()
	{
		this.setVisible(true);
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Center
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(1, 3, 10, 10));
		   
		pCenter.add(bSpielBeitreten);
		  
		pCenter.add(bSpielErstellen);
		this.add(pCenter, BorderLayout.CENTER);	
	}
	
	private void events()
	{
        bSpielBeitreten.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event)
        	{
        		HauptmenuForm.this.setVisible(false);
        		SpielBeitretenForm sbf = new SpielBeitretenForm(HauptmenuForm.this);
        	}
        });
        bSpielErstellen.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event)
        	{
        		HauptmenuForm.this.setVisible(false);
        		SpielErstellenForm sef = new SpielErstellenForm(HauptmenuForm.this);
        	}
        });
	}
	
	
	
}
