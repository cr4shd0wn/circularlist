package com.kaiserworks;

public class CircularLinkedList<E> {

    private Node<E> current;
    private Node<E> head;
    private Node<E> tail;

    private int size = 0;
    private int index = 0;

    /**
     * Returns the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int size() {

        return size;
    }

    /**
     * Determines if there is another element in the list moving clockwise.  Because of the circular nature any list
     * that has at least one element should always have a next element.
     *
     * @return true if there is another element in the list, false otherwise
     */
    public boolean hasNext() {

        // Null pointer protection
        if ( current == null ) {

            return false;
        }

        return !( current.next == null );
    }

    /**
     * Moves the cursor for the list to the next element clockwise.
     */
    public void next() {

        current = current.next;
    }

    public E peek() {

        return (E) current.next.e;

    }

    /**
     * Determines if there is another element in the list moving counterclockwise.  Because of the circular nature any
     * list with at least one element should always have a previous element.
     *
     * @return boolean true if there is another element in the list; otherwise false
     */
    public boolean hasPrevious() {

        return !( current.previous == null );
    }

    /**
     * Moves the cursor for the list to the next element counterclockwise.
     */
    public void previous() {

        current = current.previous;
    }

    /**
     * Returns the element at the current cursor position but does not remove it from the list
     * @return
     */
    public E get() {

        return current.e;
    }

    public void clear() {

        current = null;
        size = 0;
        index = 0;
    }

    public boolean contains( E e ) {

        for( Node<E> cursor = head; cursor.index < tail.index; cursor = cursor.next ) {

            if( e.equals( cursor.e ) ) {

                return true;
            }
        }

        return e.equals( tail.e );

    }

    /**
     * Add a new element to the list after the current element if one exists.  If the list is currently empty then the
     * new element will be placed in the list with the previous and next connections all pointing to it.
     *
     * @param e element to be added to the list
     */
    public void add( E e ) {


        if ( current == null ) {

            // Create a brand new node
            Node node = new Node();

            // This one is easy. Setup the new node and then just add it as current
            node.e =  e ;
            node.previous =  node;
            node.next = node ;
            node.index = 0;
            current = node;
            head = node;
            tail = node;

        } else {

            // Create a brand new node
            Node node = new Node( head, e, tail );

            // Index of this node is 1 more than that of the current tail
            node.index = tail.index + 1;

            // Node will go after tail
            tail.next = node;

            // Node will go before head
            head.previous = node;

            // Node becomes the new tail
            tail = node;

            // Advance the cursor to the new node as well
            current = node;
        }

        // Since a node was added we advance the size
        size++;
    }

    /**
     *
     */
    private void fixIndices() {

        int index = 0;


        for ( Node<E> cursor = head; cursor != tail; cursor = cursor.next ) {
            
            cursor.index =  index++;
        }

        tail.index = index;
    }

    /**
     * Removes the current node
     */
    public void remove() {

        if ( current == null ) {

            return;
        }

        if ( size == 1 ) {

            current.previous = null;
            current.next = null;
            current = null;

        } else {

            current.previous.next = current.next;

            current.next.previous = current.previous;

            if ( current == head ) {

                head = current.previous;
            }

            if ( current == tail ) {

                tail = current.next;
            }

            current = current.previous;

        }

        size--;

        fixIndices();

    }

    /**
     * Checks to see if there are any elements in the list.
     *
     * @return true if the list is empty; otherwise false.
     */
    public boolean isEmpty() {

        return ( size == 0 );
    }

    /**
     *
     */
    private class Node<E> {

        private Node previous;
        private E e;
        private Node next;
        private int index = 0;

        Node() {

            this.previous = null;
            this.e = null;
            this.next = null;
        }

        Node( Node<E> previous, E e, Node<E> next ) {

            this.previous = previous;
            this.e = e;
            this.next = next;
        }

        public String toString() {

            return "Node{ index=" + index
                    + " element=" + e.toString()
                    + " previous=" + previous.e.toString()
                    + " next=" + next.e.toString() + "}";
        }
    }
}
