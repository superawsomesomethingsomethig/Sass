package superawsomesomethingsomethig;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Appliance implements Serializable
{
	/**
	 * Default Serial UID for Appliance
	 */
	private static final long serialVersionUID = 3L;
	private List<Document> documentList;
	private String name;
	
	public Appliance(String name)
	{
		documentList = new LinkedList<Document>();
		this.name = name;
	}
	public List<Document> getList() {
		return new LinkedList<Document>(documentList);  // List is copied to avoid editing errors
	}
	public Document create(String documentName) {
		Document document = new Document(documentName, null);
		documentList.add(document);
		return document;
	}
	public void create(Document document) {
		documentList.add(document);
	}
	public void destroy(Document document) {
		documentList.remove(document);
	}
	public void destroy(String name) {
		Document docToDestroy = null;
		for (int i = 0; i < documentList.size(); i++) {
			if (documentList.get(i).getName().equals(name)) {
				docToDestroy = documentList.get(i);
			}
		}
		if (docToDestroy == null) {
			// TODO: Error. Doc not found
		} else {
			destroy(docToDestroy);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
}
