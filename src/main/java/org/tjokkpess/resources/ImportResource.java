package org.tjokkpess.resources;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.tjokkpess.client.statsfc.*;
import org.tjokkpess.model.Player;
import org.tjokkpess.model.PlayerPosition;
import org.tjokkpess.model.Team;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


@Path("/api/v1/import")
public class ImportResource {
    @Inject
    @RestClient
    StatsFCService statsFCService;

    @GET
    @Path("/teams")
    @Produces(MediaType.APPLICATION_JSON)
    public Response standings() {
        StatsFCData<StatsFCStandingsData> standings = statsFCService.standings();
        List<StatsFCTeam> statsFCTeams = standings.data.stream().map(statsFCStandingsData -> statsFCStandingsData.team).collect(Collectors.toList());
        statsFCTeams.stream().forEach(statsFCTeam -> {
            Team.persist(new Team(null, statsFCTeam.name));
        });
        return Response.ok().build();
    }

    @GET
    @Path("/players")
    @Produces(MediaType.APPLICATION_JSON)
    public Response squads() {
        StatsFCData<StatsFCSquad> squad = statsFCService.squad(2);
        squad.data.forEach(statsFCSquad -> {
            Team team = Team.findByName(statsFCSquad.team.name);
            statsFCSquad.players.forEach(statsFCPlayer -> {
                Player.persist(new Player(statsFCPlayer.name,PlayerPosition.mapFromStatsFC(statsFCPlayer.position),0, team.id));
            });
        });

        return Response.ok().build();
    }

}