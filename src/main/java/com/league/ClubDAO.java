package com.league;

import com.league.domain.Club;

import java.util.List;

public interface ClubDAO {

    Club addClub(Club club);
    void deleteClub(Club club);
    Club updateClub(Club club);
    List<Club> getAllClubs();
    Club getClubByID(Long id);
  ///  List<Club> getAllClubsWithPlayers();
}
