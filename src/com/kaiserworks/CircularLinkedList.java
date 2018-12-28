package com.kaiserworks;

public class CircularLinkedList<E> {

    private Node current;
    private int size = 0;
    private int index = 0;



    public int size() {

        return size;
    }

    public boolean hasNext() {

        return !( current.getNext() == null );
    }

    public void next() {

        current = current.getNext();
    }

    public boolean hasPrevious() {

        return !( current.getPrevious() == null );
    }

    public void previous() {

        current = current.getPrevious();
    }

    public E get() {

        return current.getElement();
    }

    public void clear() {

        current = null;
        size = 0;
        index = 0;
    }

    public boolean contains( E e ) {

        int currentIndex = current.getIndex();
        System.out.println( "currentIndex = [" + currentIndex + "]" );

        do {

            if ( e.equals( current.getElement() ) ) {

                return true;
            }

            next();

            System.out.println( "current.getIndex = [" + current.getIndex() + "]" );

        } while ( currentIndex != current.getIndex() );

        return false;

    }

    /**
     * Add a new element to the list after the current element if one exists.  If the list is currently empty then the
     * new element will be placed in the list with the previous and next connections all pointing to it.
     *
     * @param e element to be added to the list
     */
    public void add( E e ) {

        // Create a brand new node
        Node node = new Node();
        node.setIndex( index );

        if ( current == null ) {

            System.out.println( "Current is null adding at the beginning" );

            // This one is easy. Setup the new node and then just add it as current
            node.setElement( e );
            node.setPrevious( node );
            node.setNext( node );
            current = node;

        } else {

            // Create a brand new node for this element
            node.setElement(e);

            // Set the new node so that the previous node is the current node and the next node is the current node's
            // next one.
            node.setPrevious( current );
            node.setNext( current.getNext() );

            // Move the new node in after the current node
            current.setNext( node );

            // Make it so the next node can get to the new node when going backwards
            node.getNext().setPrevious( node );

            // Move the list to the new node
            current = node;
        }

        // Since a node was added we advance the size and index
        size++;
        index++;

    }

    /**
     * Removes the current node
     */
    public void remove() {

        if ( current == null ) {

            return;
        }

        if ( size == 1 ) {

            current.setPrevious( null );
            current.setNext( null );
            current = null;

        } else {

            Node removal = current;

            current.getPrevious().setNext( current.getNext() );

            current.getNext().setPrevious( current.getPrevious() );

            current = current.getPrevious();

            removal.setPrevious( null );
            removal.setNext( null );
        }

        size--;

    }

    /**
     * Checks to see if there are any active characters.  Uses the current character node to determine if the list is
     * empty or not.
     *
     * @return true if current node is null; otherwise false.
     */
    public boolean isEmpty() {

        return ( size == 0 );
    }

    /**
     *
     */
    private class Node {

        private Node previous;
        private E e;
        private Node next;
        private int index = 0;

        void setIndex(int index) {

            this.index = index;
        }

        int getIndex() {

            return index;
        }

        Node getPrevious() {

            return previous;
        }

        void setPrevious(Node previous) {

            this.previous = previous;
        }

        E getElement() {

            return e;
        }

        void setElement(E e) {
            this.e = e;
        }

        Node getNext() {

            return next;
        }

        void setNext(Node next) {

            this.next = next;
        }

        public String toString() {

            return "Node{ element=" + getElement().toString()
                    + " previous=" + getPrevious().getElement().toString()
                    + " next=" + getNext().getElement().toString() + "}";
        }
    }
}
