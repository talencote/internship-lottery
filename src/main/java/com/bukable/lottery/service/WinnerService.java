package com.bukable.lottery.service;

import com.bukable.lottery.model.Winner;

import java.util.List;

/**
 * Service layer for validation and business logic for WinnerRepository
 *
 * @author Max_Vitko
 * @version 1.0
 * @see com.bukable.lottery.repository.WinnerRepository
 */

public interface WinnerService {

    /**
     * @return List of all exists winners
     */
    List<Winner> getAll();
}
