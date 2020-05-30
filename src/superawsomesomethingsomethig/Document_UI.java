package superawsomesomethingsomethig;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Document_UI extends JPanel implements Runnable, MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame theFrame;
	Thread thread;
	Document theDocument;
	
	public Document_UI()
	{
		theDocument = new Document();
		theFrame = new JFrame();
		thread = new Thread(this);
		thread.start();

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 500);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{

	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{

	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
	
	}

	@Override
	public void run() 
	{
		setUp();
		while(true)
		{
			
		}
	}
	public void setUp()
	{
		theFrame.add(this);
		theFrame.setBounds(0, 0, 700, 500);
	    theFrame.setVisible(true);
	    theFrame.setTitle("Tennis");
	    theFrame.setResizable(false);
	    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
