package com.bukable.lottery.repository;

import com.bukable.lottery.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with Participant in database
 *
 * @author Max_Vitko
 * @version 1.0
 * @see Participant
 */

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
