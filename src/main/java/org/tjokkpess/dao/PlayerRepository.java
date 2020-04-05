package org.tjokkpess.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.tjokkpess.model.Player;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerRepository implements PanacheMongoRepository<Player> {

}
