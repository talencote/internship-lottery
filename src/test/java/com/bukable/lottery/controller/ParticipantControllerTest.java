package com.bukable.lottery.controller;

import com.bukable.lottery.data.EntityGenerator;
import com.bukable.lottery.dto.ParticipantDto;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.request.CreateNewParticipantRequest;
import com.bukable.lottery.service.ParticipantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParticipantControllerTest {

    private ParticipantController participantController;

    @Mock private ParticipantService participantService;
    @Mock private ModelMapper modelMapper;

    @BeforeEach
    public void init() {
        participantController = new ParticipantController(participantService, modelMapper);
    }

    @Test
    @DisplayName("Check if we can get all winners if is not empty")
    void getAllParticipants_notEmpty() {
        int amountOfParticipants = 5;
        when(participantService.getAll()).thenReturn(EntityGenerator.getListOfParticipants(amountOfParticipants));
        List<ParticipantDto> participantsDto = participantController.getAll();

        Mockito.verify(participantService, times(1)).getAll();
        assertEquals(amountOfParticipants, participantsDto.size());
    }

    @Test
    @DisplayName("Check if we can get all winners if is empty")
    void getAllParticipants_Empty() {
        int amountOfParticipants = 0;
        when(participantService.getAll()).thenReturn(EntityGenerator.getListOfParticipants(amountOfParticipants));
        List<ParticipantDto> participantsDto = participantController.getAll();

        Mockito.verify(participantService, times(1)).getAll();
        assertEquals(amountOfParticipants, participantsDto.size());
    }

    @Test
    @DisplayName("Check if we can create new participant")
    void createNewParticipant() {
        CreateNewParticipantRequest participantRequest = EntityGenerator.getNewParticipantRequest();
        Participant participant = EntityGenerator.getSingleParticipant();
        when(modelMapper.map(participantRequest, Participant.class)).thenReturn(participant);

        participantController.create(participantRequest);

        verify(participantService, times(1)).create(participant);
    }
}