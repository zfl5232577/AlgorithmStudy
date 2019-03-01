package com.mark.algorithmstudy.tree;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import io.reactivex.annotations.NonNull;

/**
 * <pre>
 *     author : Mark
 *     e-mail : makun.cai@aorise.org
 *     time   : 2018/09/03
 *     desc   : 二分查找树是一个二叉树，定义：节点的值大于左孩子的值同时小于右孩子的值
 *              二分查找树不一定是一颗完全二叉树
 *     version: 1.0
 * </pre>
 */
public class BinarySearchTree<V> {

    private Node<V> root;
    private int count;


    public void insert(int key, V value) {
        root = recursionInsert(root, key, value);
    }

    /**
     * 递归写法
     *
     * @param root
     * @param key
     * @param value
     * @return
     */
    private Node<V> recursionInsert(Node<V> root, int key, V value) {
        if (root == null) {
            count++;
            return new Node<>(key, value);
        }
        if (key > root.key) {
            root.right = recursionInsert(root.right, key, value);
        } else if (key < root.key) {
            root.left = recursionInsert(root.left, key, value);
        } else {
            root.value = value;
        }
        return root;
    }


    /**
     * 非递归写法
     *
     * @param root
     * @param key
     * @param value
     * @return
     */
    private void insert(@NonNull Node<V> root, int key, V value) {
        while (root != null) {
            if (key > root.key) {
                if (root.right == null) {
                    root.right = new Node<>(key, value);
                    count++;
                    break;
                } else {
                    root = root.right;
                }
            } else if (key < root.key) {
                if (root.left == null) {
                    root.left = new Node<>(key, value);
                    count++;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                root.value = value;
                break;
            }
        }
    }

    public V seach(int key) {
        return seach(root, key);
    }

    private V seach(Node<V> root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.key) {
            return seach(root.right, key);
        } else if (key < root.key) {
            return seach(root.left, key);
        } else {
            return root.value;
        }
    }

    public boolean contain(int key) {
        return contain(root, key);
    }

    private boolean contain(Node<V> root, int key) {
        if (root == null) {
            return false;
        }
        if (key > root.key) {
            return contain(root.right, key);
        } else if (key < root.key) {
            return contain(root.left, key);
        } else {
            return true;
        }
    }

    public void levelOrder() {
        Queue<Node<V>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<V> node = queue.poll();
            Log.e("mark", "levelOrder: " + node.key);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", count=" + count +
                '}';
    }

    public static class Node<V> {
        int key;
        V value;
        Node<V> left;
        Node<V> right;

        public Node(int key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
