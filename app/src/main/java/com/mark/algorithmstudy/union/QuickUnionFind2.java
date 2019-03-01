package com.mark.algorithmstudy.union;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/04
 *     desc   : 202ms
 *     version: 1.0
 * </pre>
 */
public class QuickUnionFind2 {

    private int[] parent;
    private int size;

    public QuickUnionFind2(int size) {
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private Node find(int id) {
        if (id < 0 || id >= size) {
            return new Node(-1, 0);
        }
        int h = 1;
        while (parent[id] != id) {
            id = parent[id];
            h++;
        }
        return new Node(id, h);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        Node pNode = find(p);
        Node qNode = find(q);
        if (pNode.parent != qNode.parent) {
            if (pNode.h < qNode.h) {
                parent[pNode.parent] = qNode.parent;
            }else {
                parent[qNode.parent] = pNode.parent;
            }
        }
    }

    public static class Node {
        int parent;
        int h;

        public Node(int parent, int h) {
            this.parent = parent;
            this.h = h;
        }
    }
}
