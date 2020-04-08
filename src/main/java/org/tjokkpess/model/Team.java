package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection="Team")
public class Team {


    @Id
    @GeneratedValue
    public ObjectId id;
    public String shortName;
    public String fullName;

    public List<ObjectId> players = new ArrayList<>();

    public Team() {
    }


    public Team(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }
}
