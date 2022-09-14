package com.bukable.lottery.service;

import com.bukable.lottery.model.Participant;

import java.util.List;

/**
 * Service layer for validation and business logic for ParticipantRepository
 *
 * @author Max_Vitko
 * @version 1.0
 * @see com.bukable.lottery.repository.ParticipantRepository
 */

public interface ParticipantService {

    /**
     * @return List of all exists participants
     */
    List<Participant> getAll();


    /**
     * Create new participant in database
     *
     * @param participant body of our participant
     */
    void create(Participant participant);
}
