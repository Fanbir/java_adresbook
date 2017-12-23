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

        Point p1 = new Point();
        p1.x1 = 6;
        p1.y1 = 10;

        Point p2 = new Point();
        p2.x2 = 3;
        p2.y2 = -5;
        System.out.println("Расстояние между двумя точками " + "(" + p1.x1 + ";" + p1.y1 + ")" + " и " +
                                                                "(" + p2.x2 + ";" + p2.y2 + ")" + " = " + distance(p1, p2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt( Math.pow(p2.x2 - p1.x1,2) + Math.pow(p2.y2 - p1.y1,2) );
    }

//    public static void hello(String somebody) {
//        System.out.println("Hello " + somebody + " !");
//    }
}