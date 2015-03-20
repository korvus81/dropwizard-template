package net.jeffpoole.healthchecks;
import com.codahale.metrics.health.HealthCheck;

/**
 * User: jpoole Date: 12/12/14 Time: 10:16 PM
 */
public class NullHealthCheck extends HealthCheck
{
  @Override
  protected Result check() throws Exception
  {
    return Result.healthy();
  }
}
