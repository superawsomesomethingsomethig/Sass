package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class aboutPage extends JFrame{
	
	private JPanel aboutPanel;
	private JPanel versionPanel;
	
	//constructor
	public aboutPage() 
	{
		super("About Page");
		aboutPanel = new JPanel();
		versionPanel = new JPanel();
		start();
	}	
	private void start() 
	{
		setVisible(true);
		setUpFrame();
		setUpAboutPanel();
		setUpVersionPanel();
        pack();
        setLocationRelativeTo(null);

	}
	private void setUpFrame()
	{
		add(aboutPanel, BorderLayout.NORTH);
		add(versionPanel, BorderLayout.SOUTH);
	}
	private void setUpAboutPanel()
	{
		final JTextArea area1 = new JTextArea("Developers:\nTimmy Roma\nElla Gainey");
		aboutPanel.add(area1);
	}
	private void setUpVersionPanel()
	{
		final JTextArea area2 = new JTextArea("Version:\n ");
		versionPanel.add(area2);
		Properties prop = new Properties();
		InputStream input = null;
		try {
		input = getClass().getClassLoader().getResourceAsStream("build_info.properties");
		prop.load(input);
		System.out.print("Version: ");
		System.out.println(prop.getProperty("build.revision.number"));
		

	
	} catch (IOException ex) {
	    ex.printStackTrace();
	} finally {
	    if (input != null) {
	        try {
	            input.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	}
}



