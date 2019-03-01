package com.mark.algorithmstudy.union;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : Helper测试10W个数据 49605ms
 *     version: 1.0
 * </pre>
 */
public class UnionFind {

    private int[] ids;
    private int size;

    public UnionFind(int size) {
        this.ids = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    public int find(int p) {
        if (p < 0 || p >= size) {
            return -1;
        }
        return ids[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID != qID) {
            for (int i = 0; i < size; i++) {
                if (ids[i] == pID) {
                    ids[i] = qID;
                }
            }
        }

    }
}
