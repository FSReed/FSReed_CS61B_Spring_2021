public class SLList {

    /** Make IntNode a Nested class in SLList, and make it private. */
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /** Make the first of SLList private */
    // private IntNode first;
    private IntNode sentinel;
    private int size;

    /** Empty list instructor. */
    public SLList() {
        // first = null;
        sentinel = new IntNode(61, null);
        size = 0;
    }

    public SLList(int x) {
        // first = new IntNode(x, null);
        sentinel = new IntNode(61, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        // first = new IntNode(x, first);
        IntNode tmp = new IntNode(x, null);
        tmp.next = sentinel.next;
        sentinel.next = tmp;
        size += 1;
    }

    public int getFirst() {
        // return first.item;
        return sentinel.next.item;
    }

    /**
     * The SLList is not a recursive structure.
     * To get the size of one SLList, we need a private helper function.
     * This is a very common method: Add a private static method.
     */

    /**
     * private static int size(IntNode p) {
     * if (p.next == null) {
     * return 1;
     * } else {
     * return 1 + size(p.next);
     * }
     * }
     */

    public int size() {
        /* return size(first); */
        return size; /* This time we use caching to speed up the size() method in SLList. */
    }

    /**
     * Need to update this method after adding empty list into SLList class.
     * Using {if (first == null)} works, but it's a little bit ugly.(Yep)
     * Notice the changes with SENTINEL.
     */
    public void addLast(int x) {
        // IntNode p = first;
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);

        size += 1;
    }
    // Now we don't need to worry about nulls when doing addLast.

    public static void main(String[] args) {
        SLList L = new SLList(552);
        L.addFirst(342);
        L.addLast(23);
        int output = L.getFirst();

        System.out.println(output);
        System.out.println(L.size());
    }
}
