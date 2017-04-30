package com.jointablec.db;

import com.jointablec.core.ImmutableParty;

import java.util.List;

/**
 * PartyManager.java -
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2017-04-30
 */
public class PartyManager {
  private final PartyDAO partyDAO;

  public PartyManager(PartyDAO partyDAO) {
    this.partyDAO = partyDAO;
  }

  public long createParty(ImmutableParty party) {
    return partyDAO.create(
        party.getUserId(),
        party.getSeats(),
        party.getStartTime(),
        party.getEndTime(),
        party.getTitle(),
        party.getSimpleLocation());
  }

  public List<ImmutableParty> getParties() {
    return partyDAO.getAll();
    /*return Collections.singletonList(ImmutableParty.builder()
        .ownerId(42)
        .seats(0)
        .startTime(System.currentTimeMillis() / 1000)
        .endTime(System.currentTimeMillis() / 1000 + 3600)
        .title("Dinner and Chill")
        .simpleLocation("George Sherman Union")
        .topics(Arrays.asList("#anything", "#masseffect", "#burritos"))
        .build());*/
  }
}
