package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class myfirstprogrammTest {

    @Test

    public void testDistance () {
        Point p1 = new Point(20,50);
        Point p2 = new Point(55,10);
        Assert.assertEquals(p1.distance(p1),p2.distance(p2), 53.150729063673246);
    }

}

