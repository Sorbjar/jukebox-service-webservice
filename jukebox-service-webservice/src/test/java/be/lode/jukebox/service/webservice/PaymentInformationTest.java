package be.lode.jukebox.service.webservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.lode.jukebox.service.dto.JukeboxPaymentWSDTO;

public class PaymentInformationTest {

	@Test
	public void test() {
		JukeboxPaymentWSDTO o1 = new JukeboxPaymentWSDTO();
		o1.setCurrencyCode("c1");
		o1.setEmail("e1");
		o1.setId("i1");
		o1.setName("n1");
		o1.setPricePerSong("p1");

		PaymentInformation pi = new PaymentInformation(7, o1);
		assertEquals(o1, pi.getPaymentInformation());
		assertEquals(7, pi.getId());
	}

}
