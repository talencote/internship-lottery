package com.bukable.lottery.service;

import com.bukable.lottery.data.EntityGenerator;
import com.bukable.lottery.exception.NotEnoughParticipantsException;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.repository.ParticipantRepository;
import com.bukable.lottery.repository.WinnerRepository;
import com.bukable.lottery.service.Impl.LotteryServiceImpl;
import com.bukable.lottery.util.LotteryUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LotteryServiceTest {

    private LotteryService lotteryService;

    @Mock private WinnerRepository winnerRepository;
    @Mock private ParticipantRepository participantRepository;
    @Mock private ModelMapper modelMapper;
    @Mock private RestTemplate restTemplate;

    @BeforeEach
    public void init() {
        lotteryService = new LotteryServiceImpl(modelMapper, restTemplate, participantRepository, winnerRepository);
    }

    @AfterEach
    public void clear() {
        winnerRepository.deleteAll();
        participantRepository.deleteAll();
    }

    @Test
    @DisplayName("Check is lottery start when participants is valid")
    void lotteryStart_valid() {
        List<Participant> participants = EntityGenerator.getListOfParticipants(2);
        when(participantRepository.findAll()).thenReturn(participants);
        when(modelMapper.map(participants.get(0), Winner.class)).thenReturn(EntityGenerator.getSingleWinner());
        try (MockedStatic<LotteryUtils> lotteryUtilsMockedStatic = Mockito.mockStatic(LotteryUtils.class)) {
            lotteryUtilsMockedStatic.when(() -> LotteryUtils.getRandomValue(restTemplate, 1, 1000)).thenReturn(500);
            lotteryUtilsMockedStatic.when(() -> LotteryUtils.getRandomValue(restTemplate, 1, participants.size())).thenReturn(1);

            Winner winner = lotteryService.lotteryStart();

            assertNotNull(winner.getWin());
        }
    }

    @Test
    @DisplayName("Check is lottery start with no participants")
    void lotteryStart_notEnough() {
        List<Participant> participants = EntityGenerator.getListOfParticipants(1);
        when(participantRepository.findAll()).thenReturn(participants);

        assertThrows(NotEnoughParticipantsException.class, () -> lotteryService.lotteryStart());
    }
}