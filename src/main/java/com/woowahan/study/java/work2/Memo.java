package com.woowahan.study.java.work2;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@ToString
@Getter
public class Memo {

    private String memo;
    private LocalDate date;

    public Memo(String memo) {
        this.memo = memo;
        this.date = DatePattern.parseAll(memo);
    }
}
