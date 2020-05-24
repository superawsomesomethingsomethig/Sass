package superawsomesomethingsomethig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Observable;
import java.util.Scanner;

public class Settings {

	private String firstName;
	private String email;

	// will construct new Settings object with given firstName and email
	public Settings(String firstName, String email) {
		this.firstName = firstName;
		this.email = email;

	}

	// will construct new Settings object from contents of imported file
	public Settings(String fileName) {
		importFile(fileName);
	}

	// exports Settings data to an output file
	public void exportFile(String fileName) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			writer.println(this.firstName);
			writer.println(this.email);
			
		
		} catch (FileNotFoundException e) {
			System.out.println("Could not create output file " + fileName);
		} catch (UnsupportedEncodingException e) {
			System.out.println(e);
		} finally {
			if(writer != null) {
				writer.close();
			}
		}

	}

	// imports Settings data from a given Settings file
	public void importFile(String fileName) {

		File file = new File("./" + fileName);
		try {

			Scanner in = new Scanner(file);
			setFirstName(in.nextLine());
			setEmail(in.nextLine());
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}

	// Sets the first name
	public void setFirstName(String name) {
		this.firstName = name;
	}

	// Sets the email
	public void setEmail(String email) {
		this.email = email;

	}

	// Returns the first name of the object
	public String getFirstName() {
		return this.firstName;
	}

	// Returns the email of the object
	public String getEmail() {
		return this.email;
	}
}
