package be.lode.jukebox.service.webservice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import be.lode.jukebox.service.dto.JukeboxWSDTO;

public class AllJukeboxesTest {

	@Test
	public void test() {
		List<JukeboxWSDTO> insertList = new ArrayList<JukeboxWSDTO>();
		JukeboxWSDTO o1 = new JukeboxWSDTO();
		o1.setId("i1");
		o1.setName("n1");
		insertList.add(o1);
		JukeboxWSDTO o2 = new JukeboxWSDTO();
		o1.setId("i2");
		o1.setName("n2");
		insertList.add(o2);
		JukeboxWSDTO o3 = new JukeboxWSDTO();
		o1.setId("i3");
		o1.setName("n3");
		insertList.add(o3);
		JukeboxWSDTO o4 = new JukeboxWSDTO();
		o1.setId("i4");
		o1.setName("n4");
		insertList.add(o4);
		AllJukeboxes aj = new AllJukeboxes(7, insertList);
		assertEquals(insertList, aj.getAllJukeboxes());
		assertEquals(7, aj.getId());
	}

}
