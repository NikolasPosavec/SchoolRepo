import TurtleGraphics.Pen;

public class Triangle extends AbstractShape implements Shape
{
    private double side1, side2, side3;
    
    public Triangle()
    {
        super();
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    public Triangle(double xLoc, double yLoc, double s1, double s2, double s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double area()
    {
        double area = 0;
        double halfperimeter = 0;
        halfperimeter = (side1 + side2 + side3) / 2;
        double temp = 0;
        temp = halfperimeter*(halfperimeter-side1)*(halfperimeter-side2)*(halfperimeter-side3);
        area = Math.sqrt(temp);
        return area;
    }

    public double perimeter()
    {
        return side1+side2+side3;
    }

    public void draw (Pen p)
    {
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.setDirection(0);
        p.move(side1);
        p.turn(180-Math.toDegrees(lawOfCos(side3, side2, side1)));
        p.move(side2);
        p.turn(180-Math.toDegrees(lawOfCos(side1, side3, side2)));
        p.move(side3);
    }

    public void stretchBy(double factor)
    {
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }

    public double lawOfCos (double a, double b, double c)
    {
        return Math.acos((Math.pow(b,2) + Math.pow(c,2) - Math.pow(a,2)/(2*b*c)));
    }

    public String toString()
    {
        String str = "TRIANGLE\n" + "Side Lengths: " + side1 + ", " + side2 + ", " + side3 + "\n"
        + "Area: " + area();
        return str;
    }

    
}
