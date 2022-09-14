package com.bukable.lottery.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CreateNewParticipantRequest {

    @Size(min = 2, max = 12)
    @NotNull
    private String name;

    @Size(min = 2, max = 25)
    @NotNull
    private String address;

    @Min(value = 18)
    @NotNull
    private Integer age;

}
