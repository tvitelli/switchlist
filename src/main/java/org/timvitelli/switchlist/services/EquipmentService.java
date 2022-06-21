package org.timvitelli.switchlist.services;

import org.timvitelli.switchlist.models.Equipment;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getAllEquipment();

    Equipment saveEquipment(Equipment equipment);

    Equipment getEquipmentById(Integer id);

    Equipment updateEquipment(Equipment equipment);

    void deleteEquipmentById(Integer id);
}
