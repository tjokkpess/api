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
    public List<ObjectId> teams = new ArrayList<>();

    public LocalDate startDate;
    public LocalDate endDate;

    public Season() {
    }

    public Season( List<ObjectId> teams, LocalDate startDate, LocalDate endDate) {
        this.teams = teams;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
