// Shape interface

import TurtleGraphics.StandardPen;

interface Shape {
    double area();
    double perimeter();
    void move(double xLoc, double yLoc);
    void stretchBy(double factor);
    String toString();
    void draw(StandardPen p);
}

// Triangle class implementing Shape
class Triangle implements Shape {
    private double xPos, yPos;
    private double base, height;

    // Default constructor
    public Triangle() {
        xPos = 0;
        yPos = 0;
        base = 1;
        height = 1;
    }

    // Parameterized constructor
    public Triangle(double xLoc, double yLoc, double b, double h) {
        if (b <= 0 || h <= 0) {
            throw new IllegalArgumentException("Base and height must be positive.");
        }
        xPos = xLoc;
        yPos = yLoc;
        base = b;
        height = h;
    }

    // Calculate area
    public double area() {
        return 0.5 * base * height;
    }

    // Calculate perimeter
    public double perimeter() {
        double side = Math.sqrt((base / 2) * (base / 2) + height * height);
        return base + 2 * side;
    }

    // Draw the triangle using a Pen
    public void draw(Pen p) {
        p.up(); // Lift the pen
        p.move(xPos, yPos); // Move to the starting position
        p.down(); // Lower the pen to start drawing

        p.setDirection(0); // Set the initial direction (right)
        p.move(base); // Draw the base
        p.turn(135); // Turn to draw the first side
        p.move(Math.sqrt((base / 2) * (base / 2) + height * height)); // Draw the first side
        p.turn(90); // Turn to draw the second side
        p.move(Math.sqrt((base / 2) * (base / 2) + height * height)); // Draw the second side
        p.turn(135); // Turn back to the original orientation
    }

    // Getter for xPos
    public double getXPos() {
        return xPos;
    }

    // Getter for yPos
    public double getYPos() {
        return yPos;
    }

    // Move the triangle to a new position
    public void move(double xLoc, double yLoc) {
        xPos = xLoc;
        yPos = yLoc;
    }

    // Stretch the triangle by a factor
    public void stretchBy(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Stretch factor must be positive.");
        }
        base *= factor;
        height *= factor;
    }

    // String representation of the triangle
    public String toString() {
        return String.format(
            "TRIANGLE\n" +
            "Base & Height: %.2f & %.2f\n" +
            "(X,Y) Position: (%.2f, %.2f)\n" +
            "Area: %.2f\n" +
            "Perimeter: %.2f",
            base, height, xPos, yPos, area(), perimeter()
        );
    }

    @Override
    public void draw(StandardPen p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
}

// Mock Pen class for drawing
class Pen {
    private double x, y;
    private double direction;

    public Pen() {
        x = 0;
        y = 0;
        direction = 0; // 0 degrees is to the right
    }

    public void up() {
        System.out.println("Pen up");
    }

    public void down() {
        System.out.println("Pen down");
    }

    public void move(double distance) {
        double radians = Math.toRadians(direction);
        x += distance * Math.cos(radians);
        y += distance * Math.sin(radians);
        System.out.printf("Moved to (%.2f, %.2f)\n", x, y);
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.printf("Moved to (%.2f, %.2f)\n", x, y);
    }

    public void setDirection(double degrees) {
        direction = degrees;
        System.out.printf("Direction set to %.2f degrees\n", direction);
    }

    public void turn(double degrees) {
        direction += degrees;
        System.out.printf("Turned %.2f degrees. New direction: %.2f degrees\n", degrees, direction);
    }
}
