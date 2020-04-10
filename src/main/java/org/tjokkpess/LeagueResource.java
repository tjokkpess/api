package org.tjokkpess;

import org.bson.types.ObjectId;
import org.tjokkpess.dao.LeagueRepository;
import org.tjokkpess.dao.SeasonRepository;
import org.tjokkpess.model.League;
import org.tjokkpess.model.Season;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/leagues")
@Produces(MediaType.APPLICATION_JSON)
public class LeagueResource {

    @Inject
    LeagueRepository leagueRepository;

    @Inject
    SeasonRepository seasonRepository;



    @GET
    public List<League> getAll() {
        return leagueRepository.listAll();
    }

    @POST
    public Response create(League league){

        leagueRepository.persist(league);
        return Response.accepted().build();

    }

    @GET
    @Path("/{id}/seasons")
    public List<Season> getSeasons(@PathParam("id") String leagueId){
        League league = leagueRepository.findById(new ObjectId(leagueId));
        return seasonRepository.find(league.seasons);

    }
    @POST
    @Path("/{id}/seasons")
    public Response createSeason(@PathParam("id") String leagueId, Season season){
        League league = leagueRepository.findById(new ObjectId(leagueId));
        seasonRepository.persist(season);
        league.seasons.add(season.id);
        leagueRepository.update(league);
        return Response.accepted().build();

    }

    @GET
    @Path("/{leagueid}/seasons/{seasonid}")
    public Season getSeason(@PathParam("leagueid") String leagueId, @PathParam("seasonid") String seasonid){
        return seasonRepository.findById(new ObjectId(seasonid));
    }


}