package be.lode.jukebox.service.webservice;

import be.lode.jukebox.service.dto.JukeboxPaymentWSDTO;

/**
 * The Class PaymentInformation.
 */
public class PaymentInformation {

	/** The id. */
	private final long id;

	/** The payment information. */
	private final JukeboxPaymentWSDTO paymentInformation;

	/**
	 * Instantiates a new payment information.
	 *
	 * @param id
	 *            the id
	 * @param paymentInformation
	 *            the payment information
	 */
	public PaymentInformation(long id, JukeboxPaymentWSDTO paymentInformation) {
		super();
		this.id = id;
		this.paymentInformation = paymentInformation;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the payment information.
	 *
	 * @return the payment information
	 */
	public JukeboxPaymentWSDTO getPaymentInformation() {
		return paymentInformation;
	}

}
