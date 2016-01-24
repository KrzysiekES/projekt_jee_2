package com.league.service;

import com.league.ClubDAO;
import com.league.domain.Club;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClubManager implements ClubDAO {

    @PersistenceContext
    EntityManager em;

    public Club addClub(Club club)
    {
        em.persist(club);
        em.flush();

        return club;
    }

    public void deleteClub(Club club)
    {
        em.remove(em.getReference(Club.class, club.getIdClub()));
    }

    public Club updateClub(Club club)
    {
        return em.merge(club);
    }
/*
    public List<Club> getAllClubsWithDiscount()
    {
        return em.createNamedQuery("club.hasDiscount").getResultList();
    }
*/
    @SuppressWarnings("unchecked")
	public List<Club> getAllClubs()
    {
        return em.createNamedQuery("club.getAll").getResultList();
    }

    public Club getClubByID(Long id)
    {
        return em.find(Club.class, id);
    }




}
