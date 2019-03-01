package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/31
 *     desc   : 冒泡排序
 *     version: 1.0
 * </pre>
 */
public class BubbleSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        for (int i = r; i > l; i--) {
            for (int j = l; j < i; j++) {
                if (ary[j] > ary[j + 1]){
                    SortHelper.swap(ary,j,j+1);
                }
            }
        }
    }
}
