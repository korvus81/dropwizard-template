package net.jeffpoole.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * User: jpoole Date: 3/15/15 Time: 2:25 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDataModel
{
  @JsonProperty
  int number;

  @JsonProperty
  String value;

  @JsonProperty
  List<String> strings;
}
