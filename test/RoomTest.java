import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import superawsomesomethingsomethig.Appliance;
import superawsomesomethingsomethig.Room;

//@Wesley Elliott
class RoomTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// tests that appliance can be added to list
	@Test
	void testAdd() {

		Room room = new Room("testRoom");
		room.create("testAppliance");
		Appliance app = room.getAppliance("testAppliance");
		assertEquals("testAppliance", app.getName());

	}

	// tests appliance can be deleted
	@Test
	void testDelete() {
		Room room = new Room("testRoom");
		room.create("testAppliance");
		assertEquals(1, room.getList().size());
		room.destroy("testAppliance");
		assertEquals(0, room.getList().size());
	}

	// test if trying to delete appliance that doesn't exist
	@Test
	void testDeleteNonexistent() {
		Room room = new Room("testRoom");
		room.destroy("nonexistentAppliance");
		assertEquals(0, room.getList().size());
	}

	// test for adding multiple appliances
	@Test
	void testAddMultiple() {
		Room room = new Room("testRoom");
		room.create("testApp");
		room.create("testApp2");
		assertEquals("testApp", room.getAppliance("testApp").getName());
		assertEquals("testApp2", room.getAppliance("testApp2").getName());
		assertEquals(2, room.getList().size());
	}

}
