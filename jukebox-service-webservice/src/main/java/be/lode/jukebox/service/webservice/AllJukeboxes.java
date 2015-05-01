package be.lode.jukebox.service.webservice;

import java.util.List;

public class AllJukeboxes {
	private final long id;
	private final List<String> allJukeboxes;

	public AllJukeboxes(long id, List<String> allJukeboxes) {
		super();
		this.id = id;
		this.allJukeboxes = allJukeboxes;
	}

	public long getId() {
		return id;
	}

	public List<String> getAllJukeboxes() {
		return allJukeboxes;
	}
}
