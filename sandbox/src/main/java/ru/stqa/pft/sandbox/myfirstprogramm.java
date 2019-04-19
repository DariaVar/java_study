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

        Point p1 = new Point(20,50);
        Point p2 = new Point(55,10);
        System.out.println("Расстояние между двумя точками = " + distance(p1, p2));


}

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");}




    }


