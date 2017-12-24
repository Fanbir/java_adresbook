package ru.qa.java.sandbox;

public class Vector {

  public double x;
  public double y;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public String parallelismVectors(Vector v) {
    if ((this.x / v.x) == (this.y / v.y)) {
      return "да";
    } else {
      return "нет";
    }
  }
}