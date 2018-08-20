package com.woowahan.study.java.work1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jojoldu@gmail.com on 20/08/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class NumberSumGameTest {

    private NumberSumGame numberSumGame = new NumberSumGame();

    @Test
    public void 입출력_예제1() {
        //given
        List<Integer> cards = Arrays.asList(1,2,3,4,5);
        int gameMasterPickNumber = 8;

        //when
        String result = numberSumGame.pick(cards, gameMasterPickNumber);

        //then
        assertThat(result, is("1 2 5\n1 3 4"));
    }

    @Test
    public void 입출력_예제2() {
        //given
        List<Integer> cards = Arrays.asList(1,2,3,4,5);
        int gameMasterPickNumber = 3;

        //when
        String result = numberSumGame.pick(cards, gameMasterPickNumber);

        //then
        assertThat(result, is("NO"));
    }

    @Test
    public void 입출력_예제3() {
        //given
        List<Integer> cards = Arrays.asList(1,1,1,2,2,2,3);
        int gameMasterPickNumber = 5;

        //when
        String result = numberSumGame.pick(cards, gameMasterPickNumber);

        //then
        assertThat(result, is("1 1 3\n1 2 2"));
    }

    @Test(expected = NumberSumGame.NumberSumGameException.class)
    public void 최소숫자들의_합이_술래숫자보다_크면_바로실패한다() {
        //given
        List<Integer> cards = Arrays.asList(2,3,4,5,6);
        int gameMasterPickNumber = 3;

        //when
        numberSumGame.validateMinSum(cards, gameMasterPickNumber);
    }

    @Test(expected = NumberSumGame.NumberSumGameException.class)
    public void 최대숫자들의_합이_술래숫자보다_작면_바로실패한다() {
        //given
        List<Integer> cards = Arrays.asList(2,3,4,5,6);
        int gameMasterPickNumber = 100;

        //when
        numberSumGame.validateMaxSum(cards, gameMasterPickNumber);
    }

    @Test
    public void 중복된_문자열은_하나로_합쳐서_출력된다() {
        //given
        List<List<Integer>> cards = Arrays.asList(
                Arrays.asList(1,1,1),
                Arrays.asList(1,1,1),
                Arrays.asList(1,1,1));

        //when
        String message = numberSumGame.answersToString(cards);

        //then
        assertThat(message, is("1 1 1"));
    }

    @Test
    public void List의_순서가_보장된다() {
        //given
        List<List<Integer>> cards = Arrays.asList(
                Arrays.asList(1,2,7),
                Arrays.asList(1,3,6),
                Arrays.asList(1,4,5));

        //when
        String message = numberSumGame.answersToString(cards);

        //then
        assertThat(message, is("1 2 7\n1 3 6\n1 4 5"));
    }
}

