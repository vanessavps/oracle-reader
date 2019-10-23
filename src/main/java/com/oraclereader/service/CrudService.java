package com.oraclereader.service;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public abstract class CrudService<T> implements Crud<T>
{
  final protected JpaRepository<T, Integer> repository;

  @SuppressWarnings("unchecked")
  public CrudService(JpaRepository repository)
  {
    this.repository = repository;
  }

  @Override
  public T save(T obj)
  {
    return repository.save(obj);
  }

  public T findById(Integer id)
  {
    return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Object %s not found", id)));
  }

  public List<T> findAll()
  {
    return repository.findAll();
  }

  public void deleteById(Integer id)
  {
    repository.deleteById(id);
  }
}
