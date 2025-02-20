import TurtleGraphics.*;
import java.awt.Color;
import TerminalIO.KeyboardReader;
import java.util.ArrayList;

public class TestShapes {
   public static void main (String[] args) {

      // Declare and instantiate a pen, a circle and a rectangle
      Pen p = new StandardPen();
      Shape s1 = new Circle (20, 30, 40);
      Shape s2 = new Rect (-20, -20, 10, 20);
      Shape s3 = new Wheel(-30,-30,10,5);
      Shape s4 = new Triangle(-60,0,10,30,30);
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      shapes.add(s1);
      shapes.add(s2);
      shapes.add(s3);
      shapes.add(s4);
      
      for(Shape s : shapes)
      {
         s.draw(p);
         System.out.println(s);
      }

      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the circle and rectangle
      p.setColor (Color.white);
      for(Shape s : shapes)
      {
         s.draw(p);
      }
      p.setColor (Color.red);
      
      // Move the circle and rectangle, change their size, and redraw
      s1.move (30, 30);        s2.move (-30, -30);
      s1.stretchBy (2);           s2.stretchBy (2);
      s1.draw (p);                       s2.draw (p);

      s3.move (30,30);         s4.move (-30,-30);
      s3.stretchBy (2);           s4.stretchBy (2);
      s3.draw (p);                       s4.draw(p);
   }
}

