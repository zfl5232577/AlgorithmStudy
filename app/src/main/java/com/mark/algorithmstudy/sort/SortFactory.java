package com.mark.algorithmstudy.sort;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/27
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public class SortFactory {

    private static ISort mDefaultSort = new QuickSort();

    public static ISort creat(Class<? extends ISort> clazz){
        if (clazz.equals(SelectionSort.class)){
            return new SelectionSort();
        }else if (clazz.equals(BubbleSort.class)){
            return new BubbleSort();
        }else if (clazz.equals(InsertionSort.class)){
            return new InsertionSort();
        }else if (clazz.equals(OptimizationInsertionSort.class)){
            return new OptimizationInsertionSort();
        }else if (clazz.equals(MergeSort.class)) {
            return new MergeSort();
        }else if (clazz.equals(QuickSort.class)){
            return new QuickSort();
        }else if (clazz.equals(ThreeWayQuickSort.class)){
            return new ThreeWayQuickSort();
        }else if (clazz.equals(HeapSort.class)){
            return new HeapSort();
        }else if (clazz.equals(OptimizationHeapSort.class)){
            return new OptimizationHeapSort();
        }else {
            return mDefaultSort;
        }
    }
}
