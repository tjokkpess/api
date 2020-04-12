package org.tjokkpess.model;


import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@MongoEntity(collection="Player")
public class Player  extends PanacheMongoEntity {


    @Id
    @GeneratedValue
    public ObjectId id;
    public ObjectId teamId;

    public String name;
    public PlayerPosition playerPosition = PlayerPosition.UNKNOWN;
    public int price;


    public Player(String name, PlayerPosition playerPosition, int price, ObjectId teamId) {
        this.name = name;
        this.playerPosition = playerPosition;
        this.price = price;
        this.teamId = teamId;
    }

    public static List<Player> find(List<ObjectId> list){
        Document basicDBObject = new Document("_id",new Document("$in", list));
        return find(basicDBObject).list();
    }
}
