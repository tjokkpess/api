package org.tjokkpess;

import org.tjokkpess.dao.LeagueRepository;
import org.tjokkpess.model.League;
import org.tjokkpess.model.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/leagues")
public class LeagueResource {

    @Inject
    LeagueRepository leagueRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<League> getAll() {
        return leagueRepository.listAll();
    }

    @POST
    public Response create(League league){
        leagueRepository.persist(league);
        return Response.accepted().build();

    }

    @DELETE
    public Response delete(Player player){

        return Response.accepted().build();

    }
}