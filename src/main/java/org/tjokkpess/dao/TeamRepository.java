package org.tjokkpess.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.tjokkpess.model.Team;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheMongoRepository<Team> {

}
