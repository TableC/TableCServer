package com.jointablec.db;

import com.jointablec.core.ImmutableParty;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

/**
 * PartyDAO.java
 *
 * @author Shawn Chowdhury (shawn.rc0@gmail.com)
 * @version 1.0
 * @since 2017-04-30
 */
public interface PartyDAO {
  @GetGeneratedKeys
  @SqlUpdate("INSERT INTO Party (userId, seats, startTime, endTime, title, simpleLocation)"
           + "VALUES (:userId, :seats, :startTime, :endTime, :title, :simpleLocation)")
  long create(@Bind("userId") int userId,
              @Bind("seats") int seats,
              @Bind("startTime") long startTime,
              @Bind("endTime") long endTime,
              @Bind("title") String title,
              @Bind("simpleLocation") String simpleLocation);

  @SqlQuery("SELECT * FROM Party;")
  List<ImmutableParty> getAll();
}
