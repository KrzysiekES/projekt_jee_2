package com.league;

import com.league.domain.Player;

import java.util.List;


public interface PlayerDAO
{
    List<Player> getAllPlayers();
    Player getPlayerById(Player player);
    Player getPlayerByIdWithBooksPlayers(Player player);
    List<Player> getPlayerByPosition(String position);
    Player updatePlayer(Player player);
    void deletePlayer(Player player);
    Player addPlayer(Player player);
}
