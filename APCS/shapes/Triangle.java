import TurtleGraphics.Pen;

public class Triangle implements Shape {

    private double xPos, yPos;
    private double base, height;

    public Triangle() {
        xPos = 0;
        yPos = 0;
        base = 1;
        height = 1;
    }

    public Triangle(double xLoc, double yLoc, double b, double h) {
        xPos = xLoc;
        yPos = yLoc;
        base = b;
        height = h;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        double side = Math.sqrt((base / 2) * (base / 2) + height * height);
        return base + 2 * side;
    }

    public void draw(Pen p) {
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.setDirection(0); 
        p.move(base);
        p.turn(135); 
        p.move(Math.sqrt((base / 2) * (base / 2) + height * height)); 
        p.turn(90); 
        p.move(Math.sqrt((base / 2) * (base / 2) + height * height)); 
        p.turn(135);
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void move(double xLoc, double yLoc) {
        xPos = xLoc;
        yPos = yLoc;
    }

    public void stretchBy(double factor) {
        base *= factor;
        height *= factor;
    }

    public String toString() {
        return "TRIANGLE\n"
                + "Base & Height: " + base + " & " + height + "\n"
                + "(X,Y) Position: (" + xPos + "," + yPos + ")\n"
                + "Area: " + area() + "\n"
                + "Perimeter: " + perimeter();
    }
}
