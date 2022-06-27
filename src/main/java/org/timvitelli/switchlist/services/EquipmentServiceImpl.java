package org.timvitelli.switchlist.services;

import org.springframework.stereotype.Service;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.repositories.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    //Service implements methods for CRUD operation requests with SwitchlistDB for Equipment table
    private EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        super();
        this.equipmentRepository = equipmentRepository;
    }

    //sends request to retrieve all rows for Equipment list page
    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        // Wrap in try-catch with bind exception for referential integrity
        try {
            return equipmentRepository.save(equipment);
        }catch (Exception e) {
            System.out.println("Equipment did not save.");
        }
        return null;
    }

    //sends request to retrieve individual row based on ID criteria
    @Override
    public Equipment getEquipmentById(Integer id) {
        return equipmentRepository.findById(id).get();
    }

    //sends request to update row in equipment table
    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    //sends request to delete row in equipment table
    @Override
    public void deleteEquipmentById(Integer id) {
        equipmentRepository.deleteById(id);
    }

}
