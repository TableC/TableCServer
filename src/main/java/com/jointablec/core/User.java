package com.jointablec.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * User.java
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2017-04-30
 */
@Value.Immutable
@JsonSerialize(as=ImmutableUser.class)
@JsonDeserialize(as=ImmutableUser.class)
public interface User {
  int getId();
  String getFirstName();
  String getLastName();
  String getEmail();
  String getSchool();
  Optional<Integer> getAge();
  Optional<String> getBio();
  Optional<String> getAvatarUrl();
}
