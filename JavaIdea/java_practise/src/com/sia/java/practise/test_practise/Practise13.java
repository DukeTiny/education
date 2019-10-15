package com.sia.java.practise.test_practise;


import java.util.Arrays;

public class Practise13<T>{
        private int size;
        private Object[] obj = new Object[10];

        public void add ( Object o ){
            if ( size>=obj.length ) this.extend();
            obj[ size++ ] = o;
        }

        public void add ( int off, Object o ) {
            if ( off>=obj.length ) this.extend();
            obj[off] = o;
            size++;
        }

        public boolean contains( String name ) {
            for ( int i=0; i<size; i++ )
                if ( obj[i].equals(name) )
                    return true;
            return false;
        }

        public boolean remove( String name ) {
            int tempIndex = -1;
            for ( int i=0; i<size; i++ ) {
                if ( obj[i].equals(name) ) {
                    tempIndex = i;
                    break;
                }
            }
            if ( tempIndex!=-1 ) {
                remove( tempIndex );
                return true;
            }
            return false;
        }

        public void remove( int index ) {
            Object[] tempObj = new Object[obj.length];
            for ( int i=0; i<size; i++ ) {
                if ( i<index ) tempObj[i] = obj[i];
                if ( i>index ) tempObj[i-1] = obj[i];
            }
            obj = tempObj;
        }


        private void extend() {
            Object[] tempObject;
            tempObject = Arrays.copyOf(obj,obj.length<<1 );
            obj = tempObject;
        }



}