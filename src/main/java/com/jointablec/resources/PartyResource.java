package com.jointablec.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMap;
import com.jointablec.core.ImmutableParty;
import com.jointablec.db.PartyManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/v1/party")
@Produces(MediaType.APPLICATION_JSON)
public class PartyResource {
  private final PartyManager partyManager;

  public PartyResource(PartyManager partyManager) {
    this.partyManager = partyManager;
  }

  @GET
  @Timed
  public List<ImmutableParty> getParties() {
    return partyManager.getParties();
  }

  @POST
  @Timed
  @Consumes(MediaType.APPLICATION_JSON)
  public Map<String, Long> createParty(ImmutableParty party) {
    return ImmutableMap.of("partyId", partyManager.createParty(party));
  }
}
