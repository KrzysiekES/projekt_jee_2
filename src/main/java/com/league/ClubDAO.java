package com.club;

import com.league.domain.Club;

import java.util.List;


public interface ClubDAO
{

    List<Club> getAllClubs();
    Club getClubById(Club Club);
    Club getClubByIdWithClubsAuthors(Club club);
    Club getClubByIdWithPlubs(Club club);
    List<Club> getClubByPlayers(String players);
    Club updateClub(Club Club);
    void deleteClub(Club Club);
    Club addClub(Club Club);


}
