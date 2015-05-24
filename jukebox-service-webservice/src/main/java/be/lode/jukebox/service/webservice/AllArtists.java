package be.lode.jukebox.service.webservice;

import java.util.List;

/**
 * The Class AllArtists.
 */
public class AllArtists {

	/** The all artists. */
	private final List<String> allArtists;

	/** The id. */
	private final long id;

	/**
	 * Instantiates a new all artists.
	 *
	 * @param id
	 *            the id
	 * @param allArtists
	 *            the all artists
	 */
	public AllArtists(long id, List<String> allArtists) {
		super();
		this.id = id;
		this.allArtists = allArtists;
	}

	/**
	 * Gets the all artists.
	 *
	 * @return the all artists
	 */
	public List<String> getAllArtists() {
		return allArtists;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
}
