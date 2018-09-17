package com.woowahan.study.java.work2;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class DatePatternTest {

    @Test
    public void 슬래시가_있어도_날짜로_반환된다() {
        //given
        String memo = "2018/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.";

        //when
        LocalDate result = DatePattern.parseAll(memo);

        //then
        assertThat(result, is(LocalDate.of(2018,7,3)));
    }

    @Test
    public void 년에_2자리가_있어도_날짜로_반환된다() {
        //given
        String memo = "18/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.";

        //when
        LocalDate result = DatePattern.parseAll(memo);

        //then
        assertThat(result, is(LocalDate.of(2018,7,3)));
    }

    @Test
    public void 년월일로_있어도_날짜로_반환된다() {
        //given
        String memo = "타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일";

        //when
        LocalDate result = DatePattern.parseAll(memo);

        //then
        assertThat(result, is(LocalDate.of(2018,6,13)));
    }

    @Test
    public void 대시로_있어도_날짜로_반환된다() {
        //given
        String memo = "배민은행앞 별다방에서 18-06-12에 만나기로 함";

        //when
        LocalDate result = DatePattern.parseAll(memo);

        //then
        assertThat(result, is(LocalDate.of(2018,6,12)));
    }

}
