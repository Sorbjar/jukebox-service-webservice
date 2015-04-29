package be.lode.jukebox.service.webservice;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.jukebox.business.repo.CustomQueryRepository;

public class WebServiceManager {

	private CustomQueryRepository custRepo;
	private EntityManagerFactory emf;

	public WebServiceManager() {
		super();
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		custRepo = new CustomQueryRepository(emf);
	}

	public List<String> getAllArtists() {
		return custRepo.getAllArtists();
	}

	public List<String> getAllTitles(String artist) {
		if (artist == null || artist.length() == 0)
			return custRepo.getAllTitles();;
		return custRepo.getAllTitles(artist);
	}
}
