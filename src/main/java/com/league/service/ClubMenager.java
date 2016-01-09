package main.java.com.example.projekt_jee_liga.domain;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.com.example.projekt_jee_liga.domain.Club;
import main.java.com.example.projekt_jee_liga.domain.Player;


/*Do poprawy*/
@Stateless
public class ClubManager {

	@PersistenceContext
	EntityManager em;

	public void add(Club club) {
	pogrzeb.setId(null);
	em.persist(club);
	}
	

	public void usun(Club club) {
	pogrzeb = em.find(Club.class, club.getId());
	Player pl = em.find(Club.class, club.getPlayers().getId());
	pl.getclubs().remove(club);
	pl.remove(club);
	}

	@SuppressWarnings("unchecked")
	public List<Club> getAll() {
	return pl.createNamedQuery("clubs.all").getResultList();
	}

}