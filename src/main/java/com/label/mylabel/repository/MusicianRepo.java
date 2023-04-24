package com.label.mylabel.repository;

import com.label.mylabel.entity.MusicianEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepo extends CrudRepository<MusicianEntity, Long> {
    MusicianEntity findByName(String name);
}
