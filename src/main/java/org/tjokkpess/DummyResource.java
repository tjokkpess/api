package org.tjokkpess;

import org.bson.types.ObjectId;
import org.tjokkpess.model.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Path("/api/v1/dummy")
public class DummyResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generate() {
        ArrayList<Player> players = createPlayers();
        ArrayList<Team> teams = createTeams();
        addPlayersToTeam(players, teams);

        League league = new League("PL", "Premier Leageu");
        League.persist(league);
        List<ObjectId> teamIds = teams.stream().map(Team::getId).collect(Collectors.toList());
        Season season = new Season(teamIds, LocalDate.of(2019,1,1),LocalDate.of(2020,1,1));
        Season.persistAndGenerateLeagueRounds(season);
        league.seasons.add(season.id);
        League.update(league);


        return Response.ok().build();
    }

    private void addPlayersToTeam(ArrayList<Player> players, ArrayList<Team> teams) {
        teams.get(0).players.add(players.get(0).id);
        teams.get(1).players.add(players.get(1).id);
        teams.get(2).players.add(players.get(2).id);
        teams.get(3).players.add(players.get(3).id);
        teams.get(4).players.add(players.get(4).id);
        Team.update(teams.get(0));
        Team.update(teams.get(1));
        Team.update(teams.get(2));
        Team.update(teams.get(3));
        Team.update(teams.get(4));
    }

    private ArrayList<Team> createTeams() {
        Team team1 = new Team("WBA", "West Bromwich");
        Team team2 =new Team("Fulham", "Fulham");
        Team team3 =new Team("West Ham", "West Ham");
        Team team4 =new Team("Tottenham", "Tottenham");
        Team team5 =new Team("Chelsea", "Chelsea");
        Team.persist(team1);
        Team.persist(team2);
        Team.persist(team3);
        Team.persist(team4);
        Team.persist(team5);
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        return teams;
    }



    private ArrayList<Player> createPlayers() {
        Player player1 = new Player("Ane", "Brun", PlayerPosition.MIDFIELDER, 5000);
        Player player2 = new Player("Jane", "Svart", PlayerPosition.DEFENDER, 5000);
        Player player3 = new Player("Lana", "Rød", PlayerPosition.GOALKEEPER, 5000);
        Player player4 = new Player("Thea", "Lilla", PlayerPosition.STRIKER, 5000);
        Player player5 = new Player("Elin", "Grønn", PlayerPosition.MIDFIELDER, 5000);
        Player.persist(player1);
        Player.persist(player2);
        Player.persist(player3);
        Player.persist(player4);
        Player.persist(player5);
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        return players;
    }

}