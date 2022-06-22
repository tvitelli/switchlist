package org.timvitelli.switchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.models.Track;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    @Query("SELECT e FROM equipment e WHERE e.currentLocation = ?1 ")
    public List<Equipment> findEquipmentByCurrentLocation(Track trackId);

    @Query("SELECT e FROM equipment e WHERE e.futureLocation = ?1 ")
    public List<Equipment> findEquipmentByFutureLocation(Track trackId);

}
