package com.mark.algorithmstudy.union;

import com.mark.aoplibrary.annotation.TimeLog;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public class UnionFindHelper {

    @TimeLog
    public static void test1(int n){
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            unionFind.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            unionFind.isConnected(a,b);
        }
    }

    @TimeLog
    public static void test2(int n){
        QuickUnionFind quickUnionFind = new QuickUnionFind(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind.isConnected(a,b);
        }
    }

    @TimeLog
    public static void test3(int n){
        QuickUnionFind2 quickUnionFind2 = new QuickUnionFind2(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind2.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind2.isConnected(a,b);
        }
    }


    @TimeLog
    public static void test4(int n){
        QuickUnionFind3 quickUnionFind3 = new QuickUnionFind3(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind3.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind3.isConnected(a,b);
        }
    }

    @TimeLog
    public static void test5(int n){
        QuickUnionFind4 quickUnionFind4 = new QuickUnionFind4(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind4.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind4.isConnected(a,b);
        }
    }

    @TimeLog
    public static void test6(int n){
        QuickUnionFind5 quickUnionFind5 = new QuickUnionFind5(n);
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind5.union(a,b);
        }
        for (int i = 0;i<n;i++){
            int a = (int) (Math.random()*n);
            int b = (int) (Math.random()*n);
            quickUnionFind5.isConnected(a,b);
        }
    }
}
