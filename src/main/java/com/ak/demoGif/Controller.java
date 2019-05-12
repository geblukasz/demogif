package com.ak.demoGif;

public class Controller {

    private int id ;

    public static void main(String[] args) {

        int i = 15;
        String a = "AB".concat("ABAB");

        if (i > 15){
            a.concat("CD");
        } else {
            a.concat("EF");
        }

        System.out.println(a);

        int counter = 15;
        int b = 0;

        if (counter > 15){
            b++;
        } else {
            b--;
        }

        System.out.println(b);
    }
    
}
