import java.util.*;

public class Rectangle extends Shape {

    public double length;
    public double width;

    public Rectangle(double length, double width, String color) {
        
        super(color);

        this.length = length;
        this.width = width;

    }

    @Override
    public double getArea() {
        return length * width;
    }

    public static void main(String[] args) {

        ArrayList<Shape> list = new ArrayList<>();

        list.add(new Rectangle(5,6, "white"));
        list.add(new Rectangle(4,9,"black"));

        for(Shape shape : list) {
            System.out.println(shape.getArea());
        }

    }
}