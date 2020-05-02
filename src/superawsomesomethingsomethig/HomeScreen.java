package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class HomeScreen extends JFrame 
{
	private JPanel homePanel;
	private JPanel buttonPanel;
	private JButton aboutButton;
	//private aboutPage about;
	public HomeScreen() 
	{
		super("H.O.M.E");
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
	private void setUpFrame()
	{
		add(homePanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		
	}
	private void setUpHomePanel()
	{
		homePanel = new JPanel();
		homePanel.add(new JLabel("HOME"));
		homePanel.setBackground(Color.WHITE);
	}
	private void setUpButtonPanel()
	{
		buttonPanel = new JPanel();
		aboutButton = new JButton("About");
    	aboutButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent theEvent)
            {	
            	new aboutPage();
            }
        });
    	buttonPanel.add(aboutButton);
	}
	

}
