package com.label.mylabel.service;

import com.label.mylabel.entity.BandEntity;
import com.label.mylabel.entity.MusicianEntity;
import com.label.mylabel.exceptions.MusicianAlreadyExistException;
import com.label.mylabel.model.Musician;
import com.label.mylabel.repository.BandsRepo;
import com.label.mylabel.repository.MusicianRepo;
import org.springframework.stereotype.Service;

@Service
public class MusicianService {
    private final MusicianRepo musicianRepo;
    private final BandsRepo bandsRepo;

    public MusicianService(MusicianRepo musicianRepo, BandsRepo bandsRepo) {
        this.musicianRepo = musicianRepo;
        this.bandsRepo = bandsRepo;
    }

    public Musician createMusician(MusicianEntity musician, Long bandId) throws MusicianAlreadyExistException {
        if (musicianRepo.findByName(musician.getName()) != null) {
            throw new MusicianAlreadyExistException("Musician already exist!");
        }
        BandEntity band = bandsRepo.findById(bandId).get();
        musician.setBand(band);
        return Musician.toModel(musicianRepo.save(musician));
    }
}
