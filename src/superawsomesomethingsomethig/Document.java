package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.Serializable;

import javax.swing.JPanel;


public class Document implements Serializable
{
	/**
	 * Default Serial UID for Document
	 */
	private static final long serialVersionUID = 4L;
	private String name;
	private File file;

	public Document(String name)
	{
		this(name, null);
	}
	public Document(String name, File file)
	{
		this.name = name;
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String toString() {
		return "Document(\"" + name + "\")";
	}
	public JPanel displayFile() {
		JPanel output = new JPanel();
		output.setLayout(new BorderLayout());
		
		// TODO: This
		
		return null;
	}
}
