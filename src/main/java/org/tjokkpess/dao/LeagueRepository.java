package org.tjokkpess.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.tjokkpess.model.League;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LeagueRepository implements PanacheMongoRepository<League> {

}
