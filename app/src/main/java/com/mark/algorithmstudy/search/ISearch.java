package com.mark.algorithmstudy.search;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/03
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public interface ISearch {

    /**
     * 区间是[l,r]（前闭后闭）排好序的数组中查找目标值target,未找到返回-1
     * @param ary
     * @param l
     * @param r
     * @param target
     * @return
     */
    int search(int[] ary,int l,int r, int target);
}
