package com.label.mylabel.service;

import com.label.mylabel.entity.AlbumEntity;
import com.label.mylabel.entity.TrackEntity;
import com.label.mylabel.exceptions.TrackAlreadyExistException;
import com.label.mylabel.mapper.TrackMapper;
import com.label.mylabel.model.Track;
import com.label.mylabel.repository.AlbumRepo;
import com.label.mylabel.repository.TrackRepo;
import org.springframework.stereotype.Service;

@Service
public class TrackService {
    private final TrackRepo trackRepo;
    private final AlbumRepo albumRepo;
    private final TrackMapper trackMapper;

    public TrackService(TrackRepo trackRepo, AlbumRepo albumRepo, TrackMapper trackMapper) {
        this.trackRepo = trackRepo;
        this.albumRepo = albumRepo;
        this.trackMapper = trackMapper;
    }

    public Track createTrack(TrackEntity track, Long albumId) throws TrackAlreadyExistException {
        if (trackRepo.findByTitle(track.getTitle()) != null) {
            throw new TrackAlreadyExistException("Track already exist!");
        }
        AlbumEntity album = albumRepo.findById(albumId).get();
        track.setAlbum(album);
        trackRepo.save(track);
        return trackMapper.toDto(track);
    }
}
