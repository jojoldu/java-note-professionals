package com.woowahan.study.java.work1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jojoldu@gmail.com on 20/08/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class NumberSumGame {
    public static class NumberSumGameException extends RuntimeException {}
    private static final String FAIL_MESSAGE = "NO";
    private static final int MIN_SIZE = 3;

    /**
     * 표준 입력으로 받은 문자열을 파싱해서 전달했다고 가정
     */
    public String pick (List<Integer> cards, int gameMasterPickNumber){
        try{
            validateCardSize(cards);

            cards.sort(Integer::compareTo);

            validateMinSum(cards, gameMasterPickNumber);
            validateMaxSum(cards, gameMasterPickNumber);

            List<List<Integer>> answers = searchAnswers(cards, gameMasterPickNumber);

            validateAnswers(answers);

            return answersToString(answers);

        } catch (NumberSumGameException nsge){
            return FAIL_MESSAGE;
        }
    }

    void validateCardSize(List<Integer> cards) {
        if(cards.size() < MIN_SIZE){
            throw new NumberSumGameException();
        }
    }

    void validateMinSum(List<Integer> cards, Integer gameMasterPickNumber) {
        if(cards.get(0) + cards.get(1) + cards.get(2) > gameMasterPickNumber) {
            throw new NumberSumGameException();
        }
    }

    void validateMaxSum(List<Integer> cards, Integer gameMasterPickNumber) {
        int size = cards.size();
        if(cards.get(size-3) + cards.get(size-2) + cards.get(size-1) < gameMasterPickNumber) {
            throw new NumberSumGameException();
        }
    }

    List<List<Integer>> searchAnswers(List<Integer> cards, Integer gameMasterPickNumber) {
        List<List<Integer>> answers = new ArrayList<>();
        int size = cards.size();

        for (int one = 0; one < size-2; one++) {
            for (int two = one+1; two < size-1; two++) {
                for (int three = two+1; three < size; three++) {
                    addAnswer(gameMasterPickNumber, answers, cards.get(one), cards.get(two), cards.get(three));
                }
            }
        }

        return answers;
    }

    void addAnswer(Integer gameMasterPickNumber, List<List<Integer>> answers, Integer oneCard, Integer twoCard, Integer threeCard) {
        int sum = oneCard + twoCard + threeCard;
        if(sum == gameMasterPickNumber){
            answers.add(Arrays.asList(oneCard, twoCard, threeCard));
        }
    }

    void validateAnswers (List<List<Integer>> answers) {
        if(answers.isEmpty()) {
            throw new NumberSumGameException();
        }
    }

    String answersToString(List<List<Integer>> answers){
        List<String> lines = answers.stream()
                .map(this::createLine)
                .collect(Collectors.toList());

        return String.join("\n", new LinkedHashSet<>(lines));
    }

    String createLine(List<Integer> answer) {
        return answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining( " " ));
    }
}
