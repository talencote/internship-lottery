package com.bukable.lottery.controller;

import com.bukable.lottery.dto.WinnerDto;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.service.WinnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller that handles requests about Winners
 *
 * @author Max_Vitko
 * @version 1.0
 */

@RestController
@RequestMapping("/lottery/winners")
@AllArgsConstructor
public class WinnerController {

    private final ModelMapper modelMapper;
    private final WinnerService winnerService;

    /**
     * GET request to receive all winners
     *
     * @return Full list of winners
     */
    @GetMapping
    public List<WinnerDto> getAll() {
        List<Winner> winners = winnerService.getAll();
        return winners
                .stream()
                .map(winner -> modelMapper.map(winner, WinnerDto.class))
                .collect(Collectors.toList());
    }
}
