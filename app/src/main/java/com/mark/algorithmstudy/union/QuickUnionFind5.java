package com.mark.algorithmstudy.union;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : 133ms
 *     version: 1.0
 * </pre>
 */
public class QuickUnionFind5 {

    private int[] parent;
    private int[] rank;
    private int size;

    public QuickUnionFind5(int size) {
        this.size = size;
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private int find(int id) {
        if (id < 0 || id >= size) {
            return -1;
        }
        //路径压缩
//        while (parent[id] != id){
//            parent[id] = parent[parent[id]];
//            id = parent[id];
//        }
//        return id;
        if (parent[id] != id) {
            parent[id] = find(parent[id]);
        }
        return parent[id];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (rank[pRoot] == rank[qRoot]) {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
        }
    }
}
