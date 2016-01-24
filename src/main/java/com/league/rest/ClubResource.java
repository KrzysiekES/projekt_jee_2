package com.league.rest;

import com.league.ClubDAO;
import com.league.domain.Club;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/club")
public class ClubResource {

    @EJB
    private ClubDAO clubManager;

    @POST
    @Path("/addClub")
    public Response addClub(@FormParam("name") String name,
                                @FormParam("owner") String owner,
                                @FormParam("city") String city,
                                @FormParam("capacity") int capacity)
    {
        Club club = new Club();
        club.setName(name);
        club.setOwner(owner);
        club.setCity(city);
        club.setCapacity(capacity);
        clubManager.addClub(club);

        
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/getAllClubs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Club> getAllClubs() {
        return clubManager.getAllClubs();
    }

    @GET
    @Path("/getClub/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Club getClubByID(@PathParam("id") Long id) {
        return clubManager.getClubByID(id);
    }

    @POST
    @Path("/updateClub")
    public Response updateClub(@FormParam("idClub") long idClub,
                                   @FormParam("name") String name,
                                   @FormParam("owner") String owner,
                                   @FormParam("city") String city,
                                   @FormParam("capacity") int capacity)
    {
        Club club = new Club();
        club.setIdClub(idClub);
        club.setName(name);
        club.setOwner(owner);
        club.setCity(city);
        club.setCapacity(capacity);

        clubManager.updateClub(club);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/deleteClub")
    public Response deleteClub(@FormParam("idClub") long idClub)
    {
        Club club = new Club();
        club.setIdClub(idClub);

        clubManager.deleteClub(club);

        return Response.status(Response.Status.OK).build();
    }
}
