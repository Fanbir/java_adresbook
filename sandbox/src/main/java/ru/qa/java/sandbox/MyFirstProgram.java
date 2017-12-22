package ru.qa.java.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("Pep");
        hello("Arsen");

        Square s = new Square(8);
        System.out.println("Площадь квадрата со стороной " + s.k + " = " + s.area());

        Rectangle r = new Rectangle(2,5);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }

    public static void hello(String somebody) {
        System.out.println("Hello " + somebody + " !");
    }
}