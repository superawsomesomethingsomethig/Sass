import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import com.sun.prism.Image;

import superawsomesomethingsomethig.Document;
import superawsomesomethingsomethig.Document.ImageJPanel;

//@Wesley Elliott
class DocumentTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// tests that document was created and successfully saved file
	@Test
	void testImageAndName() {

		File file = new File("./test/resources/test.jpg");
		Document doc = new Document("test", file);
		BufferedImage image = doc.getBufferedImage();
		assertEquals(225, image.getRaster().getHeight(), "Height should be 225");
		assertEquals(225, image.getRaster().getWidth(), "Width should be 225");
		System.out.println(image.toString());
		assertEquals("test", doc.getName(), "Name should be test");

	}

	// test for nonexistent path
	@Test
	void testNonexistentPath() {

		File file = new File("./test/resources/doesn'texist");
		Document doc = new Document("test", file);
		assertEquals(null, doc.getBufferedImage(), "image should be null");
	}
}
