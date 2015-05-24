package be.lode.jukebox.service.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class WebServiceController.
 */
@RestController
public class WebServiceController {

	/** The counter. */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * Gets the all artists.
	 *
	 * @return the all artists
	 */
	@RequestMapping("/allartists")
	public AllArtists getAllArtists() {
		return new AllArtists(counter.incrementAndGet(),
				new WebServiceManager().getAllArtists());
	}

	/**
	 * Gets the all jukeboxes.
	 *
	 * @param serviceName
	 *            the service name
	 * @param serviceId
	 *            the service id
	 * @return the all jukeboxes
	 */
	@RequestMapping("/alljukeboxes")
	public AllJukeboxes getAllJukeboxes(
			@RequestParam(value = "servicename", defaultValue = "") String serviceName,
			@RequestParam(value = "serviceid", defaultValue = "") String serviceId) {
		return new AllJukeboxes(counter.incrementAndGet(),
				new WebServiceManager().getAllJukeboxes(serviceName, serviceId));
	}

	/**
	 * Gets the all titles.
	 *
	 * @param artist
	 *            the artist
	 * @return the all titles
	 */
	@RequestMapping("/alltitles")
	public AllTitles getAllTitles(
			@RequestParam(value = "artist", defaultValue = "") String artist) {
		return new AllTitles(counter.incrementAndGet(),
				new WebServiceManager().getAllTitles(artist));
	}

	/**
	 * Gets the payment information.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @return the payment information
	 */
	@RequestMapping("/paymentinformation")
	public PaymentInformation getPaymentInformation(
			@RequestParam(value = "jukeboxid", defaultValue = "") String jukeboxId) {
		return new PaymentInformation(counter.incrementAndGet(),
				new WebServiceManager().getPaymentInformation(jukeboxId));
	}

	/**
	 * Order song.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @param artist
	 *            the artist
	 * @param title
	 *            the title
	 */
	@RequestMapping("/ordersong")
	public void orderSong(
			@RequestParam(value = "jukeboxid", defaultValue = "") String jukeboxId,
			@RequestParam(value = "artist", defaultValue = "") String artist,
			@RequestParam(value = "title", defaultValue = "") String title) {
		new WebServiceManager().orderSong(jukeboxId, artist, title);
	}

	/**
	 * Register customer.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @param serviceName
	 *            the service name
	 * @param serviceId
	 *            the service id
	 * @return true, if successful
	 */
	@RequestMapping("/registercustomer")
	public boolean registerCustomer(
			@RequestParam(value = "jukeboxid", defaultValue = "") String jukeboxId,
			@RequestParam(value = "servicename", defaultValue = "") String serviceName,
			@RequestParam(value = "serviceid", defaultValue = "") String serviceId) {
		return new WebServiceManager().registerCustomer(jukeboxId, serviceName,
				serviceId);
	}
}
