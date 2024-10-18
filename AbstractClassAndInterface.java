// From Java 8, interfaces can have default and static methods with concrete implementations.From Java 9, interfaces can also have private methods.
abstract class Shape {
    String objectName = " ";

    Shape(String name) {
        this.objectName = name;
    }

    public void moveTo(int x, int y) {
        System.out.println(this.objectName + " has been moved to x = " + x + " and y = " + y);
    }

    abstract public double area();

    abstract public void draw();
}

class Rectangle extends Shape {
    int length, width;

    Rectangle(int length, int width, String name) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle has been draw");
    }

    @Override
    public double area() {
        return (double) (length * width);
    }
}

class Circle extends Shape {
    double pi = 3.14;
    int radius;

    Circle(int radius, String name) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle has been drawn");
    }

    @Override
    public double area() {
        return (double) (pi * radius * radius);
    }
}

// -------------------------------------
interface Drawable {
    void draw();
}

interface Movable {
    void moveTo(int x, int y);
}

class Circle implements Drawable, Movable{
    double pi = 3.14;
    int radius;
    Circle(int radius){
        this.radius = radius;
    }
}


public class AbstractClassAndInterface {
    public static void main(String[] args) {
        Shape rect = new Rectangle(2, 3, "Rectangle");
        System.out.println("Area of rectangle : " + rect.area());
        rect.area();
        System.out.println();
        Shape circle = new Circle(2, "Circle");
        System.out.println("Area of circle : " + circle.area());
        circle.area();
        // -------------------------------------
    }
}
