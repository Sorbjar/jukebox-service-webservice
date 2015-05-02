package be.lode.jukebox.service.webservice;

import java.util.List;

import be.lode.jukebox.service.dto.JukeboxWSDTO;

public class AllJukeboxes {
	private final long id;
	private final List<JukeboxWSDTO> allJukeboxes;

	public AllJukeboxes(long id, List<JukeboxWSDTO> allJukeboxes) {
		super();
		this.id = id;
		this.allJukeboxes = allJukeboxes;
	}

	public long getId() {
		return id;
	}

	public List<JukeboxWSDTO> getAllJukeboxes() {
		return allJukeboxes;
	}
}
