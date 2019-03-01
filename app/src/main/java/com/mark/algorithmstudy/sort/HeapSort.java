package com.mark.algorithmstudy.sort;

import com.mark.algorithmstudy.heap.MaxHeap;
import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/30
 *     desc   : 堆排序100W个数为优化之前 718ms
 *     version: 1.0
 * </pre>
 */
public class HeapSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        int size = r-l+1;
        MaxHeap maxHeap = new MaxHeap(size);
        for (int i =0;i<size;i++){
            maxHeap.push(ary[i]);
        }
        for (int i =size-1;i>=0;i--){
            ary[i] = maxHeap.pull();
        }
    }

    public void optimizationSort(int[] ary, int l, int r) {
        int size = r-l+1;
        MaxHeap maxHeap = new MaxHeap(ary);
        for (int i =size-1;i>=0;i--){
            ary[i] = maxHeap.pull();
        }
    }
}
