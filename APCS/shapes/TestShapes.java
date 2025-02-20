import TurtleGraphics.*;
import java.awt.Color;
import TerminalIO.KeyboardReader;
import java.util.ArrayList;

public class TestShapes {
   public static void main (String[] args) {

      // Declare and instantiate a pen, a circle and a rectangle
      Pen p = new StandardPen();
      Shape s1 = new Circle (500, 100, 40); // Moved to (100, 100)
      Shape s2 = new Rect (300, 300, 50, 100); // Moved to (300, 300) and increased size
      Shape s3 = new Wheel(-300, -300, 50, 5); // Moved to (-300, -300) and increased size
      Shape s4 = new Triangle(-500, 0, 100, 150, 200); // Moved to (-500, 0) and increased size
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      shapes.add(s1);
      shapes.add(s2);
      shapes.add(s3);
      shapes.add(s4);
      
      for(Shape s : shapes) {
         s.draw(p);
         System.out.println(s);
      }

      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the shapes
      p.setColor (Color.white);
      for(Shape s : shapes) {
         s.draw(p);
      }
      p.setColor (Color.red);
      
      // Move and redraw the shapes
      s1.move (50, 50); s2.move (-50, -50);
      s1.stretchBy (2); s2.stretchBy (2);
      s1.draw (p); s2.draw (p);

      s3.move (350,350); s4.move (-350,-350);
      s3.stretchBy (2); s4.stretchBy (2);
      s3.draw (p); s4.draw(p);
   }
}

