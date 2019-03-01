package com.mark.algorithmstudy.graphtheory;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/05
 *     desc   : TODO
 *     version: 1.0
 * </pre>
 */
public interface IGraph {
    int getVertexCount();

    int getEdgeCount();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);
}
