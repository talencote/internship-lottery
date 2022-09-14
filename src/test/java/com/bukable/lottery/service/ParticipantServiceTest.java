package com.bukable.lottery.service;

import com.bukable.lottery.data.EntityGenerator;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.repository.ParticipantRepository;
import com.bukable.lottery.service.Impl.ParticipantServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {

    private ParticipantService participantService;

    @Mock private ParticipantRepository participantRepository;

    @BeforeEach
    public void init() {
        participantService = new ParticipantServiceImpl(participantRepository);
    }

    @AfterEach
    public void clear() {
        participantRepository.deleteAll();
    }

    @Test
    @DisplayName("Check if we can get all participants")
    void getAllParticipants() {
        participantService.getAll();
        Mockito.verify(participantRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Check if we can create new participant")
    void createNewParticipant() {
        Participant participant = EntityGenerator.getSingleParticipant();
        participantService.create(participant);
        Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
    }
}