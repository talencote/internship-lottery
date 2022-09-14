package com.bukable.lottery.service.Impl;

import com.bukable.lottery.exception.NotEnoughParticipantsException;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.repository.ParticipantRepository;
import com.bukable.lottery.repository.WinnerRepository;
import com.bukable.lottery.service.LotteryService;
import com.bukable.lottery.util.LotteryUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    private final ParticipantRepository participantRepository;
    private final WinnerRepository winnerRepository;

    public Winner lotteryStart() {
        List<Participant> participants = participantRepository.findAll();

        if (participants.size() < 2) {
            throw new NotEnoughParticipantsException();
        }
        int win = LotteryUtils.getRandomValue(restTemplate, 1, 1000);
        int winnerIndex = LotteryUtils.getRandomValue(restTemplate, 1, participants.size()) - 1;
        Winner winner = modelMapper.map(participants.get(winnerIndex), Winner.class);
        winner.setWin(win);
        winnerRepository.save(winner);
        participantRepository.deleteAll();
        return winner;
    }
}
