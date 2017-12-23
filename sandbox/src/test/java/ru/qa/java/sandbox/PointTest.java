package ru.qa.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistanceP1P2() {
    Point p1 = new Point(6,10);
    Point p2 = new Point(3,-5);
    Assert.assertEquals(p1.distance(p2), 15.297058540778355) ;
  }

  @Test
  public void testDistanceP3P4() {
    Point p3 = new Point(4,5);
    Point p4 = new Point(8,10);
    Assert.assertEquals(p3.distance(p4), 6.403124237432848) ; //Failures
  }

  @Test
  public void testDistanceP5P6() {
    Point p5 = new Point(0,-4);
    Point p6 = new Point(4,9);
    Assert.assertEquals(p5.distance(p6), 13.601470508735444) ;
  }
}
