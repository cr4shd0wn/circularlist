package com.kaiserworks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    static CircularLinkedList<String> testObject = new CircularLinkedList<>();

    @BeforeAll
    static void setup() {

        testObject.add( "Hello" );
        testObject.add( "Goodbye" );
        testObject.add( "Welcome" );
        testObject.add( "Thank You" );
    }

    @Test
    void size() {

        assertTrue( testObject.size() == 4 );

    }

    @Test
    void hasNext() {

        assertTrue( testObject.hasNext() );
    }

    @Test
    void next() {

        String expectedResult = testObject.peek();
        testObject.next();
        String actualResult = testObject.get();

        assertEquals( expectedResult, actualResult );
    }

    @Test
    void hasPrevious() {
    }

    @Test
    void previous() {
    }

    @Test
    void get() {
    }

    @Test
    void clear() {
    }

    @Test
    void contains() {
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void isEmpty() {
    }
}