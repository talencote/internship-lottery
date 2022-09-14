package com.bukable.lottery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for entity Winner
 *
 * @author Max_Vitko
 * @version 1.0
 * @see com.bukable.lottery.model.Winner
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinnerDto {
    private Long id;
    private String name;
    private String address;
    private Integer age;
    private Integer win;
}
