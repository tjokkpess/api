package org.tjokkpess.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.tjokkpess.model.Season;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeasonRepository implements PanacheMongoRepository<Season> {

}
