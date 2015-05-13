package be.lode.jukebox.service.webservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AllArtistsTest {

	@Test
	public void test() {
		List<String> insertList = new ArrayList<String>();
		insertList.add("a");
		insertList.add("b");
		insertList.add("c");
		insertList.add("d");
		AllArtists aa = new AllArtists(7, insertList);
		assertEquals(insertList, aa.getAllArtists());
		assertEquals(7, aa.getId());
	}

}
