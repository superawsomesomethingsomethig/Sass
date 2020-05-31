
package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//author: @Ella
public class Appliance_UI extends JFrame{
	
	private JPanel appliancePanel;
	private JPanel buttonPanel;
	private JTextField addApplianceName;
	private Room myRoom;
	private Room myApplianceList;
	private House myHouse;

	//constructor
			public Appliance_UI(Room currentRoom, House house)
			{
				super("Appliances");
				appliancePanel = new JPanel();
				buttonPanel = new JPanel();
				myRoom = currentRoom;
				myHouse = house;
				//myApplianceList = currentRoom;
				addApplianceName = new JTextField("New Appliance Name: ");
				start();	
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
			
			private void start() 
			{
				setVisible(true);
				setUpFrame();
				setUpAppliancePanel();
		        pack();
		        setLocationRelativeTo(null);
				//startButtons();     

			}
			
			private void setUpFrame()
			{
				setPreferredSize(new Dimension(800, 500));
				appliancePanel.setBackground(Color.WHITE);
				add(appliancePanel, BorderLayout.NORTH);
				add(buttonPanel, BorderLayout.CENTER);
		        repaint();
				revalidate();
			}
			
			private void setUpAppliancePanel()
			{
				JLabel appliances = new JLabel(myRoom.getName().toUpperCase() + "'S Appliance List: " );
				appliances.setBackground(Color.WHITE);
			    appliances.setFont((new Font("Chalkboard", Font.BOLD, 28)));
				appliancePanel.add(appliances);
				JButton addAppliance = new JButton("Add Appliance");
				
				addAppliance.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						newAppliance();
					}
				});
				
				JButton removeAppliance = new JButton("Remove Appliance");
				removeAppliance.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						deleteAppliance();
					}
				});
				appliancePanel.add(addAppliance);
				appliancePanel.add(removeAppliance);
				pack();
			}
			
			private void newAppliance() {
				String addApplianceName = JOptionPane.showInputDialog( null, "Enter name for new appliance: ", "New Appliance Name", JOptionPane.PLAIN_MESSAGE);
				myRoom.create(addApplianceName);
				newButton(addApplianceName);
				repaint();
				revalidate();
			}
			
			private void deleteAppliance() {
				String deleteApplianceName = JOptionPane.showInputDialog( null, "Enter name of appliance to be deleted: ", "Delete Appliance", JOptionPane.PLAIN_MESSAGE);
				//myRoom.destroy(deleteApplianceName);			
				//startButtons();
				repaint();
				revalidate();
			}
			
			private void newButton(String name) {

				JButton roomButton = new JButton(name);
				buttonPanel.add(roomButton);
				BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
				buttonPanel.setLayout(boxLayout1);
				roomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		        roomButton.setFocusable(false);
		        roomButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(name);
						//myHouse.generateUI(myHouse.getRoom(name));
					}
				});
		        
		        pack();
				repaint();
				revalidate();
			}
			
//			private void startButtons()
//			{
//				buttonPanel.removeAll();
//				for(Iterator<Room> listIterator = myApplianceList.iterator(); listIterator.hasNext();)
//				{
//					Room temp = listIterator.next();
//					newButton(temp.getName());
//				}
//			}
			
			
}