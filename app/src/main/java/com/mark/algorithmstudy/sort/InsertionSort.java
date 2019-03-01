package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/27
 *     desc   : 插入排序（10W个数据）相对选择排序而言优势，可提前break循环
 *     version: 1.0
 * </pre>
 */
public class InsertionSort implements ISort {
    @TimeLog
    @Override
    public void sort(int[] ary,int l,int r) {
        normalSort(ary,l,r);
    }

    /**
     * 常规的插入排序时间  15636ms 15611ms 15603ms
     *
     * @param ary
     */
    private void normalSort(int[] ary,int l,int r) {
        for (int i = l+1; i <= r; i++) {
            for (int j = i; j > 0 && ary[j] < ary[j - 1]; j--) {
                int tmp = ary[j];
                ary[j] = ary[j - 1];
                ary[j - 1] = tmp;
            }
        }
    }

    /**
     * 优化后的插入排序时间  10738ms 10750ms 10802ms 10729ms，最终的写法9749ms
     * 数据已经近乎排序完毕插入排序更优有优势
     * @param ary
     */
    public void optimizationSort(int[] ary,int l,int r) {
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
