package com.label.mylabel.service;

import com.label.mylabel.entity.BandEntity;
import com.label.mylabel.exceptions.BandAlreadyExistException;
import com.label.mylabel.exceptions.BandIsNotExist;
import com.label.mylabel.exceptions.BandNotFoundException;
import com.label.mylabel.model.Band;
import com.label.mylabel.repository.BandsRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandService {

    private final BandsRepo bandsRepo;

    public BandService(BandsRepo bandsRepo) {
        this.bandsRepo = bandsRepo;
    }

    public Band getBand(Long id) throws BandNotFoundException {

        Optional<BandEntity> band = bandsRepo.findById(id);

        if (band.isEmpty()) {
            throw new BandNotFoundException("Band not found");
        }
        return Band.toModel(band.get());
    }

    public Band createBand(BandEntity band) throws BandAlreadyExistException {
        if (bandsRepo.findByName(band.getName()) != null) {
            throw new BandAlreadyExistException("Band already exist!");
        }
        return Band.toModel(bandsRepo.save(band));
    }

    public String deleteBand(Long id) throws BandIsNotExist {

        Optional<BandEntity> band = bandsRepo.findById(id);

        if (band.isEmpty()) {
            throw new BandIsNotExist("Band with this ID is not exist");
        }
        bandsRepo.deleteById(id);
        return String.format("Band with ID: %d has been successfully deleted", id);
    }

    public Band changeBand(BandEntity entity) throws BandIsNotExist {

        Optional<BandEntity> band = bandsRepo.findById(entity.getId());

        if (band.isEmpty()) {
            throw new BandIsNotExist("Band with this ID is not exist");
        }

        return Band.toModel(bandsRepo.save(entity));
    }

    public Band pathBand(BandEntity entity) throws BandIsNotExist {

        Optional<BandEntity> band = bandsRepo.findById(entity.getId());

        if (band.isEmpty()) {
            throw new BandIsNotExist("Band with this ID is not exist");
        }
        BandEntity newBand = band.get();

        if (entity.getName() != null) {
            newBand.setName(entity.getName());
        }
        if (entity.getGenre() != null) {
            newBand.setGenre(entity.getGenre());
        }
        if (entity.getLabel() != null) {
            newBand.setLabel(entity.getLabel());
        }
        bandsRepo.save(newBand);
        return Band.toModel(newBand);
    }

}
