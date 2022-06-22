package org.timvitelli.switchlist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.models.Track;
import org.timvitelli.switchlist.services.TrackService;

@Controller
public class TrackController {

    private TrackService trackService;

    public TrackController(TrackService trackService) {
        super();
        this.trackService = trackService;
    }

    //handler method to handle list tracks and return model and view
    @GetMapping("/track")
    public String listTrack(Model model) {
        model.addAttribute("track", trackService.getAllTrack());
        return "track";
    }
    @GetMapping("/track/new")
    public String createTrackForm(Model model) {
        //create track object to hold track form data
        Track track = new Track();
        model.addAttribute("track", track);
        return "create_track";
    }

    @PostMapping("/track")
    public String saveTrack(@ModelAttribute("track") Track track) {
        trackService.saveTrack(track);
        return "redirect:/track";
    }
    @GetMapping("/track/edit/{id}")
    public String editTrackForm(@PathVariable Integer id, Model model) {
        model.addAttribute("track", trackService.getTrackById(id));
        return "edit_track";
    }
    @PostMapping("/track/{id}")
    public String updateTrack(@PathVariable Integer id, @ModelAttribute("track") Track track, Model model) {
        //get track from database by id
        Track existingTrack = trackService.getTrackById(id);
        existingTrack.setId(id);
        existingTrack.setTrackName(track.getTrackName());
        existingTrack.setLength(track.getLength());
        existingTrack.setLadingType(track.getLadingType());
        //save updated track
        trackService.updateTrack(existingTrack);
        return "redirect:/track";

    }
    // set up error page mapping for below delete
    @GetMapping("/track_error")
    public String trackError() {
        return "track_error";
    }

    // delete track by ID
    @GetMapping("/track/{id}")
    public String deleteTrack(@PathVariable Integer id) {
        if (trackService.deleteTrackById(id)) {
           return "redirect:/track";
         }
     else {
            return "redirect:/track_error";
        }
    }

}
