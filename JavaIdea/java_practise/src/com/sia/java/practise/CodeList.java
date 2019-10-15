package com.sia.java.practise;

public class CodeList <T> {

    private Object[] objs = new Object[5];
    private int index = 0;

    public CodeList (){}

    public void add(T g) {
        if ( objs.length==index ) this.grow();
        objs[index++] = g;
    }

    public void grow(){
        Object[] temp = new Object[objs.length+objs.length];

        for ( int i=0; i<objs.length; i++ ) temp[i] = objs[i];
        objs = temp;
    }

    public void remove(int i) {
        for ( int j=i; j<this.index-1; j++ )
            objs[j] = objs[j+1];
        index--;
    }

    public void remove(T g) {
        for ( int i=0; i<this.index; i++ ) {
            if ( g.equals(objs[i]) ){
                remove(i);
                break;
            }
        }
    }

    public void remove(T g,int m) {
        int count = 1;
        for ( int i=0; i<this.index; i++ ) {
            if ( g.equals(objs[i]) && count<=m ){
                remove(i);
                count++;
            }
        }
    }

    public T get ( int i ) {
        return (T)objs[i];
    }

    public int size () {
        return index;
    }
}
