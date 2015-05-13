package be.lode.jukebox.service.webservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.lode.setup.ResetDBSetupLiveData;
import be.lode.setup.ResetDBSetupTestData;

public class WebServiceManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ResetDBSetupTestData.run();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ResetDBSetupLiveData.run();
	}

	@Before
	public void setUp() throws Exception {
		ResetDBSetupTestData.run();
	}

	@Test
	public void testGetAllArtists() {
		assertNotNull(new WebServiceManager().getAllArtists());
		assertTrue(new WebServiceManager().getAllArtists().size() > 0);
	}

	@Test
	public void testGetAllTitles() {
		assertNotNull(new WebServiceManager().getAllTitles("artist"));
		assertTrue(new WebServiceManager().getAllTitles("artist").size() > 0);
	}

	@Test
	public void testGetAllJukeboxes() {
		assertNotNull(new WebServiceManager().getAllJukeboxes("facebook",
				"10153294269263586"));
		assertTrue(new WebServiceManager().getAllJukeboxes("facebook",
				"10153294269263586").size() > 0);
	}

	@Test
	public void testGetPaymentInformation() {
		assertNotNull(new WebServiceManager().getPaymentInformation("1"));
	}

}
