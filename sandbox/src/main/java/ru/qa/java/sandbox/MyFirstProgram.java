package ru.qa.java.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("Pep");
        hello("Arsen");

        double k = 6;
        System.out.println("Площадь квадрата со стороной " + k + " = " + area(k));

        double p1 = 11;
        double p2 = 14;
        System.out.println("Площадь прямоугольника со сторонами " + p1 + " и " + p2 + " = " + area(p1, p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello " + somebody + " !");
    }

    public static double area(double a){
        return a * a;
    }

    public static double area(double a, double b){
        return a * b;
    }
}