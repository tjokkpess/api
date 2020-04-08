package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection="Season")
public class Season {


    @Id
    @GeneratedValue
    public ObjectId id;
    public League league = new League();
    public int numberOfTeams;
    public List<Team> teams = new ArrayList<Team>();

    public LocalDate startDate;
    public LocalDate endDate;

    public Season() {
    }

    public Season(League league, int numberOfTeams, List<Team> teams, LocalDate startDate, LocalDate endDate) {
        this.league = league;
        this.numberOfTeams = numberOfTeams;
        this.teams = teams;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
