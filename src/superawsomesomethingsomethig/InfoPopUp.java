package superawsomesomethingsomethig;

import javax.swing.JOptionPane;


/*
 * @author Ella
 * helper class to display messages to user when importing/exporting settings
 */
public class InfoPopUp {
	
	public static void importInfoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null,  infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void exportInfoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null,  infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
	}

}
