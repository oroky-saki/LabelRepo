package com.label.mylabel.repository;

import com.label.mylabel.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends CrudRepository<AlbumEntity, Long> {
    AlbumEntity findByTitle(String title);
    List<AlbumEntity> findAllByBand(String band);
}
