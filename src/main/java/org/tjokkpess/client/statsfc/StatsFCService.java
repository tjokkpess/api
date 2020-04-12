package org.tjokkpess.client.statsfc;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/v1")
@RegisterRestClient
@ClientHeaderParam(name="X-StatsFC-Key", value="Af7EDeUk50TFOx5qXEkKcNzC9GJRk5EAfx1obtVg")
public interface StatsFCService {


    @GET
    @Path("/standings")
    @Produces("application/json")
    StatsFCData<StatsFCStandingsData> standings();


    @GET
    @Path("/squads")
    @Produces("application/json")
    StatsFCData<StatsFCSquad> squad(@QueryParam("competition_id") int competition_id);
}