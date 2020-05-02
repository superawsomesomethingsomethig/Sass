package superawsomesomethingsomethig;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	public HomeScreen() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		add(new JLabel("Home Screen!"));
	}
}
