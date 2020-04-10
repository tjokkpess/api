package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection="Season")
public class Season extends PanacheMongoEntity {

    @Id
    @GeneratedValue
    public ObjectId id;
    public List<ObjectId> teams = new ArrayList<>();
    public List<ObjectId> leagueRounds = new ArrayList<>();

    public LocalDate startDate;
    public LocalDate endDate;

    public Season() {
    }

    public Season( List<ObjectId> teams, LocalDate startDate, LocalDate endDate) {
        this.teams = teams;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static List<Season> find(List<ObjectId> list){
        Document basicDBObject = new Document("_id",new Document("$in", list));
        return find(basicDBObject).list();
    }

    public static void persistAndGenerateLeagueRounds(Season season){
        List<ObjectId> leagueRounds = generateLeagueRounds(season.teams.size()*2);
        season.leagueRounds = leagueRounds;
        persist(season);
    }

    private static List<ObjectId> generateLeagueRounds(int numberOfRounds) {
        List<ObjectId> leagueRounds = new ArrayList<>();
        for(int i  = 1 ; i <= numberOfRounds;i++){
            LeagueRound leagueRound = new LeagueRound(i);
            LeagueRound.persist(leagueRound);
            leagueRounds.add(leagueRound.id);
        }
        return leagueRounds;
    }


}
