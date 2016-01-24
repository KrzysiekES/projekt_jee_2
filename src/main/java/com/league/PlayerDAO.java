package com.league;

import com.league.domain.*;

import java.util.List;

public interface PlayerDAO {

    Player addPlayer(Player player);
    void deletePlayer(Player player);
    Player updatePlayer(Player player);
    List<Player> getAllPlayers();
    Player getPlayerByID(Long id);
  //  List<Player> getPlayersByClubsID(Club club);


}
