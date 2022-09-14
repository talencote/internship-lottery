package com.bukable.lottery.controller;

import com.bukable.lottery.data.EntityGenerator;
import com.bukable.lottery.dto.WinnerDto;
import com.bukable.lottery.service.WinnerService;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WinnerControllerTest {

    private WinnerController winnerController;

    @Mock private ModelMapper modelMapper;
    @Mock private WinnerService winnerService;

    @BeforeEach
    public void init() {
        winnerController = new WinnerController(modelMapper, winnerService);
    }

    @Test
    @DisplayName("Check if we can get all winners if is not empty")
    void getAllWinners_notEmpty() {
        int amountOfWinners = 1;
        when(winnerService.getAll()).thenReturn(EntityGenerator.getListOfWinners(amountOfWinners));
        List<WinnerDto> winners = winnerController.getAll();

        Mockito.verify(winnerService, times(1)).getAll();
        assertEquals(amountOfWinners, winners.size());
    }

    @Test
    @DisplayName("Check if we can get all winners if is empty")
    void getAllWinners_Empty() {
        int amountOfWinners = 0;
        when(winnerService.getAll()).thenReturn(EntityGenerator.getListOfWinners(amountOfWinners));
        List<WinnerDto> winners = winnerController.getAll();

        Mockito.verify(winnerService, times(1)).getAll();
        assertEquals(amountOfWinners, winners.size());
    }
}