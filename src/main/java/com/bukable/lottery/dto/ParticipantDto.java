package com.bukable.lottery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for entity Participant
 *
 * @author Max_Vitko
 * @version 1.0
 * @see com.bukable.lottery.model.Participant
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto {
    private Long id;
    private String name;
    private String address;
    private Integer age;
}
