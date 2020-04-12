package org.tjokkpess.resources;

import org.bson.types.ObjectId;
import org.tjokkpess.model.Player;
import org.tjokkpess.model.Team;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/api/v1/teams")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {



    @GET
    public List<Team> getAll() {
        return Team.listAll();
    }

    @GET
    @Path("/{id}")
    public Team getTeam(@PathParam("id") String id) {
        return Team.findById(new ObjectId(id));
    }

    @GET
    @Path("/{id}/players")
    public List<Player> getPlayers(@PathParam("id") String id) {
        Team team = Team.findById(new ObjectId(id));
        List<ObjectId> players = team.players;

        return Player.find(players);
    }

    @PUT
    @Path("/{id}/players")
    public Response addPlayersToTeam(@PathParam("id") String id, Player player) {
        Team team = Team.findById(new ObjectId(id));
        team.players.add(player.id);
        Team.update(team);
        return Response.accepted().build();


    }

    @POST
    public Response create(Team team) {
        Team.persist(team);
        return Response.accepted().build();
    }

    @DELETE
    public Response delete(Player player) {

        return Response.accepted().build();

    }
}