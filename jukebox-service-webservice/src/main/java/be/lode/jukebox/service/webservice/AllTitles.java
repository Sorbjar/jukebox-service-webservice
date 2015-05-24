package be.lode.jukebox.service.webservice;

import java.util.List;

/**
 * The Class AllTitles.
 */
public class AllTitles {

	/** The all titles. */
	private final List<String> allTitles;

	/** The id. */
	private final long id;

	/**
	 * Instantiates a new all titles.
	 *
	 * @param id
	 *            the id
	 * @param allTitles
	 *            the all titles
	 */
	public AllTitles(long id, List<String> allTitles) {
		super();
		this.id = id;
		this.allTitles = allTitles;
	}

	/**
	 * Gets the all titles.
	 *
	 * @return the all titles
	 */
	public List<String> getAllTitles() {
		return allTitles;
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
