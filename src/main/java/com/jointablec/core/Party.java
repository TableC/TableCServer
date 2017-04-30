package com.jointablec.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

/**
 * Party.java
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2017-04-30
 */
@Value.Immutable
@JsonSerialize(as=ImmutableParty.class)
@JsonDeserialize(as=ImmutableParty.class)
public interface Party {
  int getUserId();
  int getSeats();
  long getStartTime();
  long getEndTime();
  String getTitle();
  String getSimpleLocation();
  List<String> getTopics();
}