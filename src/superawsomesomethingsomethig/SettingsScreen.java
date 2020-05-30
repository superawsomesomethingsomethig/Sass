package superawsomesomethingsomethig;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Sam
 * A screen to display settings
 */
@SuppressWarnings("serial")
public class SettingsScreen extends JFrame {
	/**
	 * The default filename that settings are stored to
	 */
	public static final String DEFAULT_FILE_NAME = "settings.txt";
	
	private final Settings settings;
	private final JTextField fristNameField;
	private final JTextField emailField;
	
	/**
	 * Creates empty settings screen. If a settings file exists, it will automatically be loaded.
	 */
	public SettingsScreen() {
		super("Settings");
		fristNameField = new JTextField("First Name");
		emailField = new JTextField("Email");
		settings = new Settings("First Name", "Email");
		
		importSettings();
		setUpFrame();
	}
	
	/**
	 * Sets up the frame
	 */
	private void setUpFrame() {
		add(makeMainPanel());
		pack();
        setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Creates the main panel of the settings screen
	 * @return The main panel
	 */
	private JPanel makeMainPanel() {
		JPanel settingsPanel = new JPanel();
		settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.PAGE_AXIS));

		fristNameField.setPreferredSize(new Dimension(100, 20));
		fristNameField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				settings.setFirstName(fristNameField.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				settings.setFirstName(fristNameField.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				settings.setFirstName(fristNameField.getText());
			}
		});
		settingsPanel.add(makeRow(new JLabel("First Name:"), fristNameField));
		
		emailField.setPreferredSize(new Dimension(100, 20));
		emailField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				settings.setEmail(emailField.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				settings.setEmail(emailField.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				settings.setEmail(emailField.getText());
			}
		});
		settingsPanel.add(makeRow(new JLabel("Email:"), emailField));

		JButton importButton = new JButton("Import Settings");
		JButton exportButton = new JButton("Export Settings");
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importSettings();
				InfoPopUp.importInfoBox("Settings Imported!", "Settings");
			}
		});
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				settings.exportFile(DEFAULT_FILE_NAME);
				InfoPopUp.exportInfoBox("Settings Exported!", "Settings");
			}
		});
		settingsPanel.add(makeRow(importButton, exportButton));
		
		return settingsPanel;
	}
	
	/**
	 * Helper function to makeMainPanel. Makes a FlowLayout JPanel with the given components
	 * @param componentList Components to be put in a row
	 * @return The JPanel of the row of components
	 */
	private JPanel makeRow(JComponent ... componentList) {
		JPanel row = new JPanel();
		row.setLayout(new FlowLayout());
		for (JComponent component : componentList) {
			row.add(component);
		}
		return row;
	}
	
	/**
	 * Imports settings from the settingso object and updates test fields
	 */
	private void importSettings() {
		settings.importFile(DEFAULT_FILE_NAME);
		fristNameField.setText(settings.getFirstName());
		emailField.setText(settings.getEmail());
	}
	
// Spent WAY TO LONG trying to make this fancy thing work. I give up
//	private class GhostTextField extends JTextField {
//		private boolean empty;
//		private String defaultText;
//		
//		public GhostTextField(String defaultText) {
//			this.defaultText = defaultText;
//			empty = true;
//			setText(defaultText);
//			addFocusListener(new FocusListener() {
//				@Override
//				public void focusGained(FocusEvent e) {
//					setForeground(null);
//					if (empty) {
//						setText("");
//					}
//				}
//				@Override
//				public void focusLost(FocusEvent e) {
//					empty = false;
//					if (getText() == "") {
//						setForeground(Color.gray);
//						setText(defaultText);
//						empty = true;
//					}
//				}
//			});
//		}
//	}

// Spent even longer on this, just to realize it won't quite work as is. I give up
/*
	// Reference: https://www.geeksforgeeks.org/java-swing-creating-toast-message/
	private class Messager extends JFrame {
		public final static long MESSAGE_DURATION = 2000;  // In millis
		final private Queue<String> messageQueue;
		final JWindow window;
		private String currentString = "";
		private long lastUpdate;
		private boolean decaying = false;
		public Messager() {
			messageQueue = new LinkedList<String>();
			messageQueue.add("hi");
			window = new JWindow();
			window.setBackground(new Color(0,0,0,0));
			JPanel panel = new JPanel() {
				public void paint(Graphics g) {
					System.out.println(window.getOpacity());
					System.out.println("painting");
					
					int width = g.getFontMetrics().stringWidth(currentString);
					int height = g.getFontMetrics().getHeight();
					g.setColor(Color.black);
					g.fillRect(10, 10, width + 30, height + 10);
					g.setColor(Color.black);
					g.fillRect(10, 10, width + 30, height + 10);
					g.setColor(new Color(255, 255, 255, 240));
					g.drawString(currentString, 25, 27);
	                int t = 250; 
	                for (int i = 0; i < 4; i++) { 
	                    t -= 60; 
	                    g.setColor(new Color(0, 0, 0, t)); 
	                    g.drawRect(10 - i, 10 - i, width + 30 + i * 2, 
	                               height + 10 + i * 2); 
	                }
	                if (currentString != "") {  // If displaying message
		                if (System.currentTimeMillis() - lastUpdate > MESSAGE_DURATION) {  // If message has been displayed long enough
		                	decaying = true;  // Start decaying
			                lastUpdate = System.currentTimeMillis();
		                }
		                if (decaying) {  // If decaying
			                if (window.getOpacity() > 0) {  // And toast is visible
			                	window.setOpacity(window.getOpacity() - (System.currentTimeMillis() - lastUpdate) / 1000);  // Decrease opacity by amount of time passed
			                } else {  // If toast is not visible
			                	decaying = false;  // We are done decaying
			                	if (!messageQueue.isEmpty()) {  // If more messages to display, then display
				                	currentString = messageQueue.remove();
					                lastUpdate = System.currentTimeMillis();
					                window.setOpacity(1);
				                } else {  // Otherwise set to nothing
				                	currentString = "";
				                }
			                }
			                lastUpdate = System.currentTimeMillis();
		                }
	                } else if (!messageQueue.isEmpty()) {  // If not displaying message and there is a message to display
	                	currentString = messageQueue.remove();  // Display it
		                lastUpdate = System.currentTimeMillis();
		                window.setOpacity(1);
	                }
				}
			};
			window.add(panel);
			window.setLocation(300, 300);
			window.setSize(300, 300);
			window.setVisible(true);
			System.out.println("Constructed");
		}
		public void addMesssageToQueue(String message) {
			messageQueue.add(message);
			System.out.println(messageQueue);
		}
		private void displayMessage() {

			try {
				
				window.setOpacity(1);
				window.setVisible(true);
				Thread.sleep(2000);
				for (float o = 1; o > 0.2; o -= 0.1) {
					window.setOpacity(o);
					Thread.sleep(100);
				}
				window.setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!messageQueue.isEmpty()) {
				displayMessage();
			}
		}
	} */
}
