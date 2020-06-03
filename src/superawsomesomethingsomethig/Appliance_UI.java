
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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Applaince_UI displays the appliances and works with the Room class
 * @author Ella
 */
public class Appliance_UI extends JFrame{

	private JPanel appliancePanel;
	private JPanel buttonPanel;
	private JTextField addApplianceName;
	private Room myRoom;
	private List<Appliance> myApplianceList;
	private House myHouse;
	private JPanel backPanel;
	private String helpMessage;


	/*
	 * Constructor
	 * @param currentRoom (reference to room object that the appliances are in) 
	 * @param house (house object) 
	 */
	public Appliance_UI(Room currentRoom, House house)
	{
		super("Appliances");
		appliancePanel = new JPanel();
		buttonPanel = new JPanel();
		backPanel = new JPanel();
		myRoom = currentRoom;
		myHouse = house;
		myApplianceList = currentRoom.getList();
		addApplianceName = new JTextField("New Appliance Name: ");
		start();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/*
	 * Method that calls all methods to set up frame/panels
	 */
	private void start() 
	{
		setIconImage(new ImageIcon("./icons/icon.png").getImage());
		setVisible(true);
		setUpFrame();
		setUpAppliancePanel();
		setUpBackPanel();
		pack();
		setLocationRelativeTo(null);
		startButtons();     

	}

	/*
	 * Adds panels and sets background (sets up the frame)
	 */
	private void setUpFrame()
	{
		setPreferredSize(new Dimension(800, 500));
		appliancePanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
		add(appliancePanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(backPanel, BorderLayout.SOUTH);
		repaint();
		revalidate();
	}
	
	/*
	 * This method sets up the bottom panel of JFRAME and adds a back button to go back to the room_UI
	 * and a help button if the user needs assistance operating the UI 
	 */
	private void setUpBackPanel() {
		JButton backButton = new JButton("back");
		JButton helpButton = new JButton("help");
		helpMessage = "havent we helped you enough Bob";
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//calls back method from inside house class
				myHouse.back();
			}
		});

		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, helpMessage, "help", JOptionPane.PLAIN_MESSAGE);
			}
		});
		backPanel.add(backButton);
		backPanel.add(helpButton);
	}
	
	/*
	 * Sets up the appliance panel. This is where the buttons are to add a new appliance
	 * or to delete an existing appliance
	 */
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
				newAppliance();		//newAppliance method called if addAppliance button is clicked 
			}
		});

		JButton removeAppliance = new JButton("Remove Appliance");
		removeAppliance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAppliance();	//deleteAppliance method called if removeAppliance button is clicked 
			}
		});
		appliancePanel.add(addAppliance);
		appliancePanel.add(removeAppliance);
		pack();
	}
	
	/*
	 * Called if the addAppliance button is clicked on the GUI by the user 
	 */
	private void newAppliance() {
		boolean isEmpty = false;
		String addApplianceName = JOptionPane.showInputDialog( null, "Enter name for new appliance: ", "New Appliance Name", JOptionPane.PLAIN_MESSAGE);
		
		//checks if user hit cancel on the option pane (this check prevents null pointer exceptions from occurring)
		if (addApplianceName != null) {
			if (addApplianceName.isEmpty()) {
				isEmpty = true; //sets boolean to true meaning that the user didn't enter an appliance name
				//i.e. empty string was used
			}
			
			//only go through the process of a new appliance if the user didn't hit cancel 
			//and the user gave a name (no empty strings allowed)
			if (addApplianceName != null && isEmpty == false) {
				
				//calls the create method from the room class 
				myRoom.create(addApplianceName);
				//calls the newButton method 
				newButton(addApplianceName);
				repaint();
				revalidate();
				try {
					House.saveHouse(myHouse, "houseFile.hf");
				} catch (IOException e) {
					e.printStackTrace();
				}
				repaint();
				revalidate();

				//IGNORE THIS
				if (addApplianceName.equals("Jeffrey Epstein")) {
					easterEgg();
				}
			}
		}
	}
	
	/*
	 * If user hits the removeAppliance button in the GUI this is called. 
	 */
	private void deleteAppliance() {
		String deleteApplianceName = JOptionPane.showInputDialog( null, "Enter name of appliance to be deleted: ", "Delete Appliance", JOptionPane.PLAIN_MESSAGE);
		//destroy method in Room class is called 
				//(the room class checks + catches errors similar to our add appliance check above)
		myRoom.destroy(deleteApplianceName);	
		myApplianceList = myRoom.getList();
		startButtons();
		repaint();
		revalidate();
		try {
			House.saveHouse(myHouse, "houseFile.hf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//repaint();
		//revalidate();
	}
	
	/*
	 * Method to create a new button to display on button panel on the Appliance Jframe
	 * @param name is the name of the new button to be created (this name is given from user input) 
	 */
	private void newButton(String name) {
		//new button created 
		JButton roomButton = new JButton(name);
		buttonPanel.add(roomButton);
		
		//button formatting 
		BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		buttonPanel.setLayout(boxLayout1);
		roomButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		roomButton.setFocusable(false);
		//action listener if an appliance button is clicked on by user then the document UI will be called
		roomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(name);
				myHouse.generateUI(myRoom.getAppliance(name));
			}
		});

		pack();
		repaint();
		revalidate();
	}

	/*
	 * This method is called to generate buttons based on appliances that were added previously and saved in house file
	 */
	private void startButtons()
	{
		//first clear the panel of any buttons
		buttonPanel.removeAll();
		//add all buttons in the appliance list back in (if list is empty then nothing will be added)
		for(Iterator<Appliance> listIterator = myApplianceList.iterator(); listIterator.hasNext();)
		{

			Appliance temp = listIterator.next();
			System.out.println(temp.getName());
			//calls the new Button method in the APPLIANCE_UI class
			newButton(temp.getName());
		}
	}

	/*
	 * If user tries to delete an appliance that doesn't exist this pops up 
	 * This method is called from room class
	 */
	static void errorMessage() {
		String errorMessage = "The appliance you tried to remove does not exist";
		JOptionPane.showMessageDialog(null, errorMessage, "ERROR!", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	 * IGNORE THIS
	 */
	private void easterEgg() {
		JOptionPane.showMessageDialog(null, "didn't kill himself", "Jeffrey Epstein", JOptionPane.PLAIN_MESSAGE);
	}

}