import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();

    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // ...

    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return 0;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    // You implement the perimeter method...
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // How do you call the Rectangle constructor from here?
        super(side, side);
    }
}

class Pentagon implements Polygon {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    public double area() {
        return (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    public double perimeter() {
        return 5 * side;
    }
}

class Hexagon implements Polygon {
    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    public double area() {
        return ((3 * Math.sqrt(3)) / 2) * side * side;
    }

    public double perimeter() {
        return 6 * side;
    }
}

class Octagon implements Polygon {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    public double area() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }

    public double perimeter() {
        return 8 * side;
    }
}

// TRIANGLES
class Triangle implements Polygon {
    protected double base, height, side1, side2, side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double base, double equalSide, double height) {
        super(base, height, base, equalSide, equalSide);
    }
}

class EquilateralTriangle extends Triangle {
    public EquilateralTriangle(double side) {
        super(side, (Math.sqrt(3) / 2) * side, side, side, side);
    }
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a polygon:");
        // Your UI logic here...
        System.out.println("1. Triangle");
        System.out.println("2. Isosceles Triangle");
        System.out.println("3. Equilateral Triangle");
        System.out.println("4. Rectangle");
        System.out.println("5. Square");
        System.out.println("6. Pentagon");
        System.out.println("7. Hexagon");
        System.out.println("8. Octagon");
        System.out.print("Enter your choice: ");
        Polygon polygon = null;
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                System.out.print("Enter side 1: ");
                double side1 = scanner.nextDouble();
                System.out.print("Enter side 2: ");
                double side2 = scanner.nextDouble();
                System.out.print("Enter side 3: ");
                double side3 = scanner.nextDouble();
                polygon = new Triangle(base, height, side1, side2, side3);
                break;

            case 2:
                System.out.print("Enter base: ");
                double isoBase = scanner.nextDouble();
                System.out.print("Enter equal side: ");
                double equalSide = scanner.nextDouble();
                System.out.print("Enter height: ");
                double isoHeight = scanner.nextDouble();
                polygon = new IsoscelesTriangle(isoBase, equalSide, isoHeight);
                break;

            case 3:
                System.out.print("Enter side: ");
                double eqSide = scanner.nextDouble();
                polygon = new EquilateralTriangle(eqSide);
                break;

            case 4:
                System.out.print("Enter length: ");
                double length = scanner.nextDouble();
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                polygon = new Rectangle(length, width);
                break;

            case 5:
                System.out.print("Enter side: ");
                double squareSide = scanner.nextDouble();
                polygon = new Square(squareSide);
                break;

            case 6:
                System.out.print("Enter side: ");
                double pentSide = scanner.nextDouble();
                polygon = new Pentagon(pentSide);
                break;

            case 7:
                System.out.print("Enter side: ");
                double hexSide = scanner.nextDouble();
                polygon = new Hexagon(hexSide);
                break;

            case 8:
                System.out.print("Enter side: ");
                double octSide = scanner.nextDouble();
                polygon = new Octagon(octSide);
                break;

            default:
                System.out.println("Error. Invalid choice.");
                scanner.close();
                return;
        }

        System.out.println("Area: " + polygon.area());
        System.out.println("Perimeter: " + polygon.perimeter());

        scanner.close();
    }
}
