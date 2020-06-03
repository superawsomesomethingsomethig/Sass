package superawsomesomethingsomethig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
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
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ImageJPanel(image);
	}
	
	public static class ImageJPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 10L;
		transient final BufferedImage image;
		ImageJPanel(BufferedImage image) {
			super();
			this.image = image;
			if (this.image != null) {
				setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (image != null) {
				g.drawImage(image, 0, 0, this);
			}
		}
	}
}
