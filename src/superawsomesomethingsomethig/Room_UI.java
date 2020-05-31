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
import java.util.List;
import java.util.Scanner;

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

//@Ella
public class Room_UI extends JFrame
{
	private final JTextField addRoomName;
	private JPanel roomPanel;
	private List<Room> roomList;
	private String newRoomName;
	private House myHouse;
	private JPanel buttonPanel;
	private boolean isDelete;
	

		//constructor
		public Room_UI(List<Room> roomList, House house)
		{
			super("Rooms");
			roomPanel = new JPanel();
			buttonPanel = new JPanel();
			myHouse = house;
			isDelete = false;
			roomList = this.roomList;
			addRoomName = new JTextField("New Room Name: ");
			start();	
		
	}
		private void start() 
		{
			setVisible(true);
			setUpFrame();
			setUpRoomPanel();
	        pack();
	        setLocationRelativeTo(null);
	        

		}
		
		
		private void setUpFrame()
		{
			setPreferredSize(new Dimension(800, 500));
			roomPanel.setBackground(Color.WHITE);
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
			String addRoomName = JOptionPane.showInputDialog( null, "Enter name for new room: ", "New Room Name", JOptionPane.PLAIN_MESSAGE);
			myHouse.create(addRoomName);
			newButton(addRoomName);
			repaint();
			revalidate();
		}
		
		private void deleteRoom() {
//			String deleteRoomName = JOptionPane.showInputDialog( null, "Enter name of room to be deleted: ", "Delete Room", JOptionPane.PLAIN_MESSAGE);
//			Room delete = myHouse.getRoom(deleteRoomName);
//			myHouse.destroy(delete);
			isDelete = true;
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
					//myHouse.generateUI(myHouse.getRoom(name));
				}
			});
	        
	        pack();
			repaint();
			revalidate();
		}
		
		
		
}
