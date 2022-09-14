package com.bukable.lottery.service;

import com.bukable.lottery.repository.WinnerRepository;
import com.bukable.lottery.service.Impl.WinnerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WinnerServiceTest {

    private WinnerService winnerService;

    @Mock private WinnerRepository winnerRepository;

    @BeforeEach
    public void init() {
        winnerService = new WinnerServiceImpl(winnerRepository);
    }

    @AfterEach
    public void clear() {
        winnerRepository.deleteAll();
    }

    @Test
    @DisplayName("Check if we can get all winners")
    void getAllWinners() {
        winnerService.getAll();
        Mockito.verify(winnerRepository, Mockito.times(1)).findAll();
    }
}