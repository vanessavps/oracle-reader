package com.oraclereader.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ObjectConverter
{
  public static String convertObjectToJson(Object object) throws JsonProcessingException
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper.writeValueAsString(object);
  }

  public static <T> List<T> convertJsonToObjectList(String json, TypeReference typeReference) throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json,typeReference);
  }

  public static <T> T convertJsonToObject(String json, Class<T> clazz) throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json,clazz);
  }
}
