package com.mark.algorithmstudy.sort;

import android.util.Log;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/08/27
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public class SortHelper {

    private static final String TAG = SortHelper.class.getSimpleName();

    public static void swap(int[] ary, int x, int y) {
        int tmp = ary[x];
        ary[x] = ary[y];
        ary[y] = tmp;
    }

    public static int[] genereteRandomArray(int length, int rangeL, int rangeR) {
        if (rangeL >= rangeR) {
            throw new IllegalStateException("rangeL must < rangeR, now rangeL >= rangeR");
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * (rangeR - rangeL)) + rangeL;
        }
        return result;
    }

    public static int[] genereteNearlyOrderedArray(int length, int swapTimes) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int posx = (int) (Math.random() * length);
            int posy = (int) (Math.random() * length);
            int tmp = result[posx];
            result[posx] = result[posy];
            result[posy] = tmp;
        }
        return result;
    }

    public static void println(int[] ary) {
        for (int i = 0, size = ary.length; i < size; i++) {
            Log.e(TAG, ary[i] + "");
        }
    }

    public static boolean isSorted(int[] ary) {
        for (int i = 1, size = ary.length; i < size; i++) {
            if (ary[i] < ary[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
