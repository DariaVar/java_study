package ru.stqa.pft.sandbox;

public class myfisttast {

    public static void main(String[] args){
        hello("world");
        hello("user");
        hello("cats");
        

   Point p = new Point(10, 5);
        System.out.println ("Расстояние между двумя точками   = " + p. distance());

    }
    public static void hello(String somebody){
        System.out.println("Hello, " + somebody + "!");
    }
}



