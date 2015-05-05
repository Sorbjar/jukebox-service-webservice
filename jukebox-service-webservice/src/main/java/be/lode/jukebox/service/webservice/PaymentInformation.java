package be.lode.jukebox.service.webservice;

import be.lode.jukebox.service.dto.JukeboxPaymentWSDTO;

public class PaymentInformation {

	private final long id;
	private final JukeboxPaymentWSDTO paymentInformation;

	public PaymentInformation(long id, JukeboxPaymentWSDTO paymentInformation) {
		super();
		this.id = id;
		this.paymentInformation = paymentInformation;
	}

	public long getId() {
		return id;
	}

	public JukeboxPaymentWSDTO getPaymentInformation() {
		return paymentInformation;
	}

}
