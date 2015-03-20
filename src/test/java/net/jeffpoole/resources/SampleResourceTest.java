package net.jeffpoole.resources;

import static org.junit.Assert.*;

import io.dropwizard.testing.junit.ResourceTestRule;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.common.collect.Lists;

import net.jeffpoole.models.SampleDataModel;


public class SampleResourceTest
{

  @ClassRule
  public static final ResourceTestRule resources = ResourceTestRule.builder()
      .addResource(new SampleResource())
      .build();

  @Before
  public void setUp() throws Exception
  {

  }


  @Test
  public void testGetSample() throws Exception
  {
    // manual version: curl -H 'Accept: application/json' -v 'http://127.0.0.1:8080/'
    assertEquals(
        new SampleDataModel(42, "random string", Lists.newArrayList("a","b","c")),
        resources.client().target("/").request().get(SampleDataModel.class));

    // manual version: curl -H 'Accept: application/json' -v 'http://127.0.0.1:8080/?number=99&value=blah&strings=abc&strings=def'
    assertEquals(
        new SampleDataModel(99, "blah", Lists.newArrayList("abc","def")),
        resources.client().target("/?number=99&value=blah&strings=abc&strings=def").request().get(SampleDataModel.class));

  }


  @Test
  public void testGetOtherSample() throws Exception
  {
    // manual version: curl -H 'Accept: application/json' -v 'http://127.0.0.1:8080/blah'
    assertEquals(
        new SampleDataModel(11, "blah", Lists.newArrayList("q","z")),
        resources.client().target("/blah").request().get(SampleDataModel.class));
  }

  
  @Test
  public void testPostSample() throws Exception
  {
    // manual version: curl -H 'Content-Type: application/json' -X POST -d '{"number":3, "value":"abc", "strings":["a","b","q"]}' -v http://127.0.0.1:8080/
    String json = "{\"number\":3, \"value\":\"abc\", \"strings\":[\"a\",\"b\",\"q\"]}";
    assertEquals(
        204, // "No content"
        resources.client().target("/").request().post(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE)).getStatus()
    );
  }
}
