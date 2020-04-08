package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@MongoEntity(collection="League")
public class League {


    @Id
    @GeneratedValue
    public ObjectId id;
    public String shortName;
    public String fullName;

    public League() {
    }

    public League(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }
}
