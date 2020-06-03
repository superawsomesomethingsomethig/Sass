
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
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Document_UI extends JFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;
	private JPanel documentPanel;
	private JPanel buttonPanel;
	private JTextField addDocumenteName;
	private Appliance myAppliance;
	private List<Document> myDocumentList;
	private House myHouse;
	private JPanel backPanel;
	private String helpMessage;
	private boolean isEmpty;

	//constructor
			public Document_UI(Appliance currentAppliance, House house)
			{
				super("Documents");
				documentPanel = new JPanel();
				buttonPanel = new JPanel();
				backPanel = new JPanel();
				myAppliance = currentAppliance;
				myHouse = house;
				myDocumentList = myAppliance.getList();
				addDocumenteName = new JTextField("New Appliance Name: ");
				start();	
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		}
			
			private void start() 
			{
				setIconImage(new ImageIcon("./icons/icon.png").getImage());
				setVisible(true);
				setUpFrame();
				setUpDocumentPanel();
				setUpBackPanel();
		        pack();
		        setLocationRelativeTo(null);
				startButtons();     

			}
			
			private void setUpFrame()
			{
				setPreferredSize(new Dimension(800, 500));
				documentPanel.setBackground(Color.WHITE);
				buttonPanel.setBackground(Color.WHITE);
				add(documentPanel, BorderLayout.NORTH);
				add(buttonPanel, BorderLayout.CENTER);
				add(backPanel, BorderLayout.SOUTH);
		        repaint();
				revalidate();
			}
			private void setUpBackPanel() {
				JButton backButton = new JButton("back");
				JButton helpButton = new JButton("help");
				helpMessage = "havent we helped you enough Bob";
				backButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myHouse.back();
					}
				});

				helpButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, helpMessage, "help", JOptionPane.PLAIN_MESSAGE);
					}
				});
				backPanel.add(backButton);
				backPanel.add(helpButton);
			}
			
			private void setUpDocumentPanel()
			{
				JLabel documents = new JLabel(myAppliance.getName().toUpperCase() + "'S Document List: " );
				documents.setBackground(Color.WHITE);
			    documents.setFont((new Font("Chalkboard", Font.BOLD, 28)));
				documentPanel.add(documents);
				JButton addDocument = new JButton("Add Document");
				
				addDocument.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						newDocument();
					}
				});
				
				JButton removeDocument = new JButton("Remove Document");
				removeDocument.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						deleteDocument();
					}
				});
				documentPanel.add(addDocument);
				documentPanel.add(removeDocument);
				pack();
			}
			
			private void newDocument() {
				String newDocumentName = JOptionPane.showInputDialog( null, "Enter name for new document: ", "New Document Name", JOptionPane.PLAIN_MESSAGE);
				if (newDocumentName != null) {
					if (newDocumentName.isEmpty()) {
						isEmpty = true;
					}
					if (newDocumentName != null && isEmpty == false) {
				JFileChooser myChooser = new JFileChooser(".");
		        int check =  myChooser.showOpenDialog(null);
		        File newFile = null;
		        if (check == JFileChooser.APPROVE_OPTION)
		        {
		            newFile = myChooser.getSelectedFile();
		        } 
		        myAppliance.create(newDocumentName, newFile);
					}
				try {
					House.saveHouse(myHouse, "houseFile.hf");
				} catch (IOException e) {
					e.printStackTrace();
				}
				repaint();
				revalidate();
				repaint();
				revalidate();
					}
			}
			
			
			private void deleteDocument() {
				String deleteDocumentName = JOptionPane.showInputDialog( null, "Enter name of appliance to be deleted: ", "Delete Appliance", JOptionPane.PLAIN_MESSAGE);
				myAppliance.destroy(deleteDocumentName);	
				myDocumentList = myAppliance.getList();
				try {
					House.saveHouse(myHouse, "houseFile.hf");
				} catch (IOException e) {
					e.printStackTrace();
				}		
				startButtons();
				repaint();
				revalidate();
			}
			
			private void newButton(String name) {

				JButton documentButton = new JButton(name);
				buttonPanel.add(documentButton);
				BoxLayout boxLayout1 = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
				buttonPanel.setLayout(boxLayout1);
				documentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		        documentButton.setFocusable(false);
		        documentButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myHouse.generateUI(myAppliance.getDocument(name));
					}
				});
		        
		        pack();
				repaint();
				revalidate();
			}
			
			private void startButtons()
			{
				buttonPanel.removeAll();
				for(Iterator<Document> listIterator = myDocumentList.iterator(); listIterator.hasNext();)
				{
					Document temp = listIterator.next();
					newButton(temp.getName());
				}
			}
			
			
}