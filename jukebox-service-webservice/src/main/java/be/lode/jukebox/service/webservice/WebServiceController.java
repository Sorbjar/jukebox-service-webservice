package be.lode.jukebox.service.webservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {
	private static final String greetingTemplate = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/allartists")
	public AllArtists getAllArtists() {
		return new AllArtists(counter.incrementAndGet(),
				new WebServiceManager().getAllArtists());
	}

	@RequestMapping("/alltitles")
	public AllTitles getAllTitles(
			@RequestParam(value = "artist", defaultValue = "") String artist) {
		return new AllTitles(counter.incrementAndGet(),
				new WebServiceManager().getAllTitles(artist));
	}

	@RequestMapping("/alljukeboxes")
	public AllJukeboxes getAllJukeboxes(
			@RequestParam(value = "servicename", defaultValue = "") String serviceName,
			@RequestParam(value = "serviceid", defaultValue = "") String serviceId) {
		return new AllJukeboxes(counter.incrementAndGet(),
				new WebServiceManager().getAllJukeboxes(serviceName, serviceId));
	}

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(
				greetingTemplate, name));
	}
}
