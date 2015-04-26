package be.lode.jukebox.service.webservice;

import java.util.List;

public class AllTitles {
	private final long id;
	private final List<String> allTitles;

	public AllTitles(long id, List<String> allTitles) {
		super();
		this.id = id;
		this.allTitles = allTitles;
	}

	public long getId() {
		return id;
	}

	public List<String> getAllTitles() {
		return allTitles;
	}
}
