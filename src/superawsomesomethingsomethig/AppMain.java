package superawsomesomethingsomethig;
//import superawsomesomethingsomethig.Settings;

// Class!
public class AppMain 
{
	public static void main(String[] args) 
	{
		HomeScreen homeScreen = new HomeScreen();
		homeScreen.setVisible(true);
		Settings setting = new Settings("Wesley", "Email");
		setting.exportFile("outputfile.txt");
		Settings setting2 = new Settings("outputfile.txt");
		setting2.exportFile("outputfile2.txt");
	}
}
