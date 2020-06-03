
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

//author: @Ella
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
				backButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myHouse.back();
					}
				});
				backPanel.add(backButton);
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
				JFileChooser myChooser = new JFileChooser(".");
				String newDocumentName = JOptionPane.showInputDialog( null, "Enter name for new appliance: ", "New Appliance Name", JOptionPane.PLAIN_MESSAGE);
		        final int check =  myChooser.showOpenDialog(this);
		        File newFile = null;
		        if (check == JFileChooser.APPROVE_OPTION)
		        {
		            newFile = myChooser.getSelectedFile();
		        }
		        myAppliance.create(newDocumentName,newFile);
				newButton(newDocumentName);
				repaint();
				revalidate();
				repaint();
				revalidate();
			}
			
			private void deleteDocument() {
//				String deleteApplianceName = JOptionPane.showInputDialog( null, "Enter name of appliance to be deleted: ", "Delete Appliance", JOptionPane.PLAIN_MESSAGE);
//				myDocument.destroy(deleteApplianceName);			
//				startButtons();
//				repaint();
//				revalidate();
				try {
					House.saveHouse(myHouse, "houseFile.hf");
				} catch (IOException e) {
					e.printStackTrace();
				}
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
						System.out.println(myAppliance.getDocument(name).getFile());
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