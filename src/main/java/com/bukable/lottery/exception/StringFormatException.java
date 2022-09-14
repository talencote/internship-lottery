package com.bukable.lottery.exception;

public class StringFormatException {

    private StringFormatException() {

    }

    public static String lotteryCannotStart() {
        return "Lottery cannot start";
    }

    public static String lotteryCannotStartCause() {
        return "Not Enough Participants";
    }
}
