package com.kaiserworks;

public class PoC {

    public static void main( String[] args ) {

        // Create a new CircularLinkedList
        CircularLinkedList<String> excuses = new CircularLinkedList<>();
        excuses.hasNext();
        excuses.add( "Broncos" );
        excuses.add( "Raiders" );
        excuses.add( "Chiefs" );
        excuses.add( "Chargers" );

        System.out.println( "excuses.size() = [" + excuses.size() + "]" );
        System.out.println( "excuses.get()  = [" + excuses.get() +  "]" );
        System.out.println( "excuses.contains( Broncos ) = [" + excuses.contains( "Broncos" ) + "]" );

        excuses.remove();
        System.out.println( "excuses.size() = [" + excuses.size() + "]" );
        System.out.println( "excuses.contains( Chargers ) = [" + excuses.contains( "Chargers" ) + "]" );

    }
}
