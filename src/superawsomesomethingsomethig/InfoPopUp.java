package superawsomesomethingsomethig;

import javax.swing.JOptionPane;


/*
 * Helper class to display messages to user when importing/exporting settings
 * @author Ella Gainey
 */
public class InfoPopUp {
	
	public static void importInfoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null,  infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void exportInfoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null,  infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
	}

}
