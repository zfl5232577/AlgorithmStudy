package com.mark.algorithmstudy.heap;

import java.util.Arrays;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/30
 *     desc   : 最大二叉堆
 *     version: 1.0
 * </pre>
 */
public class MaxHeap {
    private int[] data;
    private int count;

    public MaxHeap(int size) {
        this.data = new int[size + 1];
    }

    public MaxHeap(int[] ary){
        count = ary.length;
        data = new int[count+1];
        System.arraycopy(ary, 0, data, 1, ary.length);
        for (int i=count/2;i>0;i--){
            shiftDown(i,data[i]);
        }
    }

    public void push(int item) {
        if (count + 1 == data.length) {
            int[] temp = new int[data.length * 2];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        data[++count] = item;
        shiftUp(count,item);
    }

    private void shiftUp(int k,int item) {
        while (k > 1 && item > data[k / 2]) {
            data[k] = data[k/2];
            k /= 2;
        }
        data[k] = item;
    }

    public int pull() {
        int tmp = data[1];
        shiftDown(1,data[count]);
        data[count] = 0;
        count--;
        return tmp;
    }

    private void shiftDown(int k,int item) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j] < data[j + 1]) {
                j += 1;
            }
            if (item >= data[j]) {
                break;
            }
            data[k] = data[j];
            k = j;
        }
        data[k] = item;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + Arrays.toString(data) +
                ", count=" + count +
                '}';
    }
}
