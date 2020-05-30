package superawsomesomethingsomethig;

import java.io.Serializable;

public class Document implements Serializable
{
	/**
	 * Default Serial UID for Document
	 */
	private static final long serialVersionUID = 4L;
	private String name;
	
	public Document(String name)
	{
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Document(\"" + name + "\")";
	}
}
