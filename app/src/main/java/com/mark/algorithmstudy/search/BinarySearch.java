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
public class BinarySearch implements ISearch{


    @Override
    public int search(int[] ary, int l,int r,int target) {
        if (l>r){
            return -1;
        }
        int mid = l+ (r-l)/2;
        if (ary[mid]==target){
            return mid;
        }else if (ary[mid]>target){
            return search(ary,l,mid-1,target);
        }else {
            return search(ary,mid+1,r,target);
        }
    }

}
