package be.lode.jukebox.service.webservice;

import java.util.List;

import be.lode.jukebox.service.dto.JukeboxWSDTO;

/**
 * The Class AllJukeboxes.
 */
public class AllJukeboxes {

	/** The all jukeboxes. */
	private final List<JukeboxWSDTO> allJukeboxes;

	/** The id. */
	private final long id;

	/**
	 * Instantiates a new all jukeboxes.
	 *
	 * @param id
	 *            the id
	 * @param allJukeboxes
	 *            the all jukeboxes
	 */
	public AllJukeboxes(long id, List<JukeboxWSDTO> allJukeboxes) {
		super();
		this.id = id;
		this.allJukeboxes = allJukeboxes;
	}

	/**
	 * Gets the all jukeboxes.
	 *
	 * @return the all jukeboxes
	 */
	public List<JukeboxWSDTO> getAllJukeboxes() {
		return allJukeboxes;
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
