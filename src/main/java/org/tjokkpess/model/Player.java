package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@MongoEntity(collection="Player")
public class Player {


    @Id
    @GeneratedValue
    public ObjectId id;
    public String firstName;
    public String lastName;
    public PlayerPosition playerPosition = PlayerPosition.UNKNOWN;
    public int price;

    public Player() {
    }

    public Player(String firstName, String lastName, PlayerPosition playerPosition, int price, int shirtNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerPosition = playerPosition;
        this.price = price;

    }
}
