package org.timvitelli.switchlist.services;

import org.springframework.stereotype.Service;
import org.timvitelli.switchlist.models.Track;
import org.timvitelli.switchlist.repositories.TrackRepository;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    private TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        super();
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) {
        // Wrap in try-catch with bind exception
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(Integer id) {
        return trackRepository.findById(id).get();
    }

    @Override
    public Track updateTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void deleteTrackById(Integer id) {
        trackRepository.deleteById(id);
    }
}
