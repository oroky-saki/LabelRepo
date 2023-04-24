package com.label.mylabel.controller;

import com.label.mylabel.entity.TrackEntity;
import com.label.mylabel.exceptions.TrackAlreadyExistException;
import com.label.mylabel.service.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/track")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public ResponseEntity createTrack(@RequestBody TrackEntity track,
                                      @RequestParam Long albumId) {
        try {
            return ResponseEntity.ok(trackService.createTrack(track, albumId));
        } catch (TrackAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
