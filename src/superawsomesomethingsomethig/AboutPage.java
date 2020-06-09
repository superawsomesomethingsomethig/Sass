package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")

/*
 * About Page displays name of developers and version number.
 * @author Timmy Roma
 * @author Sam Spillers
 * @author Ella Gainey
 * @author Wesley Elliot
 */
public class AboutPage extends JFrame{
	
	private JPanel aboutPanel;
	private JPanel versionPanel;
	
	/*
	 * Constructor
	 */
	public AboutPage() 
	{
		super("About Page");
		aboutPanel = new JPanel();
		versionPanel = new JPanel();
		start();
	}	
	
	/*
	 * Method that calls all methods to set up frame/panels
	 * @author Timmy Roma
	 */
	private void start() 
	{
		setVisible(true);
		setUpFrame();
		setUpAboutPanel();
		setUpVersionPanel();
        pack();
        setLocationRelativeTo(null);

	}
	
	/*
	 * Sets up frame
	 * @author Timmy Roma
	 */
	private void setUpFrame()
	{
		add(aboutPanel, BorderLayout.CENTER);
		add(versionPanel, BorderLayout.SOUTH);
		
		
	}
	/*
	 * Method that sets up the about panel with developer names 
	 * @author Timmy Roma
	 * @author Ella Gainey
	 * @author Sam Spillers
	 * @author Wesley Elliot
	 */
	private void setUpAboutPanel()
	{

		final JTextArea area1 = new JTextArea();
		area1.setBackground(Color.WHITE);
		area1.setText("Developers:\nElla Gainey\nRimmy Toma\nSam Spilled milk\nWesley Elliott");
		Font font = new Font("Chalboard", Font.PLAIN,15);
		area1.setFont(font);
		area1.setEditable(false);
		aboutPanel.add(area1);
		
	}
	
	/*
	 * Method that sets up the version panel using the properties file that is updated using build.xml file
	 * that is run using ant builder on Eclipse
	 * @author Ella Gainey
	 */
	private void setUpVersionPanel()
	{
		
		final JTextArea area2 = new JTextArea("Version:\n ");
		area2.setEditable(false);
		versionPanel.add(area2);
		//properties file 
		Properties prop = new Properties();
		InputStream input = null;
		//load properties file
		try {
		input = getClass().getClassLoader().getResourceAsStream("build_info.properties");
		prop.load(input);
		System.out.print("Version: ");
		String revisionNumber = new String(prop.getProperty("build.revision.number"));
		String majorNumber = new String(prop.getProperty("build.major.number"));
		String minorNumber = new String(prop.getProperty("build.minor.number"));
		String versionNumber = new String(revisionNumber + "." + majorNumber + "." + minorNumber);
		System.out.println(versionNumber);
		area2.append(versionNumber);
	
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



