package com.mark.algorithmstudy.sort;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/29
 *     desc   : 快速排序没有优化，100W个普通数据 200ms，缺点是重复数据多的时候，时间复杂度会接近On2；
 *     version: 1.0
 * </pre>
 */
public class ThreeWayQuickSort implements ISort {

    @TimeLog
    @Override
    public void sort(int[] ary, int l, int r) {
        quickSort3Ways(ary,l,r);
    }


    /**
     *
     * 240ms
     * @param ary
     * @param l
     * @param r
     */
    private void quickSort(int[] ary, int l, int r){
        if (r-l<=15){
            new InsertionSort().optimizationSort(ary, l, r);
            return;
        }
        int random = (int) (Math.random()*(r-l+1)+l);
        SortHelper.swap(ary,l,random);
        int j=l;
        for (int i =l+1;i<=r;i++){
            if (ary[i]<ary[l]){
                SortHelper.swap(ary,++j,i);
            }
        }
        SortHelper.swap(ary,l,j);
        quickSort(ary,l,j-1);
        quickSort(ary,j+1,r);
    }


    private void quickSort3Ways(int[] ary, int l, int r){
        if (r-l<=15){
            new InsertionSort().optimizationSort(ary, l, r);
            return;
        }
        int random = (int) (Math.random()*(r-l+1)+l);
        SortHelper.swap(ary,l,random);
        int i=l,j=r+1;
        for (int k =l+1;k<j;k++){
            if (ary[k]<ary[l]){
                SortHelper.swap(ary,++i,k);
            }else if (ary[k]>ary[l]){
                SortHelper.swap(ary,--j,k);
                k--;
            }
        }
        SortHelper.swap(ary,l,i);
        quickSort3Ways(ary,l,i-1);
        quickSort3Ways(ary,j,r);
    }
}
