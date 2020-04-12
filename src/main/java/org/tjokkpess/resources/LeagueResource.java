package org.tjokkpess.resources;

import org.bson.types.ObjectId;
import org.tjokkpess.model.League;
import org.tjokkpess.model.Season;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/leagues")
@Produces(MediaType.APPLICATION_JSON)
public class LeagueResource {

   @GET
    public List<League> getAll() {
        return League.listAll();
    }

    @POST
    public Response create(League league){
        League.persist(league);
        return Response.accepted().build();
    }

    @GET
    @Path("/{id}/seasons")
    public List<Season> getSeasons(@PathParam("id") String leagueId){
        League league = League.findById(new ObjectId(leagueId));
        return Season.find(league.seasons);
    }

    @POST
    @Path("/{id}/seasons")
    public Response createSeason(@PathParam("id") String leagueId, Season season){
        League league = League.findById(new ObjectId(leagueId));

        Season.persist(season);
        league.seasons.add(season.id);
        League.update(league);
        return Response.accepted().build();
    }

    @GET
    @Path("/{leagueid}/seasons/{seasonid}")
    public Season getSeason(@PathParam("leagueid") String leagueId, @PathParam("seasonid") String seasonid){
        return Season.findById(new ObjectId(seasonid));
    }
}