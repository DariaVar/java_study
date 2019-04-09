package ru.stqa.pft.sandbox;

public class myfisttast {
    Point p1 , p2;
    myfisttast(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public  double distance() {
        return Math.sqrt(
                (p1.getP1() - p2.getP1()) *  (p1.getP1() - p2.getP1()) +
                        (p1.getP2() - p2.getP2()) *  (p1.getP2() - p2.getP2())
        );
    }
    static public void main (String args[]) {
        myfisttast s = new myfisttast (new Point(2.0, 2.0), new Point(5.0, 6.0));
        double as = s.distance();
        System.out.println ("Расстояние между двумя точками   = " + as);
    }
}



