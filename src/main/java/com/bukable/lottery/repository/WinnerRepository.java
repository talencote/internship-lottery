package com.bukable.lottery.repository;

import com.bukable.lottery.model.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for working with Winner in database
 *
 * @author Max_Vitko
 * @version 1.0
 * @see Winner
 */

@Repository
public interface WinnerRepository extends JpaRepository<Winner, Long> {
}
