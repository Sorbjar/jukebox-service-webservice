package be.lode.jukebox.service.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.lode.general.repository.Repository;
import be.lode.jukebox.business.model.Account;
import be.lode.jukebox.business.model.Jukebox;
import be.lode.jukebox.business.model.Song;
import be.lode.jukebox.business.model.comparators.StringComparator;
import be.lode.jukebox.business.model.enums.Role;
import be.lode.jukebox.business.repo.AccountRepository;
import be.lode.jukebox.business.repo.CustomQueryRepository;
import be.lode.jukebox.business.repo.JukeboxRepository;
import be.lode.jukebox.business.repo.SongRepository;
import be.lode.jukebox.service.dto.JukeboxPaymentWSDTO;
import be.lode.jukebox.service.dto.JukeboxWSDTO;
import be.lode.jukebox.service.mapper.JukeboxModelMapper;

/**
 * The Class WebServiceManager.
 */
public class WebServiceManager {

	/** The account repo. */
	private Repository<Account> accountRepo;

	/** The cust repo. */
	private CustomQueryRepository custRepo;

	/** The emf. */
	private EntityManagerFactory emf;

	/** The jukebox repo. */
	private Repository<Jukebox> jukeboxRepo;

	/** The mapper. */
	private JukeboxModelMapper mapper;

	/** The song repo. */
	private Repository<Song> songRepo;

	/**
	 * Instantiates a new web service manager.
	 */
	public WebServiceManager() {
		super();
		emf = Persistence.createEntityManagerFactory("jukebox-business");
		custRepo = new CustomQueryRepository(emf);
		jukeboxRepo = new JukeboxRepository(emf);
		accountRepo = new AccountRepository(emf);
		songRepo = new SongRepository(emf);
		mapper = new JukeboxModelMapper();
	}

	/**
	 * Gets the all artists.
	 *
	 * @return the all artists
	 */
	public List<String> getAllArtists() {
		return custRepo.getAllArtists();
	}

	/**
	 * Gets the all jukeboxes.
	 *
	 * @param serviceName
	 *            the service name
	 * @param serviceId
	 *            the service id
	 * @return the all jukeboxes
	 */
	public List<JukeboxWSDTO> getAllJukeboxes(String serviceName,
			String serviceId) {
		List<Jukebox> jbList = new ArrayList<Jukebox>();
		if (serviceName == null || serviceName.length() == 0
				|| serviceId == null || serviceId.length() == 0) {
			jbList = jukeboxRepo.getList();
			return mapJukeboxListToJukeboxWSDTOList(jbList);
		}

		Account acc = null;
		// Check if account exists
		for (Account item : accountRepo.getList()) {
			if (item.getServiceId().equalsIgnoreCase(serviceId)
					&& item.getServiceName().equalsIgnoreCase(serviceName)) {
				acc = item;
			}
		}

		// Check which jukebox is accessed by the account
		jbList = new ArrayList<Jukebox>();
		if (acc != null) {
			for (Jukebox jbItem : jukeboxRepo.getList()) {
				if (jbItem.getAccountRoles().containsKey(acc)) {
					jbList.add(jbItem);
				}
			}
		}

		return mapJukeboxListToJukeboxWSDTOList(jbList);
	}

	/**
	 * Gets the all titles.
	 *
	 * @param artist
	 *            the artist
	 * @return the all titles
	 */
	public List<String> getAllTitles(String artist) {
		List<String> returnList = null;
		if (artist == null || artist.length() == 0)
			returnList = custRepo.getAllTitles();
		else
			returnList = custRepo.getAllTitles(artist);
		returnList.sort(new StringComparator());
		return returnList;
	}

	/**
	 * Gets the payment information.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @return the payment information
	 */
	public JukeboxPaymentWSDTO getPaymentInformation(String jukeboxId) {
		JukeboxPaymentWSDTO returnItem = new JukeboxPaymentWSDTO();
		List<Jukebox> jbList = jukeboxRepo.getList();
		for (Jukebox jukebox : jbList) {
			if (jukebox.getId() == Integer.valueOf(jukeboxId))
				returnItem = mapper.map(jukebox, JukeboxPaymentWSDTO.class);
		}
		return returnItem;
	}

	/**
	 * Order song.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @param artist
	 *            the artist
	 * @param title
	 *            the title
	 */
	public void orderSong(String jukeboxId, String artist, String title) {

		if (jukeboxId != null && jukeboxId.length() > 0 && artist != null
				&& artist.length() > 0 && title != null && title.length() > 0) {
			List<Jukebox> jbList = jukeboxRepo.getList();
			List<Song> songList = songRepo.getList();

			Jukebox jukebox = null;
			long jbId = Long.parseLong(jukeboxId);
			for (Jukebox item : jbList) {
				if (item.getId() == jbId)
					jukebox = item;
			}

			Song song = null;
			for (Song item : songList) {
				if (item.getArtist().equalsIgnoreCase(artist)
						&& item.getTitle().equalsIgnoreCase(title))
					song = item;
			}

			if (jukebox != null && song != null) {
				jukebox.getMandatoryPlaylist().addSong(song);
				jukeboxRepo.save(jukebox);
			}

		}
	}

	/**
	 * Register customer.
	 *
	 * @param jukeboxId
	 *            the jukebox id
	 * @param serviceName
	 *            the service name
	 * @param serviceId
	 *            the service id
	 * @return true, if successful
	 */
	public boolean registerCustomer(String jukeboxId, String serviceName,
			String serviceId) {
		try {
			Account acc = new Account("", "", "", serviceId, serviceName);
			acc = accountRepo.findEquals(acc);
			if (acc == null) {
				acc = new Account("", "", "", serviceId, serviceName);
				acc = accountRepo.save(acc);
			}
			Jukebox jb = null;
			List<Jukebox> jbList = jukeboxRepo.getList();
			for (Jukebox jukebox : jbList) {
				if (jukebox.getId() == Integer.valueOf(jukeboxId))
					jb = jukebox;
			}
			if (jb != null) {
				if (!jb.getAccountRoles().containsKey(acc)) {
					jb.getAccountRoles().put(acc, Role.Customer);
					jb = jukeboxRepo.save(jb);
				}
			}
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	/**
	 * Map jukebox list to jukebox wsdto list.
	 *
	 * @param jbList
	 *            the jb list
	 * @return the list
	 */
	private List<JukeboxWSDTO> mapJukeboxListToJukeboxWSDTOList(
			List<Jukebox> jbList) {
		List<JukeboxWSDTO> returnList = new ArrayList<JukeboxWSDTO>();
		for (Jukebox jukebox : jbList) {
			returnList.add(mapper.map(jukebox, JukeboxWSDTO.class));
		}
		return returnList;
	}

}
