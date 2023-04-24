package com.label.mylabel.repository;

import com.label.mylabel.entity.BandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandsRepo extends CrudRepository<BandEntity, Long> {
    BandEntity findByName(String name);
}
