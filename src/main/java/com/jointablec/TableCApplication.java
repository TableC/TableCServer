package com.jointablec;

import com.jointablec.db.PartyDAO;
import com.jointablec.db.PartyManager;
import com.jointablec.resources.PartyResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class TableCApplication extends Application<TableCConfiguration> {

  public static void main(final String[] args) throws Exception {
    new TableCApplication().run(args);
  }

  @Override
  public String getName() {
    return "table-c";
  }

  @Override
  public void initialize(final Bootstrap<TableCConfiguration> bootstrap) {
    bootstrap.addBundle(new MigrationsBundle<TableCConfiguration>() {
      @Override
      public DataSourceFactory getDataSourceFactory(TableCConfiguration configuration) {
        return configuration.getDataSourceFactory();
      }
    });
    bootstrap.addBundle(new AssetsBundle(
        "/assets",
        "/",
        "index.html"));
  }

  @Override
  public void run(
      final TableCConfiguration configuration,
      final Environment environment
  ) {
    final DBIFactory dbiFactory = new DBIFactory();
    final DBI jdbi = dbiFactory.build(
        environment,
        configuration.getDataSourceFactory(),
        "mysql");
    final PartyDAO partyDAO = jdbi.onDemand(PartyDAO.class);

    environment.jersey().setUrlPattern("/api/*");
    environment.jersey()
        .register(new PartyResource(new PartyManager(partyDAO)));
  }

}
