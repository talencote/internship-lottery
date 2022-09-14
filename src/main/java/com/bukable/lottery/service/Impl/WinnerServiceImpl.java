package com.bukable.lottery.service.Impl;

import com.bukable.lottery.model.Winner;
import com.bukable.lottery.repository.WinnerRepository;
import com.bukable.lottery.service.WinnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WinnerServiceImpl implements WinnerService {

    private WinnerRepository winnerRepository;

    @Override
    public List<Winner> getAll() {
        return winnerRepository.findAll();
    }
}
