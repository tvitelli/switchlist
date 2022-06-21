package org.timvitelli.switchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timvitelli.switchlist.models.CarType;

public interface CarTypeRepository extends JpaRepository<CarType, Integer> {
}
