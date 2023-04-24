package com.label.mylabel.controller;

import com.label.mylabel.entity.AlbumEntity;
import com.label.mylabel.exceptions.AlbumAlreadyExistException;
import com.label.mylabel.exceptions.BandIsNotExist;
import com.label.mylabel.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity createAlbum(@RequestBody AlbumEntity album,
                                      @RequestParam Long bandId) {
        try {
            return ResponseEntity.ok(albumService.createAlbum(album, bandId));
        } catch (AlbumAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getAlbumsByBand(@RequestParam String band) {
        try {
            return ResponseEntity.ok(albumService.getAlbumsByBand(band));
        } catch (BandIsNotExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
