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
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import superawsomesomethingsomethig.Room;

/*
 * Room_UI displays the rooms and works with the House class
 * @author Ella
 */
public class Room_UI extends JFrame
{

	private final JTextField addRoomName;
	private JPanel roomPanel;
	private List<Room> myRoomList;
	private String newRoomName;
	private House myHouse;
	private JPanel buttonPanel;
	private JPanel backPanel;
	private String helpMessage;



	/*
	 * Constructor
	 * @param roomList (list of rooms from House class
	 * @param house (house object) 
	 */
	public Room_UI(List<Room> roomList, House house)
	{
		super("Rooms");
		roomPanel = new JPanel();
		buttonPanel = new JPanel();
		backPanel = new JPanel();
		myHouse = house;
		myRoomList = roomList;
		addRoomName = new JTextField("New Room Name: ");
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
		setUpRoomPanel();
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
		roomPanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
		add(roomPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(backPanel, BorderLayout.SOUTH);
		repaint();
		revalidate();


	}

	/*
	 * Sets up the room panel. This is where the buttons are to add a new room or to delete a room are located
	 */
	private void setUpRoomPanel()
	{
		JLabel rooms = new JLabel("Room List: ");
		rooms.setBackground(Color.WHITE);
		rooms.setFont((new Font("Chalkboard", Font.BOLD, 32)));
		roomPanel.add(rooms);
		JButton addRoom = new JButton("Add Room");

		addRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newRoom();	//newroom method called if addroom button is clicked 
			}
		});

		JButton removeRoom = new JButton("Remove Room");
		removeRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRoom(); //deleteroom method called if removeroom button is clicked
			}
		});
		roomPanel.add(addRoom);
		roomPanel.add(removeRoom);
	}

	/*
	 * Called if the addRoom button is clicked on the GUI by the user 
	 */
	private void newRoom() {
		boolean isEmpty = false;
		String addRoomName = JOptionPane.showInputDialog( null, "Enter name for new room: ", "New Room Name", JOptionPane.PLAIN_MESSAGE);

		//checks if user hit cancel on the option pane (this check prevents null pointer exceptions from occurring)
		if (addRoomName != null) {
			if (addRoomName.isEmpty()) {
				isEmpty = true;		//sets boolean to true meaning that the user didn't enter a room name
				//i.e. empty string was used
			}

			//only go through the process of a new room if the user didn't hit cancel 
			//and the user gave a name (no empty strings allowed)
			if (addRoomName != null && isEmpty == false) {

				//calls the create method from the house class 
				myHouse.create(addRoomName);
				//calls the newButton method 
				newButton(addRoomName);
				repaint();
				revalidate();

				//IGNORE THIS
				if (addRoomName.equals("Carole Baskin")) {
					easterEgg();
				}
			}
		}
	}

	/*
	 * If user hits the removeRoom button in the GUI this is called. 
	 */
	private void deleteRoom() {
		String deleteRoomName = JOptionPane.showInputDialog( null, "Enter name of room to be deleted: ", "Delete Room", JOptionPane.PLAIN_MESSAGE);
		//destroy method in House class is called 
		//(the house class checks + catches errors similar to our add room check above) 
		myHouse.destroy(deleteRoomName);			
		startButtons();
		repaint();
		revalidate();
	}

	/*
	 * Method to create a new button to display on button panel on the Room Jframe
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

		//action listener if a room button is clicked on by user then the appliance UI will be called
		roomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Room tempRoom = myHouse.getRoom(name);
				//generate UI called from house class
				myHouse.generateUI(myHouse.getRoom(name));
			}
		});

		pack();
		repaint();
		revalidate();
	}

	/*
	 * This method is called to generate buttons based on rooms that were added previously and saved in house file
	 */
	private void startButtons()
	{
		//first clear the panel of any buttons
		buttonPanel.removeAll();
		//add all buttons in the room list back in (if list is empty then nothing will be added) 
		for(Iterator<Room> listIterator = myRoomList.iterator(); listIterator.hasNext();)
		{
			Room temp = listIterator.next();
			//calls the new Button method in the ROOM_UI class
			newButton(temp.getName());
		}
	}

	/*
	 * If user tries to delete a room that doesn't exist this pops up 
	 * This method is called from house class
	 */
	static void errorMessage() {
		String errorMessage = "The room you tried to remove does not exist";
		JOptionPane.showMessageDialog(null, errorMessage, "ERROR!", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	 * This method sets up the bottom panel of JFRAME and adds a back button to go back to the homescreen
	 * and a help button if the user needs assistance operating the UI 
	 */
	private void setUpBackPanel() {
		helpMessage = "havent we helped you enough Bob";
		JButton backButton = new JButton("back");
		JButton helpButton = new JButton("help");
		helpMessage = "havent we helped you enough Bob";

		//back button operations
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeScreen homeScreen = new HomeScreen();
				//makes home screen visible
				homeScreen.setVisible(true);
				//makes room_UI not visible
				setVisible(false);
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
	 * IGNORE THIS
	 */
	private void easterEgg() {
		JOptionPane.showMessageDialog(null, "killed her husband", "Carole Baskins", JOptionPane.PLAIN_MESSAGE);
	}


}
