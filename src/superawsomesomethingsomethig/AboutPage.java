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
public class AboutPage extends JFrame{
	
	private JPanel aboutPanel;
	private JPanel versionPanel;
	
	//constructor
	public AboutPage() 
	{
		super("About Page");
		aboutPanel = new JPanel();
		versionPanel = new JPanel();
		start();
	}	
	
	//author: @Timmy
	private void start() 
	{
		setVisible(true);
		setUpFrame();
		setUpAboutPanel();
		setUpVersionPanel();
        pack();
        setLocationRelativeTo(null);

	}
	
	//author: @Timmy
	private void setUpFrame()
	{
		//setPreferredSize(new Dimension(400, 300));
		add(aboutPanel, BorderLayout.CENTER);
		add(versionPanel, BorderLayout.SOUTH);
		
		
	}
	//author1: @Timmy
	//author2: @Ella
	//author3: @Sam
	//author4: @Wesley
	private void setUpAboutPanel()
	{

		final JTextArea area1 = new JTextArea();
		area1.setBackground(Color.WHITE);
		area1.setText("Developers:\nTimmy Roma\nElla Gainey\nSam Spillers\nWesley Elliott");
		Font font = new Font("Chalboard", Font.PLAIN,15);
		area1.setFont(font);
		area1.setEditable(false);
		aboutPanel.add(area1);
		
	}
	
	//author: @Ella
	private void setUpVersionPanel()
	{
		
		final JTextArea area2 = new JTextArea("Version:\n ");
		area2.setEditable(false);
		versionPanel.add(area2);
		Properties prop = new Properties();
		InputStream input = null;
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



