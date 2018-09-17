package com.woowahan.study.java.work2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class MemoSortTest {
    @Test
    public void 테스트1() {
        //given
        List<String> memos = Arrays.asList(
                "18/7/3 배민은행의 구조도를 손에 넣었다. 필요한 장비는 이런거 저런거 해서 각자 준비해야한다.",
                "타깃 은행은 잠실에 있는 배민은행으로 한다. 18년06월13일",
                "배민은행앞 별다방에서 18-06-12에 만나기로 함");
        MemoSort memoSort = new MemoSort();

        //when
        List<String> result = memoSort.sortMemo(memos);

        //then
        result.get(0).equals(memos.get(2));
        result.get(1).equals(memos.get(1));
        result.get(2).equals(memos.get(0));
    }
}
