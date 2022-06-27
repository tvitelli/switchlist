package org.timvitelli.switchlist.services;

import org.springframework.stereotype.Service;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.models.Track;
import org.timvitelli.switchlist.repositories.EquipmentRepository;
import org.timvitelli.switchlist.repositories.TrackRepository;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    //Service implements methods for CRUD operations with SwitchlistDB for Equipment and Track tables
    private TrackRepository trackRepository;
    private EquipmentRepository equipmentRepository;

    public TrackServiceImpl(TrackRepository trackRepository, EquipmentRepository equipmentRepository) {
        super();
        this.trackRepository = trackRepository;
        this.equipmentRepository = equipmentRepository;
    }

    //retrieves all track rows for Track list page
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

    //sends request to retrieve individual row in Track table based on ID criteria
    @Override
    public Track getTrackById(Integer id) {
        return trackRepository.findById(id).get();
    }

    //sends request to update row in track table
    @Override
    public Track updateTrack(Track track) {
        return trackRepository.save(track);
    }

    //sends request to delete row in track table
    @Override
    public Boolean deleteTrackById(Integer id) {
        if (!trackInUse(id)) {
            trackRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //implements data check using custom queries from EquipmentRepository to verify Track is not referenced
    private Boolean trackInUse(Integer id) {
        Track track = getTrackById(id);
        List<Equipment> currentListOfEquipment = equipmentRepository.findEquipmentByCurrentLocation(track);
        List<Equipment> futureListOfEquipment = equipmentRepository.findEquipmentByFutureLocation(track);
        return !(currentListOfEquipment.size() == 0 && futureListOfEquipment.size() == 0);
    }
}
