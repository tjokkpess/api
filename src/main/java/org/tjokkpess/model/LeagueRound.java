package org.tjokkpess.model;

import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class LeagueRound {

    @Id
    @GeneratedValue
    public ObjectId id;
    private Season season;
    private int round;

}
