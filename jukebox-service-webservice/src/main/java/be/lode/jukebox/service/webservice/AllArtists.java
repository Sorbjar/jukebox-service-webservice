package be.lode.jukebox.service.webservice;

import java.util.List;

public class AllArtists {
	private final long id;
	private final List<String> allArtists;

	public AllArtists(long id, List<String> allArtists) {
		super();
		this.id = id;
		this.allArtists = allArtists;
	}

	public long getId() {
		return id;
	}

	public List<String> getAllArtists() {
		return allArtists;
	}
}
