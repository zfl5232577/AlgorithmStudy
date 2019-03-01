package com.mark.algorithmstudy.graphtheory;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/05
 *     desc   : 稀疏图
 *     version: 1.0
 * </pre>
 */
public class SparseGraph implements IGraph {
    private int n, m;
    private boolean directed;
    private List<Integer>[] g;


    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
    }

    @Override
    public int getVertexCount() {
        return n;
    }

    @Override
    public int getEdgeCount() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IndexOutOfBoundsException();
        }
        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IndexOutOfBoundsException();
        }
        int size = g[v].size();
        for (int i = 0; i < size; i++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }
        return false;
    }

    // 返回节点v 的所有邻接节点
    public Iterable<Integer> adjacentNode(int v){
        return g[v];
    }
}
