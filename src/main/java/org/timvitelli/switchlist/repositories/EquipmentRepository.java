package org.timvitelli.switchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timvitelli.switchlist.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}
