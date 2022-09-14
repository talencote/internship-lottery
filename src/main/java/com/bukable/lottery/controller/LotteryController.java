package com.bukable.lottery.controller;

import com.bukable.lottery.dto.WinnerDto;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.service.LotteryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that handles requests about Lottery
 *
 * @author Max_Vitko
 * @version 1.0
 */

@RestController
@RequestMapping("/lottery/start")
@AllArgsConstructor
public class LotteryController {

    private final LotteryService lotteryService;
    private final ModelMapper modelMapper;

    /**
     * GET request to start our lottery
     *
     * @return Winner of lottery
     */
    @GetMapping
    public WinnerDto lotteryStart() {
        Winner winner = lotteryService.lotteryStart();
        return modelMapper.map(winner, WinnerDto.class);
    }
}
