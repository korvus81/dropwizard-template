package net.jeffpoole;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


import net.jeffpoole.healthchecks.NullHealthCheck;
import net.jeffpoole.resources.SampleResource;


/**
 * User: jpoole Date: 3/15/15 Time: 2:17 PM
 */
public class WebApplication extends Application<WebApplicationConfiguration>
{
  @Override
  public void initialize(final Bootstrap<WebApplicationConfiguration> bootstrap)
  {
  }


  @Override
  public void run(final WebApplicationConfiguration webApplicationConfiguration,
      final Environment environment)
      throws Exception
  {
    environment.healthChecks().register("nullCheck", new NullHealthCheck());
    environment.jersey().register(new SampleResource());
  }


  public static void main(String[] args) throws Exception
  {
    new WebApplication().run(args);
  }
}
