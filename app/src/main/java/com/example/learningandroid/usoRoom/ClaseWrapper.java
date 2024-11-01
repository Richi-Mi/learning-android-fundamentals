package com.example.learningandroid.usoRoom;

public class ClaseWrapper {
    public void exect() {
        Integer i = new Integer("12");
        Double d = Double.valueOf("2.7171");
        Long g = Long.valueOf("1100101", 2);
    }
    public int binToInt( String bite ) {
        return Integer.valueOf( bite, 2 );
    }
    public String intToBinary( int n ) {
        byte i = Integer.valueOf(n).byteValue();
        return Byte.toString( i );
    }
}
