package superawsomesomethingsomethig;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Room implements Serializable
{
	/**
	 * Default Serial UID for Room
	 */
	private static final long serialVersionUID = 2L;
	private List<Appliance> applianceList;
	private String name;
	
	public Room(String name)
	{
		applianceList = new LinkedList<>();
		this.name = name;
	}
	public List<Appliance> getList() {
		return new LinkedList<Appliance>(applianceList);  // List is copied to avoid editing errors
	}
	public Appliance create(String applianceName) {
		Appliance appliance = new Appliance(applianceName);
		applianceList.add(appliance);
		System.out.println(applianceList);
		return appliance;
	}
	public void create(Appliance appliance) {
		applianceList.add(appliance);
	}
	
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

	public String getName() {
		return name;
	}
	
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
	
	public void setName(String name) {
		this.name = name;
	}
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
