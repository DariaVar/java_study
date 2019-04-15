package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class myfirstprogrammTest {

    @Test

    public void testDistance () {
        Point p = new Point(55,10);
        Assert.assertEquals(p.distance(), 63.63961030678928);
    }

}

