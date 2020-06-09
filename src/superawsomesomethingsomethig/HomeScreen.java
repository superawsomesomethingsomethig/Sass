package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;










@SuppressWarnings("serial")

/*
 * HomeScreen is the home screen of our application + calls House/runner class
 * @author Timmy Roma 
 * @author Sam Spillers
 */
public class HomeScreen extends JFrame 
{
	ImageIcon icon = new ImageIcon("./icons/icon.png");
	private JPanel homePanel;
	private JPanel buttonPanel;
	private JButton aboutButton;
	private JButton settingsButton;
	private House theHouse;
	
	/*
	 * Constructor
	 */
	public HomeScreen() 
	{
		super("H.O.M.E");
		setLayout(new BorderLayout());
		start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//try to load house file (if none exists -> create new one)
		try {
			theHouse = House.loadHouse("houseFile.hf");
		} catch (IOException | ClassNotFoundException e) {
			theHouse = new House();
		}
	}
	
	/*
	 * Method that calls all methods to set up frame/panels
	 * @Timmy Roma
	 */
	private void start()
	{
		setIconImage(icon.getImage());
		setUpHomePanel();
		setUpButtonPanel();
		setUpFrame();
		pack();
		setLocationRelativeTo(null);
	}
	
	/*
	 * Adds panels and sets background (sets up the frame)
	 * @author Timmy Roma
	 * @author Ella Gainey
	 */
	private void setUpFrame()
	{
		setPreferredSize(new Dimension(800, 500));
		add(homePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/*
	 * Sets up the home panel. This is where user can see about screen, settings screen, and start application
	 * @author Timmy Roma
	 * @author Ella Gainey
	 */
	private void setUpHomePanel()
	{
		homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		//takes up whole panel and is pressed by user to start application
		JButton homeButton = new JButton("H.O.M.E");
		homeButton.setFont((new Font("Chalkboard", Font.BOLD, 48)));
		homeButton.setHorizontalAlignment(SwingConstants.CENTER);
		homePanel.add(homeButton, BorderLayout.CENTER);
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//calls start method from main house/runner class
				theHouse.start();
				setVisible(false); //makes home screen invisible so room ui can be seen
			}
		});
		homePanel.setBackground(Color.WHITE);
	}
	
	/*
	 * Method to set up buttons for about panel and settings panel
	 * @author ????
	 */
	private void setUpButtonPanel()
	{
		buttonPanel = new JPanel();
		aboutButton = new JButton("About");
		settingsButton = new JButton("Settings");
    	aboutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent)
            {	
            	new AboutPage();
            }
        });
    	settingsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent)
            {	
            	new SettingsScreen();
            }
        });
    	buttonPanel.add(aboutButton);
    	buttonPanel.add(settingsButton);
	}
	

}
