import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import com.sun.prism.Image;

import superawsomesomethingsomethig.Document;

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
		assertEquals("test", doc.getName(), "Name should be test");
		// @Sam removed a couple lines here because the Appliance class was changed.
	}

	// test for nonexistent path
	@Test
	void testNonexistentPath() {

		File file = new File("./test/resources/doesn'texist");
		Document doc = new Document("test", file);
	}
}
