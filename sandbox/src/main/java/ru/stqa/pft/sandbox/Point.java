package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;


    public Point(double x, double y ){
        this.x =x;
        this.y =y;
    }


    public  double distance() {
        return Math.sqrt(Math.pow(this.x - this.y, 2) + Math.pow(this.y - this.x, 2));

    }

}
