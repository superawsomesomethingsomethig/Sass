package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class aboutPage extends JFrame{
	
	private JPanel aboutPanel;
	
	//constructor
	public aboutPage() 
	{
		super("About Page");
		aboutPanel = new JPanel();
		start();
	}	
	private void start() 
	{
		setVisible(true);
		setUpFrame();
		setUpAboutPanel();
        pack();
        setLocationRelativeTo(null);

	}
	private void setUpFrame()
	{
		add(aboutPanel, BorderLayout.NORTH);

	}
	private void setUpAboutPanel()
	{
		final JTextArea area1 = new JTextArea("Developers:\nTimmyRoma");
		add(area1);
	}

}
