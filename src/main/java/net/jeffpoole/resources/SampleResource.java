package net.jeffpoole.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;

import net.jeffpoole.models.SampleDataModel;


/**
 * User: jpoole Date: 3/15/15 Time: 2:25 PM
 */
@Slf4j
@Path("/")
public class SampleResource
{
  @GET
  @Produces("application/json")
  public SampleDataModel getSample(
      @QueryParam("number") Integer number,
      @QueryParam("value") String value,
      @QueryParam("strings") List<String> strings)
  {
    SampleDataModel sdm = new SampleDataModel(
        (number == null) ? 42 : number,
        (value == null) ? "random string" : value,
        (strings == null || strings.isEmpty()) ? Lists.newArrayList("a","b","c") : strings
    );
    return sdm;
  }

  @GET
  @Produces("application/json")
  @Path("/{value}")
  public SampleDataModel getOtherSample(@PathParam("value") String value)
  {
    SampleDataModel sdm = new SampleDataModel(
        11,
        (value == null) ? "random string" : value,
        Lists.newArrayList("q","z")
    );
    return sdm;
  }

  @POST
  @Consumes("application/json")
  public void postSample(SampleDataModel sdm)
  {
    log.info("Got SampleDataModel: [{}]", sdm);
  }
}
