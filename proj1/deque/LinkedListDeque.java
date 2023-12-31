package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class LinkedNode {
        private final T item;
        private LinkedNode prev;
        private LinkedNode next;

        LinkedNode(T i, LinkedNode p, LinkedNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private int size;
    private final LinkedNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new LinkedNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /* Create a node at the beginning of the Linked List with item being element.*/
    public void addFirst(T element) {
        LinkedNode newNode = new LinkedNode(element, sentinel, sentinel.next);
        sentinel.next.prev = newNode; // This step is a little bit tricky.
        sentinel.next = newNode;
        size += 1;
    }

    /*Create a node at the end of the Linked List with item being element.*/
    public void addLast(T element) {
        LinkedNode newNode = new LinkedNode(element, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /* Return the size of the List.*/
    public int size() {
        return size;
    }

    /* Print the whole List.*/
    public void printDeque() {
        LinkedNode current = sentinel.next;
        while (current != sentinel) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    /* Removes and returns the item at the front of the deque.*/
    public T removeFirst() {
        if (!isEmpty()) {
            size -= 1;
        } // Don't know how to avoid this special case.
        LinkedNode del = sentinel.next;
        sentinel.next = del.next;
        del.next.prev = sentinel;
        return del.item;
    }

    /* Removes and returns the item at the back of the deque.*/
    public T removeLast() {
        if (!isEmpty()) {
            size -= 1;
        } // Don't know how to avoid this special case.
        LinkedNode del = sentinel.prev;
        sentinel.prev = del.prev;
        del.prev.next = sentinel;

        return del.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *  If no such item exists, returns null.
     */
    public T get(int index) {
        int position = 0;
        LinkedNode current = sentinel.next;
        while (current != sentinel) {
            if (position == index) {
                return current.item;
            }
            current = current.next;
            position += 1;
        }
        return null;
    }

    /* Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        return recursiveHelper(sentinel.next, index, 0);
    }

    /* The helper function for getRecursive.*/
    private T recursiveHelper(LinkedNode starter, int index, int position) {
        if (starter == sentinel) {
            return null;
        } else {
            if (position == index) {
                return starter.item;
            } else {
                position += 1;
                return recursiveHelper(starter.next, index, position);
            }
        }
    }

    public Iterator<T> iterator() {
        LinkedListDeque<T> currentDeque = this;
        return new Iterator<>() {
            private int position;
            @Override
            public boolean hasNext() {
                return position < currentDeque.size();
            }

            @Override
            public T next() {
                T result = currentDeque.get(position);
                position += 1;
                return result;
            }
        };
    }

    public boolean equals(Object o) {
        if (o instanceof Deque) {
            if (((Deque) o).size() == this.size()) {
                for (int i = 0; i < this.size(); i += 1) {
                    if (!this.get(i).equals(((Deque) o).get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
