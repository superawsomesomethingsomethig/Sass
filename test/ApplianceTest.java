import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import superawsomesomethingsomethig.Appliance;
import superawsomesomethingsomethig.Document;
//@Wesley Elliott
class ApplianceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// tests that document can be added to list
	@Test
	void testAdd() {
		File file = new File("./test/resources/test.jpg");
		Appliance appliance = new Appliance("testAppliance");
		appliance.create("testDoc", file);
		Document doc = appliance.getDocument("testDoc");
		assertEquals("testDoc", doc.getName(), "Name should be testDoc");
		// @Sam removed a couple lines here because the Appliance class was changed.
	}

	// tests that document can be deleted
	@Test
	void testDelete() {
		File file = new File("./test/resources/test.jpg");
		Appliance appliance = new Appliance("testAppliance");
		appliance.create("testDoc", file);
		assertEquals(1, appliance.getList().size());
		appliance.destroy("testDoc");
		assertEquals(0, appliance.getList().size());
	}

	// test for trying to delete document that doesn't exist
	@Test
	void testDeleteNonexistent() {
		Appliance appliance = new Appliance("testAppliance");
		appliance.destroy("nonexistentDoc");
		assertEquals(0, appliance.getList().size());
	}

	// test for adding multiple documents
	@Test
	void testAddMultiple() {
		File file = new File("./test/resources/test.jpg");
		Appliance appliance = new Appliance("testAppliance");
		appliance.create("testDoc", file);
		appliance.create("testDoc2", file);
		assertEquals("testDoc", appliance.getDocument("testDoc").getName());
		assertEquals("testDoc2", appliance.getDocument("testDoc2").getName());
		assertEquals(2, appliance.getList().size());
	}

}
