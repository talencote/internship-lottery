package com.bukable.lottery.controller;

import com.bukable.lottery.dto.ParticipantDto;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.request.CreateNewParticipantRequest;
import com.bukable.lottery.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller that handles requests about Participants
 *
 * @author Max_Vitko
 * @version 1.0
 */

@RestController
@RequestMapping("/lottery/participant")
@AllArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;
    private final ModelMapper modelMapper;

    /**
     * GET request to receive all participants
     *
     * @return Full list of participants
     */
    @GetMapping
    public List<ParticipantDto> getAll() {
        List<Participant> participants = participantService.getAll();
        return participants
                .stream()
                .map(participant -> modelMapper.map(participant, ParticipantDto.class))
                .collect(Collectors.toList());
    }

    /**
     * POST request to create participant
     *
     * @param request participant entity body
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateNewParticipantRequest request) {
        Participant participant = modelMapper.map(request, Participant.class);
        participantService.create(participant);
    }
}
