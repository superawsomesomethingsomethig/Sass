import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import superawsomesomethingsomethig.Settings;

class SettingsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testImportAndExport () {
		Settings setting = new Settings("Wesley", "Email");
		setting.exportFile("outputfile.txt");
		Settings setting2 = new Settings("outputfile.txt");
		Assert.assertEquals(setting.getFirstName(),setting2.getFirstName());
		Assert.assertEquals(setting.getEmail(),setting2.getEmail());
	}

}
