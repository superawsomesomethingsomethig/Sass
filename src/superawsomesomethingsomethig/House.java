package superawsomesomethingsomethig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

// @Timmy: I removed the main method that was here, since we already have one in AppMain.java.
// 		I also added some stuff to let this thing load and save
//	-Sam

public class House implements Serializable
{

	/**
	 * Default Serial UID for House
	 */
	private static final long serialVersionUID = 1L;
	private List<Room> roomList;
	private int level;
	private Room currentRoom;
	private Appliance currentAppliance;
	
	
	
	public House() 
	{
		currentRoom = null;
		currentAppliance = null;
		roomList = new LinkedList<Room>();
		level = 0;
		new Room_UI(roomList,this);
	}
	public void generateUI(Object newObject)
	{
		if(level == 0)
		{
			level = 1;
			currentRoom = (Room) newObject;
			//new Appliance_UI(currentRoom,this);
		}
		else if(level == 1)
		{
			level = 2;
			//currentAppliance = newObject;
			//new Document_UI(currentAppliance,this);
		}
	}
	public void back()
	{
		if(level == 2)
		{
			level = 1;
			//new Appliance_UI(currentRoom,this);
		}
		if(level == 1)
		{
			level = 0;
			new Room_UI(roomList,this);
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
		return room;
	}
	public void create(Room room) 
	{
		roomList.add(room);
	}
	public void destroy(Room room) 
	{
		roomList.remove(room);
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
