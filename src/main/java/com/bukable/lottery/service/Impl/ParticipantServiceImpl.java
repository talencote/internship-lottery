package com.bukable.lottery.service.Impl;

import com.bukable.lottery.model.Participant;
import com.bukable.lottery.repository.ParticipantRepository;
import com.bukable.lottery.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    @Override
    public void create(Participant participant) {
        participantRepository.save(participant);
    }
}
