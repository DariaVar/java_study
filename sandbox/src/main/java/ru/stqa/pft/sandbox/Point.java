package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;
    public double x1;
    public double y1;

    public Point(double x, double x1, double y, double y1){
        this.x =x;
        this.x1 =x1;
        this.y =y;
        this.y1 = y1;
    }


    public  double distance () {
        return  ((this.x - this.x1) * (this.x - this.x1) + (this.y - this.y1) * (this.y - this.y1));

    }
}
