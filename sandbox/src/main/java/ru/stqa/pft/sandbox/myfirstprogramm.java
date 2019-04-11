package ru.stqa.pft.sandbox;

public class myfirstprogramm {

	public static void main(String[] args){
      hello("world");
        hello("user");
        hello("cats");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r =new Rectangle(4,6);
        System.out.println(" Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " +r.area());


        Point p = new Point(40,20,30,5);
        System.out.println("Расстояние между двумя точками = " + p.area ());


}


    public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");}




    }


