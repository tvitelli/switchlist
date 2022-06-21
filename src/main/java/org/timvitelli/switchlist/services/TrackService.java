package org.timvitelli.switchlist.services;

import org.timvitelli.switchlist.models.Track;

import java.util.List;


public interface TrackService {

    List<Track> getAllTrack();

    Track saveTrack(Track track);

    Track getTrackById(Integer id);

    Track updateTrack(Track track);

    void deleteTrackById(Integer id);
}
