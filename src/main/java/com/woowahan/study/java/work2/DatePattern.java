package com.woowahan.study.java.work2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Getter
@AllArgsConstructor
public enum DatePattern {

    SLASH ("\\d{2,4}/\\d{1,2}/\\d{1,2}", "/"),
    KOREAN ("[0-9]{2,4}년[0-9]{1,2}월[0-9]{1,2}일", "년|월|일"),
    DASH ("\\d{2,4}-\\d{1,2}-\\d{1,2}", "-");

    private String pattern;
    private String split;

    public static LocalDate parseAll (String memo) {
        return Arrays.stream(DatePattern.values())
                .filter(e -> e.find(memo))
                .findAny()
                .map(e -> e.parse(memo))
                .orElseThrow(() -> new IllegalArgumentException("일치하는 패턴이 없습니다."));
    }

    public boolean find(String memo){
        Matcher matcher = Pattern.compile(pattern).matcher(memo);
        return matcher.find();
    }

    public LocalDate parse (String memo){
        Matcher matcher = Pattern.compile(pattern).matcher(memo);
        if(matcher.find()){
            String strDate = matcher.group(0);
            String[] dates = strDate.split(split);
            String year = getYear(dates[0]);

            return LocalDate.of(Integer.parseInt(year), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
        }

        return null;
    }

    private String getYear(String date) {
        return date.length() == 2? 20+ date : date;
    }


}
