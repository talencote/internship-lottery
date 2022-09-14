package com.bukable.lottery.controller;

import com.bukable.lottery.data.EntityGenerator;
import com.bukable.lottery.dto.WinnerDto;
import com.bukable.lottery.exception.NotEnoughParticipantsException;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.service.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LotteryControllerTest {

    private LotteryController lotteryController;

    @Mock private LotteryService lotteryService;
    @Mock private ModelMapper modelMapper;

    @BeforeEach
    public void init() {
        lotteryController = new LotteryController(lotteryService, modelMapper);
    }

    @Test
    @DisplayName("Check if we can start lottery with valid amount of participants")
    public void lotteryStart_valid() {
        Winner expectedWinner = EntityGenerator.getSingleWinner();
        WinnerDto winnerDto = EntityGenerator.getSingleWinnerDto();

        when(lotteryService.lotteryStart()).thenReturn(expectedWinner);
        when(modelMapper.map(expectedWinner, WinnerDto.class)).thenReturn(winnerDto);
        WinnerDto actualWinnerDto = lotteryController.lotteryStart();

        Mockito.verify(lotteryService, times(1)).lotteryStart();
    }

    @Test
    @DisplayName("Check if we can start lottery with invalid amount of participants")
    public void lotteryStart_invalid() {
        when(lotteryService.lotteryStart()).thenThrow(NotEnoughParticipantsException.class);

        assertThrows(NotEnoughParticipantsException.class, () -> lotteryController.lotteryStart());
        Mockito.verify(lotteryService, times(1)).lotteryStart();
    }
}