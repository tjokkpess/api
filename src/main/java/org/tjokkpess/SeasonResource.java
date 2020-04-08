package org.tjokkpess;

import org.tjokkpess.dao.SeasonRepository;
import org.tjokkpess.model.Player;
import org.tjokkpess.model.Season;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/seasons")
public class SeasonResource {

    @Inject
    SeasonRepository seasonRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Season> getAll() {
        return seasonRepository.listAll();
    }

    @POST
    public Response create(Season season){
        seasonRepository.persist(season);
        return Response.accepted().build();

    }

    @DELETE
    public Response delete(Player player){

        return Response.accepted().build();

    }
}