package ru.qa.java.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
//        hello("world");
//        hello("Pep");
//        hello("Arsen");
//
//        Square s = new Square(8);
//        System.out.println("Площадь квадрата со стороной " + s.k + " = " + s.area());
//
//        Rectangle r = new Rectangle(2,5);
//        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(6, 10);
        Point p2 = new Point(3, -5);
        System.out.println("Расстояние между двумя точками " + "(" + p1.x + ";" + p1.y + ")" + " и " +
                                                                "(" + p2.x + ";" + p2.y + ")" + " = " + p1.distance(p2));
        Point p3 = new Point(4,5);
        Point p4 = new Point(8,10);
        System.out.println("Расстояние между двумя точками " + "(" + p3.x + ";" + p3.y + ")" + " и " +
                                                                "(" + p4.x + ";" + p4.y + ")" + " = " + p3.distance(p4));
        Point p5 = new Point(0,-4);
        Point p6 = new Point(4,9);
        System.out.println("Расстояние между двумя точками " + "(" + p5.x + ";" + p5.y + ")" + " и " +
                                                                "(" + p6.x + ";" + p6.y + ")" + " = " + p5.distance(p6));
    }
//    public static void hello(String somebody) {
//        System.out.println("Hello " + somebody + " !");
//    }
}