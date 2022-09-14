package com.bukable.lottery.util;

import org.springframework.web.client.RestTemplate;

public class LotteryUtils {

    private LotteryUtils(){}

    public static Integer getRandomValue(RestTemplate restTemplate, Integer min, Integer max) {
        String randomValue = restTemplate.getForObject(
                "https://www.random.org/integers/?num=1&min={min}&max={max}&col=1&base=10&format=plain&rnd=new",
                String.class,
                min,
                max
        ).trim();
        return Integer.parseInt(randomValue);
    }
}
