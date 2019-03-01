package com.mark.algorithmstudy.graphtheory;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : 稠密图
 *     version: 1.0
 * </pre>
 */
public class DenseGraph implements IGraph {
    private int n, m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new boolean[n][n];
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
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 || v >= n || w < 0 || w >= n) {
            throw new IndexOutOfBoundsException();
        }
        return g[v][w];
    }


    // 返回所有 节点 v 的 邻接节点
    public Iterable<Integer> adjacentNode(int v){
        // adjacentL 用于存储 v 的邻接节点
        List<Integer> adjacentL = new ArrayList<>();
        // 找到所有与 v 邻接的节点，将其加入 adjacentL 中
        for (int i = 0; i < n;i++){
            if (g[v][i])
                adjacentL.add(i);
        }
        return adjacentL;
    }
}
