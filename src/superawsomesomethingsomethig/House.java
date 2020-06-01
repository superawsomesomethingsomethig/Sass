package superawsomesomethingsomethig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// @Timmy: I removed the main method that was here, since we already have one in AppMain.java.
// 		I also added some stuff to let this thing load and save
//	-Sam

public class House implements Serializable
{
	public static final String DEFAULT_FILENAME = "houseFile.hf";

	/**
	 * Default Serial UID for House
	 */
	private static final long serialVersionUID = 1L;
	private List<Room> roomList;
	private int level;
	private Room currentRoom;
	private Appliance currentAppliance;
	private Room_UI roomUI;
	private Appliance_UI applianceUI;
	private Document_UI documentUI;
	private String filename;
	
	
	public House() 
	{
		roomUI = null;
		applianceUI = null;
		documentUI = null;
		currentRoom = null;
		currentAppliance = null;
		roomList = new LinkedList<Room>();
		level = 0;
		filename = DEFAULT_FILENAME;
	}
	public void start()
	{
		level = 0;
		roomUI = new Room_UI(roomList,this);
	}
	public void generateUI(Object newObject)
	{
		if(level == 0)
		{
			level = 1;
			currentRoom = (Room) newObject;
			applianceUI = new Appliance_UI(currentRoom,this);
			roomUI.setVisible(false);
		}
		else if(level == 1)
		{
			level = 2;
			currentAppliance = (Appliance) newObject;
			documentUI = new Document_UI(currentAppliance,this);
			applianceUI.setVisible(false);
		}
	}
	public void back()
	{
		if(level == 2)
		{
			level = 1;
			//new Appliance_UI(currentRoom,this);
			applianceUI.setVisible(true);
			documentUI.setVisible(false);
		}
		if(level == 1)
		{
			level = 0;
			//new Room_UI(roomList,this);
			roomUI.setVisible(true);
			applianceUI.setVisible(false);
		}
	}
	public List<Room> getList() 
	{
		System.out.println("room list: " + roomList);
		return new LinkedList<Room>(roomList);  // List is copied to avoid editing errors
	}
	public Room create(String roomName) 
	{
		Room room = new Room(roomName);
		roomList.add(room);
		getList();
		try {
			House.saveHouse(this, filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return room;
	}
	public void create(Room room) 
	{
		roomList.add(room);
	}
	public void destroy(String name) 
	{
		int index = 0;
		boolean removed = false;
		for(Iterator<Room> listIterator = roomList.iterator(); listIterator.hasNext();)
		{
			Room temp = listIterator.next();
			//4System.out.println(temp.getName() + ',' + name);
			if(temp.getName().equals(name))
			{
				removed = true;
				roomList.remove(index);
				//System.out.println(temp.getName() + ',' + name);
				break;
			}
			index++;
		}
		if(!removed)
		{
			System.out.println("Room does not exist");
		}
		try {
			House.saveHouse(this, filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Room getRoom(String name)
	{				
		for(Iterator<Room> listIterator = roomList.iterator(); listIterator.hasNext();)
		{
			Room temp = listIterator.next();
			if(temp.getName() .equals(name))
			{
				return temp;
			}
		}
		return null;
		
	}
	
	public String getFilename() {
		return filename;
	}
//	public String toString() 
//	{
//		String output = "House[ ";
//		for (int i = 0; i < roomList.size(); i++) {
//			output += roomList.get(i).toString();
//			if (i < roomList.size() - 1) {  // Fencepost check
//				output += ", ";
//			}
//		}
//		return output + " ]";
//	}
	
	public static void saveHouse(House house, String fileName) throws IOException {
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(house);
		oout.close();
	}
	public static House loadHouse(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(fileName);
		ObjectInputStream oin = new ObjectInputStream(in);
		House house = (House) oin.readObject();
		oin.close();
		return house;
	}
}
