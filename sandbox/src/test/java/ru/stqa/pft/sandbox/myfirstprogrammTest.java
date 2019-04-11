package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class myfirstprogrammTest {

    @Test

    public void testDistance () {
        Point p = new Point(40,20,30,5);
        Assert.assertEquals(p.distance(), 1025.0);
    }

}

