package org.timvitelli.switchlist.services;

import org.springframework.stereotype.Service;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.models.Track;
import org.timvitelli.switchlist.repositories.EquipmentRepository;
import org.timvitelli.switchlist.repositories.TrackRepository;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    private EquipmentRepository equipmentRepository;

    public TrackServiceImpl(TrackRepository trackRepository, EquipmentRepository equipmentRepository) {
        super();
        this.trackRepository = trackRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) {
        // Wrap in try-catch with bind exception
        try {
            return trackRepository.save(track);
        }catch (Exception e) {
            System.out.println("Track did not save.");
        }
        return null;
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
    public Boolean deleteTrackById(Integer id) {
        if (!trackInUse(id)) {
            trackRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Boolean trackInUse(Integer id) {
        Track track = getTrackById(id);
        List<Equipment> currentListOfEquipment = equipmentRepository.findEquipmentByCurrentLocation(track);
        List<Equipment> futureListOfEquipment = equipmentRepository.findEquipmentByFutureLocation(track);
        return !(currentListOfEquipment.size() == 0 && futureListOfEquipment.size() == 0);
    }
}
