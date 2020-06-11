import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import superawsomesomethingsomethig.Appliance;
import superawsomesomethingsomethig.House;
import superawsomesomethingsomethig.Room;
//@Wesley Elliott
class HouseTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// tests that Room can be added to list
	@Test
	void testAdd() {
		House house = new House();
		house.create("testRoom");
		Room room = house.getRoom("testRoom");
		assertEquals("testRoom", room.getName());

	}

	// tests that room can be deleted
	@Test
	void testDelete() {
		House house = new House();
		house.create("testRoom");
		assertEquals(1, house.getList().size());
		house.destroy("testRoom");
		assertEquals(0, house.getList().size());
	}

	// test for trying to delete room that doesn't exist
	@Test
	void testDeleteNonexistent() {
		House house = new House();
		house.destroy("nonexistentRoom");
		assertEquals(0, house.getList().size());
	}

	// test for adding multiple rooms
	@Test
	void testAddMultiple() {
		House house = new House();
		house.create("testRoom");
		house.create("testRoom2");
		assertEquals("testRoom", house.getRoom("testRoom").getName());
		assertEquals("testRoom2", house.getRoom("testRoom2").getName());
		assertEquals(2, house.getList().size());
	}

}
