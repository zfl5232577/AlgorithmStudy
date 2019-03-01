package com.mark.algorithmstudy.union;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : 24903ms
 *     version: 1.0
 * </pre>
 */
public class QuickUnionFind {

    private int[] parent;
    private int size;

    public QuickUnionFind(int size) {
        this.size = size;
        parent = new int[size];
        for (int i =0; i<size;i++){
            parent[i] = i;
        }
    }

    private int find(int id){
        if (id<0 || id>=size){
            return -1;
        }
        while (parent[id] != id){
            id = parent[id];
        }
        return id;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent != qParent) {
            parent[pParent] = qParent;
        }
    }

}
