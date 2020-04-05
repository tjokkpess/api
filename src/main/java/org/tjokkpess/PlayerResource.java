package org.tjokkpess;

import org.tjokkpess.dao.PlayerRepository;
import org.tjokkpess.model.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;


@Path("/api/v1/players")
public class PlayerResource {

    @Inject
    PlayerRepository playerRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getAll() {
        return playerRepository.listAll();
    }

    @POST
    public Response create(Player player){
        playerRepository.persist(player);
        return Response.accepted().build();

    }

    @DELETE
    public Response delete(Player player){

        return Response.accepted().build();

    }
}