package com.woowahan.study.java.work2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class IntegerTest {

    @Test
    public void 문자열에_0이_포함되도_숫자반환된다() {
        //given
        String target = "01";

        //when
        int result = Integer.parseInt(target);

        //then
        assertThat(result, is(1));
    }
}
