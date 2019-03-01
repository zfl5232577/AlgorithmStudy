package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/28
 *     desc   : 归并排序（10W个数据）排序时间
 *     version: 1.0
 * </pre>
 */
public class MergeSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        mergeSort(ary, l, r);
    }

    private void mergeSort(int[] ary, int l, int r) {
//        if (l >= r) { //可优化成下面的结束排序。数量较少时使用插入排序,优化后的100W数据 365ms  365ms
//            return;
//        }
        if (r - l <= 15) {
            new InsertionSort().optimizationSort(ary, l, r);
            return;
        }
        int mid = (int) (((long) l + (long) r) / 2);
        mergeSort(ary, l, mid);
        mergeSort(ary, mid + 1, r);
        if (ary[mid] > ary[mid + 1]) {//这个if是对近乎有序的数据进行优化
            merge(ary, l, mid, r);
        }
    }

    private void merge(int[] ary, int l, int mid, int r) {
        int[] temAry = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            temAry[i - l] = ary[i];
        }
        int i = 0, j = mid + 1 - l;
        for (int k = l; k <= r; k++) {
            if (i > mid - l) {
                ary[k] = temAry[j];
                j++;
            } else if (j > r - l) {
                ary[k] = temAry[i];
                i++;
            } else if (temAry[i] < temAry[j]) {
                ary[k] = temAry[i];
                i++;
            } else {
                ary[k] = temAry[j];
                j++;
            }
        }
    }
}
