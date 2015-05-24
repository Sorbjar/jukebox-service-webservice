package be.lode.jukebox.service.webservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AllTitlesTest {

	@Test
	public void test() {
		List<String> insertList = new ArrayList<String>();
		insertList.add("a");
		insertList.add("b");
		insertList.add("c");
		insertList.add("d");
		AllTitles at = new AllTitles(7, insertList);
		assertEquals(insertList, at.getAllTitles());
		assertEquals(7, at.getId());
	}

}
