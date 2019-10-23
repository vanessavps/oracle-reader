package com.oraclereader.service;

import java.util.List;

/**
 * Interface for Crud services
 * @param <T>
 */
public interface Crud<T>
{
  T save(T object);

  T findById(Integer id);

  List<T> findAll();

  void deleteById(Integer id);
}
