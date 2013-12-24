import javax.swing.*;

public class MyModalJFrame extends JFrame {
	
	JFrame parent;
		
	public MyModalJFrame(JFrame parent)
	{
		super();
		this.parent=parent;
		parent.setVisible(false);
	}
	
	public void close()
	{
		this.parent.setVisible(true);
		this.parent=null;
		this.dispose();
	}
	

}
