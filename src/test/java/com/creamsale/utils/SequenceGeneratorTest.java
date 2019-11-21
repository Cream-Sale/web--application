package com.creamsale.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class SequenceGeneratorTest {

    //negative tests for positive begin positive end

    @Test(expected = Exception.class)
    public void beginEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,10,5);
    }

    @Test(expected = Exception.class)
    public void beginEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,10,-5);
    }

    @Test(expected = Exception.class)
    public void beginEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,7,5);
    }

    @Test(expected = Exception.class)
    public void beginEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,7,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderBeginEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(10,5,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderBeginEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(10,5,5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderBeginEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(7,5,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderBeginEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(7,5,5);
    }

    /// negative tests for negative begin negative end

    @Test(expected = Exception.class)
    public void negBeginNegEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-10,5);
    }

    @Test(expected = Exception.class)
    public void negBeginNegEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-10,-5);
    }

    @Test(expected = Exception.class)
    public void negBeginNegEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-7,5);
    }

    @Test(expected = Exception.class)
    public void negBeginNegEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-7,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginNegEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-10,-5,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginNegEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-10,-5,5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginNegEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-7,-5,-5);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginNegEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-7,-5,5);
    }

    /// negative tests for negative begin positive end

    @Test(expected = Exception.class)
    public void negBeginPosEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,10,15);
    }

    @Test(expected = Exception.class)
    public void negBeginPosEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,10,-15);
    }

    @Test(expected = Exception.class)
    public void negBeginPosEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,7,15);
    }

    @Test(expected = Exception.class)
    public void negBeginPosEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,7,-15);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginPosEndDifferenceEqualsNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-10,5,-15);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginPosEndDifferenceEqualsStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-10,5,15);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginPosEndDifferenceLessThanNegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-7,5,-15);
    }

    @Test(expected = Exception.class)
    public void reverseOrderNegBeginPosEndDifferenceLessThanStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-7,5,15);
    }

    //wrong direction test

    @Test(expected = Exception.class)
    public void from5to10NegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,10,-1);
    }

    @Test(expected = Exception.class)
    public void from5toMinus10PosStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,-10,1);
    }

    @Test(expected = Exception.class)
    public void fromMinus5to10NegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,10,-1);
    }

    @Test(expected = Exception.class)
    public void fromMinus5toMinus10PosStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-10,1);
    }

    @Test(expected = Exception.class)
    public void fromMinus10toMinus5NegStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-10,-5,-1);
    }

    @Test(expected = Exception.class)
    public void from10to5PosStep() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(10,5,1);
    }

    //positive tests normal cases

    @Test
    public void from5to10step1() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,10,1);
        List<Integer> actual = generator.generate();
        int[] expected = {5,6,7,8,9,10};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5to10step1() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,10,1);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-4,-3,-2,-1,-0,1,2,3,4,5,6,7,8,9,10};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5toMinus10stepMinus1() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-10,-1);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-6,-7,-8,-9,-10};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }


    @Test
    public void from5toMinus10stepMinus1() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,-10,-1);
        List<Integer> actual = generator.generate();
        int[] expected = {5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    //cases with step != 1

    @Test
    public void from5to14step3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,14,3);
        List<Integer> actual = generator.generate();
        int[] expected = {5,8,11,14};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5to4step3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,4,3);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-2,1,4};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5toMinus11stepMinus3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-11,-3);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-8,-11};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void from5toMinus4stepMinus3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,-4,-3);
        List<Integer> actual = generator.generate();
        int[] expected = {5,2,-1,-4};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    //positive tests. cases with where (abs(end-begin)%step)!=0

    @Test
    public void from5to15step3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,15,3);
        List<Integer> actual = generator.generate();
        int[] expected = {5,8,11,14};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5to5step3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,5,3);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-2,1,4};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void fromMinus5toMinus15stepMinus3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(-5,-15,-3);
        List<Integer> actual = generator.generate();
        int[] expected = {-5,-8,-11,-14};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }

    @Test
    public void from5toMinus5stepMinus3() throws Exception {
        SequenceGenerator generator = new SequenceGenerator(5,-5,-3);
        List<Integer> actual = generator.generate();
        int[] expected = {5,2,-1,-4};
        Assert.assertArrayEquals(expected,actual.stream().mapToInt(i->i.intValue()).toArray());
    }


}