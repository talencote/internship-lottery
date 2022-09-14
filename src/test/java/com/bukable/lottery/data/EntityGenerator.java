package com.bukable.lottery.data;

import com.bukable.lottery.dto.WinnerDto;
import com.bukable.lottery.model.Participant;
import com.bukable.lottery.model.Winner;
import com.bukable.lottery.request.CreateNewParticipantRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class EntityGenerator {

    private final static int minLength = 2;
    private final static int maxLengthForName = 12;
    private final static int maxLengthForAddress = 25;
    private final static int minAge = 18;
    private final static int maxAge = 99;

    private EntityGenerator() {
    }

    public static CreateNewParticipantRequest getNewParticipantRequest() {
        return new CreateNewParticipantRequest(
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForName),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForAddress),
                RandomUtils.nextInt(minAge, maxAge)
        );
    }

    public static Participant getSingleParticipant() {
        return new Participant(
                RandomUtils.nextLong(),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForName),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForAddress),
                RandomUtils.nextInt(minAge, maxAge)
        );
    }

    public static List<Participant> getListOfParticipants(int amountOfParticipants) {
        List<Participant> list = new ArrayList<>();
        for (int i = 0; i < amountOfParticipants; i++) {
            list.add(getSingleParticipant());
        }
        return list;
    }

    public static Winner getSingleWinner() {
        int minWin = 1;
        int maxWin = 1000;
        return new Winner(
                RandomUtils.nextLong(),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForName),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForAddress),
                RandomUtils.nextInt(minAge, maxAge),
                RandomUtils.nextInt(minWin, maxWin)
        );
    }

    public static List<Winner> getListOfWinners(int amountOfWinners) {
        List<Winner> list = new ArrayList<>();
        for (int i = 0; i < amountOfWinners; i++) {
            list.add(getSingleWinner());
        }
        return list;
    }

    public static WinnerDto getSingleWinnerDto() {
        int minWin = 1;
        int maxWin = 1000;
        return new WinnerDto(
                RandomUtils.nextLong(),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForName),
                RandomStringUtils.randomAlphabetic(minLength, maxLengthForAddress),
                RandomUtils.nextInt(minAge, maxAge),
                RandomUtils.nextInt(minWin, maxWin)
        );
    }
}
