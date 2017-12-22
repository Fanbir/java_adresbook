package ru.qa.java.sandbox;

public class Square {

  public double k;

  public Square(double k) {
    this.k=k;
  }

  public double area(){
    return this.k * this.k;
  }
}
