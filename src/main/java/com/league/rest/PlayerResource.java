package com.league.rest;

import com.league.PlayerDAO;
import com.league.ClubDAO;
import com.league.domain.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Stateless
@Path("/player")
public class PlayerResource {

    @EJB
    private ClubDAO clubManager;

    @EJB
    private PlayerDAO playerManager;

    @POST
    @Path("/addPlayer")
    public Response addPlayer(
    							 @FormParam("firstName") String firstName,
    							 @FormParam("lastName") String lastName,
                                 @FormParam("shirtNumber") int shirtNumber,
                                 @FormParam("position") String position,
                                 @FormParam("bornDate") Date bornDate,
                                 @FormParam("club") String club)
    {
        Long clubID = Long.parseLong(club.substring(0, club.indexOf('.')));

        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setShirtNumber(shirtNumber);
        player.setPosition(position);
        player.setBornDate(bornDate);
        player.setClub(clubManager.getClubByID(clubID));

        playerManager.addPlayer(player);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/getAllPlayers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getAllPlayers() {
        return playerManager.getAllPlayers();
    }

    @GET
    @Path("/getPlayer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayerByID(@PathParam("id") Long id) {
        return playerManager.getPlayerByID(id);
    }

    @POST
    @Path("/updatePlayer")
    public Response updatePlayer(@FormParam("idPlayer") long idPlayer,
    								@FormParam("firstName") String firstName,
    								@FormParam("lastName") String lastName,                            
                                    @FormParam("shirtNumber") int shirtNumber,
                                    @FormParam("position") String position,
                                    @FormParam("bornDate") Date bornDate,
    								@FormParam("club") String club)
    {
        Long clubID = Long.parseLong(club.substring(0, club.indexOf('.')));

        Player player = playerManager.getPlayerByID(idPlayer);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setShirtNumber(shirtNumber);
        player.setPosition(position);
        player.setBornDate(bornDate);
        player.setClub(clubManager.getClubByID(clubID));

        playerManager.updatePlayer(player);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deletePlayer")
    public Response deletePlayer(@FormParam("idPlayer") long idPlayer)
    {
        Player player = new Player();
        player.setIdPlayer(idPlayer);

        playerManager.deletePlayer(player);

        return Response.status(Response.Status.OK).build();
    }
}
