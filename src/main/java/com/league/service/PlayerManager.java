package com.league.service;

import com.league.PlayerDAO;
import com.league.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerManager implements PlayerDAO {

    @PersistenceContext
    EntityManager em;

    public Player addPlayer(Player player)
    {
        em.persist(player);
        em.flush();

        return player;
    }

    public void deletePlayer(Player player)
    {
        em.remove(em.getReference(Player.class, player.getIdPlayer()));
    }

    public Player updatePlayer(Player player)
    {
        return (Player)em.merge(player);
    }


	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers()
    {
        return em.createNamedQuery("player.getAll").getResultList();
    }

    public Player getPlayerByID(Long id)
    {
        return em.find(Player.class, id);
    }


	@SuppressWarnings("unchecked")
	public List<Player> getPlayersByClubID(Club club)
    {
        return em.createNamedQuery("player.getByIdClub").setParameter("idClub", club.getIdClub()).getResultList();
    }



}
