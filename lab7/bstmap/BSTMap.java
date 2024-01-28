package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private TreeNode root;
    private int size = 0;


    private class TreeNode {
        K key;
        V value;
        int size;
        TreeNode left;
        TreeNode right;

        /** Create a TreeNode with no children. */
        TreeNode(K k, V v) {
            key = k;
            value = v;
            size = 1;
            left = null;
            right = null;
        }

        void addLeft(TreeNode L) {
            this.size += L.size;
            this.left = L;
        }

        void addRight(TreeNode R) {
            this.size += R.size;
            this.right = R;
        }
    }
    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    public void printInOrder() {

    }
}