package superawsomesomethingsomethig;

import java.io.IOException;

// Class!
public class AppMain 
{
	public static void main(String[] args) 
	{			
		
		// TODO: Delete the following. It is for saving/loading testing
		House house = null;
		try {
			house = House.loadHouse("houseFile.hf");
		} catch (IOException | ClassNotFoundException e) {
			house = new House();
		}

		Room room = house.create("testRoom2");
		Appliance appliance = room.create("testAppliance2");
		appliance.create("testDocument2");
		System.out.println(house);
		
		try {
			House.saveHouse(house, "houseFile.hf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO: Delete the above. It is for saving/loading testing

		
				
		HomeScreen homeScreen = new HomeScreen();
		homeScreen.setVisible(true);
	}
}
