package org.tjokkpess;

import org.tjokkpess.model.Player;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/players")
public class PlayerResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> getAll() {
        return Player.listAll();
    }

    @POST
    public Response create(Player player){
        Player.persist(player);
        return Response.accepted().build();

    }

    @PUT
    public Response update(Player player){
        Player.update(player);
        return Response.accepted().build();

    }

    @DELETE
    public Response delete(Player player){

        return Response.accepted().build();

    }
}