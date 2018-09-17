package com.woowahan.study.java.work2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jojoldu@gmail.com on 2018. 9. 17.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

public class MemoSort {

    public List<String> sortMemo(List<String> memos) {
        List<Memo> memoList = memos.stream()
                .map(Memo::new)
                .sorted(Comparator.comparing(Memo::getDate))
                .collect(Collectors.toList());

        return memoList.stream()
                .map(Memo::getMemo)
                .collect(Collectors.toList());
    }
}
