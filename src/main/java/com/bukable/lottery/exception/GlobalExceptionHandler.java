package com.bukable.lottery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> participantNotCreatedException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseEntity<>(
                new ExceptionDetails(methodArgumentNotValidException.getFieldError().getDefaultMessage(), methodArgumentNotValidException.getFieldError().getField()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotEnoughParticipantsException.class)
    public ResponseEntity<ExceptionDetails> notEnoughParticipants() {
        return new ResponseEntity<>(
                new ExceptionDetails(StringFormatException.lotteryCannotStart(), StringFormatException.lotteryCannotStartCause()),
                HttpStatus.BAD_REQUEST
        );
    }
}
