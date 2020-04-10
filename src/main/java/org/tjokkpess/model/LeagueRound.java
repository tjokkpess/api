package org.tjokkpess.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@MongoEntity(collection="LeagueRound")
public class LeagueRound extends PanacheMongoEntity {
    @Id
    @GeneratedValue
    public ObjectId id;
    public int round;

    public LeagueRound(int round) {
        this.round = round;
    }
}
