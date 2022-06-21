package org.timvitelli.switchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timvitelli.switchlist.models.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
}
