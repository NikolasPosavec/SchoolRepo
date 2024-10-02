import TurtleGraphics.RainbowPen;
import java.awt.Color;

public class TurtleGraphicsNP 
{
    public static void main(String[] args) 
    {
        RainbowPen pen = new RainbowPen();
        pen.setColor(Color.blue);

        double sideStep = 175; 

        for (int i = 0; i < 6; i++) 
        {
            for (int j = 0; j < 12; j++) 
            { 
                for (int k = 0; k < 6; k++) {
                    pen.move(sideStep);
                    pen.turn(60);
                    pen.turn(5); 
                }
    
                pen.turn(60);
            }
            
            pen.turn(60);
        }
    }
}
