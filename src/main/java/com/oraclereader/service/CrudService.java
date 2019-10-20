package com.oraclereader.service;

import java.util.List;

/**
 * Interface for CRUD services
 * @param <T>
 */
public interface CrudService<T>
{
  T save(T object);

  T findById(Integer id);

  List<T> findAll();

  void deleteById(Integer id);
}
