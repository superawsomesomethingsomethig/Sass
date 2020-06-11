package superawsomesomethingsomethig;

import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Appliance is a class to represent an appliance and all the Documents associated with an appliance.
 * 
 * @author Sam Spillers
 *
 */
public class Appliance implements Serializable
{
	/**
	 * Default Serial UID for Appliance
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * The list of documents associated with this appliance
	 */
	private List<Document> documentList;
	/**
	 * The name of this appliance
	 */
	private String name;
	
	/**
	 * Initializes a new appliance object with the given name.
	 * @param name The name of this appliance object.
	 */
	public Appliance(String name)
	{
		documentList = new LinkedList<Document>();
		this.name = name;
	}
	/**
	 * Gets the list of documents associated with this appliance.
	 * @return The list of Document objects.
	 */
	public List<Document> getList() {
		return new LinkedList<Document>(documentList);  // List is copied to avoid editing errors
	}
	/**
	 * Creates a new document for this appliance with the given name and file.
	 * @param documentName The name of the new document.
	 * @param newFile The file for the new document.
	 */
	public void create(String documentName,File newFile) {
		Document document = new Document(documentName, newFile);
		documentList.add(document);
	}
	/**
	 * Adds the given Document to this appliance.
	 * @param document The given document to add.
	 */
	public void create(Document document) {
		documentList.add(document);
	}
	/**
	 * Removes the given document from this appliance.
	 * @param document The document to remove.
	 */
	public void destroy(Document document) {
		documentList.remove(document);
	}
	/**
	 * Removes the document with the given name from this appliance. If the document doesn't exist nothing happens.
	 * @param name The name of the document to remove.
	 */
	public void destroy(String name) {
		Document docToDestroy = null;
		for (int i = 0; i < documentList.size(); i++) {
			if (documentList.get(i).getName().equals(name)) {
				docToDestroy = documentList.get(i);
			}
		}
		if (docToDestroy != null) {  // If document was found
			destroy(docToDestroy);
		}
	}
	/**
	 * Gets the name of this appliance.
	 * @return The name of this object.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of this appliance.
	 * @param name The name ot set this object.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the string representation of this object.
	 * @return The string representation of this object
	 */
	public String toString() {
		String output = "Appliance(\"" + name + "\")[ ";
		for (int i = 0; i < documentList.size(); i++) {
			output += documentList.get(i).toString();
			if (i < documentList.size() - 1) {  // Fencepost check
				output += ", ";
			}
		}
		return output + " ]";
	}
	/**
	 * Gets the Document object associated with this appliance with the given name. Returns null if no document with that name exists in this appliance.
	 * @param name The name of the object to be found.
	 * @return The Document of the given name. Returns null if the document wasn't found.
	 */
	public Document getDocument(String name)
	{				
		for(Iterator<Document> listIterator = documentList.iterator(); listIterator.hasNext();)
		{
			Document temp = listIterator.next();
			if(temp.getName() .equals(name))
			{
				return temp;
			}
		}
		return null;
	}
}
