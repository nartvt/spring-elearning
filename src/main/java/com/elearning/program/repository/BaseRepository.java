package com.elearning.program.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T> extends Serializable{
  List<T> findAll();

  T findById(String id);

  boolean save(T t);

  boolean delete(String id);
  
 // boolean update(T t);
}
