package com.woowahan.study.java.work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 27/08/2018
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class Executor {
    public static void main(String[] args) throws Exception {
        BufferedReader br = createReader();
        print(new NumberSumGame().pick(readCardNumbers(br), readExpectCount(br)));
    }

    private static BufferedReader createReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static List<Integer> readCardNumbers(BufferedReader br) throws IOException {
        String[] nums = br.readLine().split(" ");

        List<Integer> cards = new ArrayList<>();
        for(int idx=0; idx < nums.length; idx++)
            cards.add(Integer.parseInt(nums[idx]));

        return cards;
    }

    private static int readExpectCount(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static void print(String result) {
        System.out.println(result);
    }
}
