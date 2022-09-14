package com.bukable.lottery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ExceptionDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionDetails(String message, String details) {
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
    }
}
