package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/30
 *     desc   : 原堆排序，空间复杂度100W个数为
 *     version: 1.0
 * </pre>
 */
public class OptimizationHeapSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        int size = r-l+1;

        for (int i = size/2-1;i>=l;i--){
            shiftDown(ary,i,ary[i],size);
        }
        for (int i = r;i>l;i--){
            SortHelper.swap(ary,i,l);
            shiftDown(ary,l,ary[l],i-l);
        }
    }

    private void shiftDown(int[] ary,int k,int item,int size) {
        while (2 * k+1 < size) {
            int j = 2 * k +1;
            if (j + 1 < size && ary[j] < ary[j + 1]) {
                j += 1;
            }
            if (item >= ary[j]) {
                break;
            }
            ary[k] = ary[j];
            k = j;
        }
        ary[k] = item;
    }
}
