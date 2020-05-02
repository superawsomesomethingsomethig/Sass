package superawsomesomethingsomethig;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class aboutPage extends JFrame{
	JPanel panel = new JPanel();

	//constructor
	public aboutPage() {
		buildPanel();
	}	
	
	private void buildPanel() {
		add(new JLabel("About Screen"));
		
	}
}
