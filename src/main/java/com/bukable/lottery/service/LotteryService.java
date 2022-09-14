package com.bukable.lottery.service;

import com.bukable.lottery.model.Winner;

/**
 * Service layer for validation and business logic for Lottery
 *
 * @author Max_Vitko
 * @version 1.0
 */

public interface LotteryService {

    /**
     * @return List winner of the lottery
     */
    Winner lotteryStart();
}
