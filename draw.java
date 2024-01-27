/**
 *  This class will create a piece of paper and a pen,
 *  place the pen on the paper and then draw a square 280 units on
 *  each side to the left of the origin.  It will also draw a circle
 *  of radius 160 to the right of the origin.
 */
import apcslib.*;
import java.awt.Color;


public class draw
{
  
  public static void main(String[] args)

  {
    DrawingTool pen;
    SketchPad paper;

    paper = new SketchPad(1500, 900);
    pen = new DrawingTool(paper);
   
	// draw the square for the house
   pen.setWidth(3);
	pen.up();
	pen.move(-400, -140);
	pen.down();
	pen.move(-400,140);
	pen.move(-120,140);
	pen.move(-120,-140);
	pen.move(-400,-140);
	pen.up();
   pen.move(-500,140);
   pen.down();
   pen.move(-500,-140);
   pen.move(-400,-140);
   pen.up();
   pen.move(-20,140);
   pen.down();
   pen.move(-20,-140);
   pen.move(-120,-140);

	// enter code here to draw the other requirements for the house
   
   //roof
   pen.setWidth(3);
   pen.up();
   pen.move(-500, 140);
   pen.down();
   pen.move(-400, 240);
   pen.move(-300, 240);
   pen.move(-400, 140);
   pen.move(-500, 140);
   pen.up();
   pen.move(-300, 240);
   pen.down();
   pen.move(-280, 260);
   pen.move(-240, 260);
   pen.move(-220, 240);
   pen.move(-140, 240);
   pen.move(-140, 160);
   pen.move(-140, 240);  
   pen.up();
   pen.move(-220,240);
   pen.down();
   pen.move(-120,140);
   pen.up();
   pen.move(-120,140);
   pen.down();
   pen.move(-80,140);
   pen.up();
   
   //chimeny
   pen.setWidth(3);
   pen.move(-140,240);
   pen.down();
   pen.move(-140,260);
   pen.move(-80,260);
   pen.move(-80,200);
   pen.move(-20,140);
   pen.move(-80,140);
   pen.move(-80,200);
   pen.up();
   pen.move(-80,140);
   pen.move(-120,140);
   pen.up();
   pen.move(-140,220);
   pen.down();
   pen.move(-140,160);
   pen.up();
   pen.move(-120,280);
   pen.down();
   pen.drawCircle(5);
   pen.up();
   pen.move(-120,320);
   pen.down();
   pen.drawCircle(5);
   pen.up();
   pen.move(-100,300);
   pen.down();
   pen.drawCircle(5);
   //windows
   pen.setWidth(3);
   pen.up();
   pen.move(-140,40);
   pen.down();
   pen.move(-140,100);
   pen.move(-200,100);
   pen.move(-200,40);
   pen.move(-140,40);
   pen.up();
   pen.move(-260,200);
   pen.down();
   pen.drawCircle(20);
   pen.up();
   pen.move(-260,180);
   pen.down();
   pen.move(-260,220);
   pen.up();
   pen.move(-280,200);
   pen.down();
   pen.move(-240,200);
   pen.up();
   pen.move(-140,70);
   pen.down();
   pen.move(-200,70);
   pen.up();
   pen.move(-170,40);
   pen.down();
   pen.move(-170,100);
   pen.up();
   pen.move(-320,70);
   pen.down();
   pen.move(-380,70);
   pen.up();
   pen.move(-350,40);
   pen.down();
   pen.move(-350,100);
   //big windows
   pen.setWidth(3);
   pen.up();
   pen.move(-40,80);
   pen.down();
   pen.move(-100,80);
   pen.move(-100,-80);
   pen.move(-40,-80);
   pen.move(-40,80);
   pen.up();
   pen.move(-70,-80);
   pen.down();
   pen.move(-70,80);
   pen.up();
   pen.move(-40,0);
   pen.down();
   pen.move(-100,0);
   pen.up();
   pen.move(-440,80);
   pen.down();
   pen.move(-480,80);
   pen.move(-480,-80);
   pen.move(-420,-80);
   pen.move(-420,80);
   pen.move(-450,80);
   pen.up();
   pen.move(-450,-80);
   pen.down();
   pen.move(-450,80);
   pen.up();
   pen.move(-420,0);
   pen.down();
   pen.move(-480,0);
   
   //just add -180 to all x values
   pen.setWidth(3);
   pen.up();
   pen.move(-320,40);
   pen.down();
   pen.move(-320,100);
   pen.move(-380,100);
   pen.move(-380,40);
   pen.move(-320,40);
   //door
   pen.setColor(Color.orange);
   pen.setWidth(3);
   pen.up();
   pen.move(-220,0);
   pen.down();
   pen.move(-300,0);
   pen.move(-300,-140);
   pen.move(-220,-140);
   pen.move(-220,0);
   pen.up();
   pen.setColor(Color.yellow);
   pen.setWidth(3);
   pen.move(-240,-80);
   pen.down();
   pen.drawCircle(5);
  
	// draw the circle for the smiley
   pen.setWidth(5);
   pen.setColor(Color.orange);
	pen.up();
	pen.move(300, 0);
	pen.down();
	pen.drawCircle(160);
	pen.up();

	// enter code here to draw the other requirements for the smiley
   
   //eyes
   pen.setWidth(5);
   pen.setColor(Color.black);
   pen.up();
   pen.move(220,60);
   pen.down();
   pen.move(280,60);
   pen.move(250,120);
   pen.move(220,60);
   pen.up();
   pen.move(320,60);
   pen.down();
   pen.move(380,60);
   pen.move(350,120);
   pen.move(320,60);
   //nose
   pen.setWidth(5);
   pen.up();
   pen.move(270,20);
   pen.down();
   pen.move(330,20);
   pen.move(300,-40);
   pen.move(270,20);
   //mouth
   pen.setWidth(5);
   pen.up();
   pen.move(200,-60);
   pen.down();
   pen.move(240,-120);
   pen.move(290,-120);
   pen.move(290,-100);
   pen.move(310,-100);
   pen.move(310,-120);
   pen.move(360,-120);
   pen.move(400,-60);
   pen.move(360,-60);
   pen.move(360,-90);
   pen.move(320,-90);
   pen.move(320,-60);
   pen.move(280,-60);
   pen.move(280,-90);
   pen.move(240,-90);
   pen.move(240,-60);
   pen.move(200,-60);

   //bowtie
   pen.setWidth(5);
   pen.setColor(Color.red);
   pen.up();
   pen.move(300,-160);
   pen.down();
   pen.move(400,-120);
   pen.move(400,-180);
   pen.move(300,-160);
   pen.move(200,-120);
   pen.move(200,-180);
   pen.move(300,-160);
   
   //stem
   pen.setWidth(5);
   pen.setColor(Color.green);
   pen.up();
   pen.move(280,160);
   pen.down();
   pen.move(240,200);
   pen.move(280,220);
   pen.move(320,160);
   
   //name
   pen.setColor(Color.black); 
   pen.up();
   pen.move(0,0);
   pen.drawString("Nick Posavec");


  }
}

