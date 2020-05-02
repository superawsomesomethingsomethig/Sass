package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	
	private JPanel homePanel;
	public HomeScreen() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setSize(800,600);
		homePanel = new JPanel();
		homePanel.add(new JLabel("HOME"));
		homePanel.add(new JButton("About Screen!"));
		homePanel.setBackground(Color.BLUE);
		add(homePanel);
	}
}
