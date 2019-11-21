package com.oraclereader.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ObjectConverter
{
  public static String convertObjectToJson(ObjectMapper mapper, Object object) throws JsonProcessingException
  {
    return mapper.writeValueAsString(object);
  }

  public static <T> List<T> convertJsonToObjectList(ObjectMapper mapper, String json, TypeReference typeReference) throws IOException
  {
    return mapper.readValue(json, typeReference);
  }

  public static <T> T convertJsonToObject(ObjectMapper mapper, String json, Class<T> clazz) throws IOException
  {
    return mapper.readValue(json, clazz);
  }
}
