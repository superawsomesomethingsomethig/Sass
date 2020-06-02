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

//author: @Ella
public class Room_UI extends JFrame
{
	private final JTextField addRoomName;
	private JPanel roomPanel;
	private List<Room> myRoomList;
	private String newRoomName;
	private House myHouse;
	private JPanel buttonPanel;
	

		//constructor
		public Room_UI(List<Room> roomList, House house)
		{
			super("Rooms");
			roomPanel = new JPanel();
			buttonPanel = new JPanel();
			myHouse = house;
			myRoomList = roomList;
			addRoomName = new JTextField("New Room Name: ");
			start();	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		private void start() 
		{
			setVisible(true);
			setUpFrame();
			setUpRoomPanel();
	        pack();
	        setLocationRelativeTo(null);
			startButtons();
	        

		}
		
		
		private void setUpFrame()
		{
			setPreferredSize(new Dimension(800, 500));
			roomPanel.setBackground(Color.WHITE);
			buttonPanel.setBackground(Color.WHITE);
			add(roomPanel, BorderLayout.NORTH);
			add(buttonPanel, BorderLayout.CENTER);
	        repaint();
			revalidate();
			
			
		}
		
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
					newRoom();
				}
			});
			
			JButton removeRoom = new JButton("Remove Room");
			removeRoom.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					deleteRoom();
				}
			});
			roomPanel.add(addRoom);
			roomPanel.add(removeRoom);
		}
		
		private void newRoom() {
			boolean isEmpty = false;
			String addRoomName = JOptionPane.showInputDialog( null, "Enter name for new room: ", "New Room Name", JOptionPane.PLAIN_MESSAGE);
			if (addRoomName.isEmpty()) {
				isEmpty = true;
			}
			if (addRoomName != null && isEmpty == false) {
			
			myHouse.create(addRoomName);
			newButton(addRoomName);
			repaint();
			revalidate();
			}
		}
		
		private void deleteRoom() {
			String deleteRoomName = JOptionPane.showInputDialog( null, "Enter name of room to be deleted: ", "Delete Room", JOptionPane.PLAIN_MESSAGE);
			myHouse.destroy(deleteRoomName);			
			startButtons();
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
					Room tempRoom = myHouse.getRoom(name);
					System.out.println(tempRoom.getName());
					myHouse.generateUI(myHouse.getRoom(name));
					//setVisible(false);
				}
			});
	        
	        pack();
			repaint();
			revalidate();
		}
		
		
		private void startButtons()
		{
			buttonPanel.removeAll();
			for(Iterator<Room> listIterator = myRoomList.iterator(); listIterator.hasNext();)
			{
				Room temp = listIterator.next();
				newButton(temp.getName());
			}
		}
		
	   static void errorMessage() {
			String errorMessage = "The room you tried to remove does not exist";
			JOptionPane.showMessageDialog(null, errorMessage, "ERROR!", JOptionPane.PLAIN_MESSAGE);
		}
		
		
}
