import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;


public class Rect extends AbstractShape implements Shape {

   private double xPos, yPos;
   private double height, width;

   public Rect() {
      xPos = 0;
      yPos = 0;
      height = 1;
      width = 1;
   }

   public Rect (double xLoc, double yLoc, double h, double w) {
      xPos = xLoc;
      yPos = yLoc;
      height = h;
      width = w;
   }
 
   public double area() {
      return height * width;
   }
 
  public double perimeter() {
      return 2 * height + 2 * width;
   }
   @Override
   public void draw(Pen p) {
      p.up();
      p.move (xPos, yPos);
      p.down();
      p.setDirection (0); p.move (width);
      p.turn (-90); p.move (height);
      p.turn (-90); p.move (width);
      p.turn (-90); p.move (height);
   }

   public double getXPos() {
      return xPos;
   }

   public double getYPos() {
      return yPos;
   }

   public void move (double xLoc, double yLoc) {
      xPos = xLoc;
      yPos = yLoc;
   }

   public void stretchBy (double factor) {
      height *= factor;
      width *= factor;
   }

   public String toString() {
      String str = "RECTANGLE\n"
                 + "Width & Height: " + width + " & " + height +"\n"
                 + "(X,Y) Position: (" + xPos + "," + yPos + ")\n" 
                 + "Area: " + area()+"\n"
					   + "Perimeter: " + perimeter();
      return str;
   }

   @Override
   public void draw(StandardPen p) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'draw'");
   }
}

