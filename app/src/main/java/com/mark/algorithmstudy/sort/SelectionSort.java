package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/27
 *     desc   : 选择排序（10W个数据）排序时间  28608ms  28593ms 28598ms 28765ms
 *     version: 1.0
 * </pre>
 */
public class SelectionSort implements ISort {

    @TimeLog
    @Override
    public void sort(int[] ary,int l,int r) {
        for (int i = l; i <= r; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= r; j++) {
                if (ary[minIndex] > ary[j]) {
                    minIndex = j;
                }
            }
            int tmp = ary[i];
            ary[i] = ary[minIndex];
            ary[minIndex]=tmp;
        }
    }
}
