package com.label.mylabel.controller;

import com.label.mylabel.entity.MusicianEntity;
import com.label.mylabel.exceptions.MusicianAlreadyExistException;
import com.label.mylabel.service.MusicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musician")
public class MusicianController {

    private final MusicianService musicianService;

    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }

    @PostMapping
    public ResponseEntity createMusician(@RequestBody MusicianEntity musician,
                                         @RequestParam Long bandId) {
        try {
            return ResponseEntity.ok(musicianService.createMusician(musician, bandId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
