package be.lode.jukebox.service.webservice;

import java.util.List;
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
		WebServiceManager wsm = new WebServiceManager();
		List<String> allArtists = wsm.getAllArtists();
		return new AllArtists(counter.incrementAndGet(),
				allArtists);
	}

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(
				greetingTemplate, name));
	}
}
