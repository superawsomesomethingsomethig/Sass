package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class aboutPage extends JFrame{
	JPanel aboutPanel = new JPanel();
	BorderLayout layout = new BorderLayout();
	
	//constructor
	public aboutPage() {
		buildPanel();
	}	
	public static void buildPanel() {
		JFrame frame = new JFrame("About");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(true);
	}

}
