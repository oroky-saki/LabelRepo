package com.label.mylabel.service;

import com.label.mylabel.entity.AlbumEntity;
import com.label.mylabel.entity.TrackEntity;
import com.label.mylabel.exceptions.AlbumIsNotExistException;
import com.label.mylabel.exceptions.TrackAlreadyExistException;
import com.label.mylabel.exceptions.TrackIsNotExistException;
import com.label.mylabel.mapper.TrackMapper;
import com.label.mylabel.model.Track;
import com.label.mylabel.repository.AlbumRepo;
import com.label.mylabel.repository.TrackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String deleteTrackById(Long trackId) throws TrackIsNotExistException {
        Optional<TrackEntity> track = trackRepo.findById(trackId);
        if (track.isEmpty()) {
            throw new TrackIsNotExistException("Track is not exist");
        }
        trackRepo.delete(track.get());
        return "Track \"" + track.get().getTitle() + "\" has been deleted";
    }

    public List<Track> getTracksByAlbumId(Long albumId) throws AlbumIsNotExistException {
        Optional<AlbumEntity> album = albumRepo.findById(albumId);
        if (album.isEmpty()) {
            throw new AlbumIsNotExistException("Album is not exist");
        }
        return trackMapper.toDtoList(trackRepo.findAllByAlbum(album.get()));
    }
}
