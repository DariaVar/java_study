package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test

    public void testPrimes() {
        Assert.assertTrue(Primes.isPrimFast(Integer.MAX_VALUE));
    }


    @Test (enabled =  false)

    public void testPrimesLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrim(n));
    }

    @Test

    public void testNonPrimes() {
        Assert.assertFalse(Primes.isPrim(Integer.MAX_VALUE - 2));
    }
}