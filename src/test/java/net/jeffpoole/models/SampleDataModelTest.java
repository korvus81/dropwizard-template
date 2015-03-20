package net.jeffpoole.models;

import static org.junit.Assert.*;

import io.dropwizard.jackson.Jackson;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;


public class SampleDataModelTest
{

  private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

  private static final String SAMPLE_JSON =
      "{\"number\":12,\"value\":\"abc\",\"strings\":[\"x\",\"y\"]}";

  private static final SampleDataModel SDM = new SampleDataModel(12,"abc", Lists.newArrayList("x","y"));

  @Before
  public void setUp() throws Exception
  {

  }

  @Test
  public void serializesToJSON() throws Exception
  {

    assertEquals(
        SAMPLE_JSON,
        MAPPER.writeValueAsString(SDM));
  }

  @Test
  public void deserializesFromJSON() throws Exception
  {
    assertEquals(
        SDM,
        MAPPER.readValue(SAMPLE_JSON, SampleDataModel.class)
    );
  }
}
