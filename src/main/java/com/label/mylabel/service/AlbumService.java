package com.label.mylabel.service;

import com.label.mylabel.entity.AlbumEntity;
import com.label.mylabel.entity.BandEntity;
import com.label.mylabel.exceptions.AlbumAlreadyExistException;
import com.label.mylabel.exceptions.BandIsNotExist;
import com.label.mylabel.exceptions.MusicianAlreadyExistException;
import com.label.mylabel.model.Album;
import com.label.mylabel.repository.AlbumRepo;
import com.label.mylabel.repository.BandsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    private final AlbumRepo albumRepo;
    private final BandsRepo bandsRepo;

    public AlbumService(AlbumRepo albumRepo, BandsRepo bandsRepo) {
        this.albumRepo = albumRepo;
        this.bandsRepo = bandsRepo;
    }

    public Album createAlbum(AlbumEntity album, Long bandId) throws AlbumAlreadyExistException {
        if (albumRepo.findByTitle(album.getTitle()) != null) {
            throw new AlbumAlreadyExistException("Album already exist!");
        }
        BandEntity band = bandsRepo.findById(bandId).get();
        album.setBand(band);
        return Album.toModel(albumRepo.save(album));
    }

    public List<Album> getAlbumsByBand(String band) throws BandIsNotExist {

        BandEntity targetBand = bandsRepo.findByName(band);

        if (targetBand == null) {
            throw new BandIsNotExist("This band is not exist");
        }

        return albumRepo.findAllByBand(targetBand).stream().map(Album::toModel).collect(Collectors.toList());
    }
}
