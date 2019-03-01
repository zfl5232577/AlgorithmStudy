package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/30
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public class OptimizationInsertionSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        for (int i = l+1; i <= r; i++) {
            int tmp = ary[i];
            int j;
            for (j = i; j > l && ary[j - 1] > tmp; j--) {
                ary[j] = ary[j - 1];
            }
            ary[j] = tmp;
        }
    }
}
