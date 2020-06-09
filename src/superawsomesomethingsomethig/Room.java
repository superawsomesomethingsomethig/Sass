package superawsomesomethingsomethig;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Room represents a room in a house, a room which has appliances.
 * @author Sam Spillers
 */
public class Room implements Serializable
{
	/**
	 * Default Serial UID for Room
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * The appliances in this room.
	 */
	private List<Appliance> applianceList;
	/**
	 * The name of this room.
	 */
	private String name;
	
	/**
	 * Initializes a Room object with the given name.
	 * @param name The name of the room object to create.
	 */
	public Room(String name)
	{
		applianceList = new LinkedList<>();
		this.name = name;
	}
	/**
	 * Gets the Appliances associated with this room.
	 * @return A list of the Appliance objects this room has.
	 */
	public List<Appliance> getList() {
		return new LinkedList<Appliance>(applianceList);  // List is copied to avoid editing errors
	}
	/**
	 * Create an appliance with the given name and add it to this room.
	 * @param applianceName The name of the appliance to be added.
	 * @return The appliance that was just created.
	 */
	public Appliance create(String applianceName) {
		Appliance appliance = new Appliance(applianceName);
		applianceList.add(appliance);
		return appliance;
	}
	/**
	 * Add the given appliance to this room.
	 * @param appliance The Appliance to add.
	 */
	public void create(Appliance appliance) {
		applianceList.add(appliance);
	}
	
	/**
	 * Destroy the appliance in this room with the given name. If no appliance with that name, UI error message is shown.
	 * @param name Name of appliance to remove.
	 */
	public void destroy(String name) 
	{
		int index = 0;
		boolean removed = false;
		for(Iterator<Appliance> listIterator = applianceList.iterator(); listIterator.hasNext();)
		{
			Appliance temp = listIterator.next();
			if(temp.getName().equals(name))
			{
				removed = true;
				applianceList.remove(index);
				break;
			}
			index++;
		}
		if(!removed)
		{
			Appliance_UI.errorMessage();
		}
	}

	/**
	 * Gets the name of this room.
	 * @return The String name of this room.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the appliance of the given name in this room. Returns null if the object doesn't exist.
	 * @param name Name of the appliance to get.
	 * @return The appliance of the given name in this room. null if no such object.
	 */
	public Appliance getAppliance(String name)
	{				
		for(Iterator<Appliance> listIterator = applianceList.iterator(); listIterator.hasNext();)
		{
			Appliance temp = listIterator.next();
			if(temp.getName() .equals(name))
			{
				return temp;
			}
		}
		return null;
		
	}
	
	/**
	 * Sets the name of this room object.
	 * @param name The new name of this room.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the String representation of his room object.
	 * @param Returns the string representation of this object.
	 */
	public String toString() {
		String output = "Room(\"" + name + "\")[ ";
		for (int i = 0; i < applianceList.size(); i++) {
			output += applianceList.get(i).toString();
			if (i < applianceList.size() - 1) {  // Fencepost check
				output += ", ";
			}
		}
		return output + " ]";
	}
}
