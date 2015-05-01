package be.lode.jukebox.service.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.Jukebox;
import be.lode.jukebox.business.model.comparators.StringComparator;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.CustomQueryRepository;
import be.lode.jukebox.business.repo.JukeboxRepository;

public class WebServiceManager {

	private CustomQueryRepository custRepo;
	private EntityManagerFactory emf;
	private Repository<Jukebox> jukeboxRepo;
	private Repository<Account> accountRepo;

	public WebServiceManager() {
		super();
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		custRepo = new CustomQueryRepository(emf);
		jukeboxRepo = new JukeboxRepository(emf);
		accountRepo = new AccountRepository(emf);
	}

	public List<String> getAllArtists() {
		return custRepo.getAllArtists();
	}

	public List<String> getAllTitles(String artist) {
		if (artist == null || artist.length() == 0)
			return custRepo.getAllTitles();
		;
		return custRepo.getAllTitles(artist);
	}

	public List<String> getAllJukeboxes(String serviceName, String serviceId) {
		if (serviceName == null || serviceName.length() == 0
				|| serviceId == null || serviceId.length() == 0)
			return custRepo.getAllJukeboxes();

		Account acc = null;
		//Check if account exists
		for (Account item : accountRepo.getList()) {
			if (item.getServiceId().equalsIgnoreCase(serviceId)
					&& item.getServiceName().equalsIgnoreCase(serviceName)) {
				acc = item;
			}
		}
		
		//Check which jukebox is accessed by the account
		List<Jukebox> jbList = new ArrayList<Jukebox>();
		if (acc != null) {
			for (Jukebox jbItem : jukeboxRepo.getList()) {
				if (jbItem.getAccountRoles().containsKey(acc)) {
					jbList.add(jbItem);
				}
			}
		}
		
		List<String> nameList = new ArrayList<String>();
		for (Jukebox jbItem : jbList) {
			nameList.add(jbItem.getName());
		}
		nameList.sort(new StringComparator());
		return nameList;
	}

}
