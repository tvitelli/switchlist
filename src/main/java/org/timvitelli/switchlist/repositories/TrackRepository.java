package org.timvitelli.switchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.timvitelli.switchlist.models.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {
}
