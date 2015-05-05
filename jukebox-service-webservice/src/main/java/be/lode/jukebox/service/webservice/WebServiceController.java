package be.lode.jukebox.service.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/allartists")
	public AllArtists getAllArtists() {
		return new AllArtists(counter.incrementAndGet(),
				new WebServiceManager().getAllArtists());
	}

	@RequestMapping("/alljukeboxes")
	public AllJukeboxes getAllJukeboxes(
			@RequestParam(value = "servicename", defaultValue = "") String serviceName,
			@RequestParam(value = "serviceid", defaultValue = "") String serviceId) {
		return new AllJukeboxes(counter.incrementAndGet(),
				new WebServiceManager().getAllJukeboxes(serviceName, serviceId));
	}

	@RequestMapping("/alltitles")
	public AllTitles getAllTitles(
			@RequestParam(value = "artist", defaultValue = "") String artist) {
		return new AllTitles(counter.incrementAndGet(),
				new WebServiceManager().getAllTitles(artist));
	}

	@RequestMapping("/paymentinformation")
	public PaymentInformation getPaymentInformation(
			@RequestParam(value = "jukeboxid", defaultValue = "") String jukeboxId) {
		return new PaymentInformation(counter.incrementAndGet(),
				new WebServiceManager().getPaymentInformation(jukeboxId));
	}

	@RequestMapping("/ordersong")
	public void orderSong(
			@RequestParam(value = "jukeboxid", defaultValue = "") String jukeboxId,
			@RequestParam(value = "artist", defaultValue = "") String artist,
			@RequestParam(value = "title", defaultValue = "") String title) {
		new WebServiceManager().orderSong(jukeboxId, artist, title);
	}
}
