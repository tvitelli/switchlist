package org.timvitelli.switchlist.services;

import org.springframework.stereotype.Service;
import org.timvitelli.switchlist.models.Equipment;
import org.timvitelli.switchlist.repositories.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository equipmentRepository;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        super();
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        // Wrap in try-catch with bind exception also in Track
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment getEquipmentById(Integer id) {
        return equipmentRepository.findById(id).get();
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipmentById(Integer id) {
        equipmentRepository.deleteById(id);
    }
}
