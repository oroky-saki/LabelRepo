package com.label.mylabel.repository;

import com.label.mylabel.entity.MusicianEntity;
import org.springframework.data.repository.CrudRepository;

public interface MusicianRepo extends CrudRepository<MusicianEntity, Long> {
    MusicianEntity findByName(String name);
}
