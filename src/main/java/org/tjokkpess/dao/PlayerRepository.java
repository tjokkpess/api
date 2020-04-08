package org.tjokkpess.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.tjokkpess.model.Player;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PlayerRepository implements PanacheMongoRepository<Player> {

    public List<Player> find(List<ObjectId> list){
        Document basicDBObject = new Document("_id",new Document("$in", list));
        return find(basicDBObject).list();
    }


}
