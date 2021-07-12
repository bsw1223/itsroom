package com.nothouse.itsroom.entity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface stanregincdRepository extends CrudRepository<stanregincd, Long> {

  List<stanregincd> findBySido_cd(String sido_cd);

  stanregincd findByRegion_cd(String region_cd);
}