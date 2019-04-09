package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class myfirsttastTest {

    @Test

    public void testDistance () {
        Point p = new Point(10, 5);
        Assert.assertEquals(p.distance(), 7.0710678118654755);
    }

}

