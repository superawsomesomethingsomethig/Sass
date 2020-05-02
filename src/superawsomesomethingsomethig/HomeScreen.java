package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame {
	
	private JPanel homePanel;
	private JButton aboutButton;
	public HomeScreen() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setSize(800,600);
		aboutButton = new JButton("About");
		homePanel = new Background();
		homePanel.add(new JLabel("HOME"));
		homePanel.add(aboutButton, new GridBagConstraints());
		aboutButton.addActionListener(new ButtonListener());
		homePanel.setBackground(Color.WHITE);
		add(homePanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static class Background extends JPanel {
		private Image image;
		public Background() {
			image = new ImageIcon("folder/m.jpg").getImage();
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}
}
