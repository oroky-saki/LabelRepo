package com.label.mylabel.controller;

import com.label.mylabel.entity.BandEntity;
import com.label.mylabel.exceptions.BandAlreadyExistException;
import com.label.mylabel.exceptions.BandNotFoundException;
import com.label.mylabel.service.BandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/band")
public class BandController {

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    private final BandService bandService;

    @GetMapping("/{id}")
    public ResponseEntity getOneBand(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bandService.getBand(id));
        } catch (BandNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createBand(@RequestBody BandEntity band) {
        try {
            return ResponseEntity.ok(bandService.createBand(band));
        } catch (BandAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBand(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bandService.deleteBand(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity putBand(@RequestBody BandEntity band) {
        try {
            return ResponseEntity.ok(bandService.changeBand(band));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchBand(@PathVariable Long id, @RequestBody BandEntity band) {
        try {
            return ResponseEntity.ok(bandService.pathBand(band));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
