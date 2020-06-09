package superawsomesomethingsomethig;

import java.io.File;
import java.io.Serializable;


/**
 * Document class represents a single stored document.
 * @author Sam Spillers
 */
public class Document implements Serializable
{
	/**
	 * Default Serial UID for Document
	 */
	private static final long serialVersionUID = 4L;
	/**
	 * The name of this document.
	 */
	private String name;
	/**
	 * The file this document is associated with. The file this document is displaying/representing.
	 */
	private File file;

	/**
	 * Initializes a new Document object with the given name and file.
	 * @param name The String name of the object to create.
	 * @param file The file this Document is associated with.
	 */
	public Document(String name, File file)
	{
		this.name = name;
		this.file = file;
	}
	/**
	 * Gets the name of this Document.
	 * @return The name of this Document.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of this Document.
	 * @param name The new name of this Document.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the File associated with this Document.
	 * @return The File.
	 */
	public File getFile() {
		return file;
	}
	/**
	 * Set the File associated with this Document.
	 * @param file The file to associate with this Document.
	 */
	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * Gets the String representation of this Document.
	 * @return The String representation of this Document.
	 */
	public String toString() {
		return "Document(\"" + name + "\")";
	}
}
