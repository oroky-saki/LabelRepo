package com.label.mylabel.repository;

import com.label.mylabel.entity.AlbumEntity;
import com.label.mylabel.entity.TrackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepo extends CrudRepository<TrackEntity, Long> {
    TrackEntity findByTitle(String title);

    List<TrackEntity> findAllByAlbum(AlbumEntity album);
}
