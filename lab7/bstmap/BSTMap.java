package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K, V> implements Map61B<K, V> {

    private class TreeNode {
        K key;
        V value;
        TreeNode left;
        TreeNode right;

        /** Create a TreeNode with no children. */
        TreeNode(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }
    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {

    }
}
