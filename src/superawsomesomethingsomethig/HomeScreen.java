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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;










@SuppressWarnings("serial")
public class HomeScreen extends JFrame 
{
	private JPanel homePanel;
	private JPanel buttonPanel;
	private JButton aboutButton;
	private JButton settingsButton;
	//private aboutPage about;
	public HomeScreen() 
	{
		super("H.O.M.E");
		setLayout(new BorderLayout());
		start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void start()
	{
		setUpHomePanel();
		setUpButtonPanel();
		setUpFrame();
		pack();
		setLocationRelativeTo(null);
	}
	
	//author 1: @Timmy
	//author 2: @Ella
	private void setUpFrame()
	{
		setPreferredSize(new Dimension(800, 500));
		add(homePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		

		
		
	}
	//author 1: @Timmy
	//author 2: @Ella
	private void setUpHomePanel()
	{
		homePanel = new JPanel();
		homePanel.setLayout(new BorderLayout());
		//JLabel homeLabel = new JLabel("H.O.M.E");
		//this button is pressed to open the application's main functionality 
		JButton homeButton = new JButton("H.O.M.E");
		homeButton.setFont((new Font("Chalkboard", Font.BOLD, 48)));
		homeButton.setHorizontalAlignment(SwingConstants.CENTER);
		homePanel.add(homeButton, BorderLayout.CENTER);
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new House();
			}
		});
		
		//generate background
//		ImageIcon image = new ImageIcon("background/background.jpg");
//		JLabel label = new JLabel("", image, JLabel.CENTER);
//		homePanel.add( label, BorderLayout.CENTER );
		
		//Color homeColor = new Color(0,160,180);
		homePanel.setBackground(Color.WHITE);
	}
	
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
