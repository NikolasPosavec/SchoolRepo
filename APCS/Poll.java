import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Poll {
   public static void main(String[] args) {
      JFrame pollFrame = new JFrame("Poll");
      PollWindow pw = new PollWindow();
      pw.setBounds(0, 0, 900, 900);
      pollFrame.add(pw);
      pollFrame.setSize(900,900);
      pollFrame.setLayout(null);
      pollFrame.setVisible(true); 
      pollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
}

class PollWindow extends JPanel implements ActionListener {
   JButton button1, button2, button3, button4;
   int count1, count2, count3, count4;

   public PollWindow() {
      button1 = new JButton("Nick");
      button1.setToolTipText("Vote for Nick");
      button1.addActionListener(this);

      button2 = new JButton("Dan");
      button2.setToolTipText("Vote for Dan");
      button2.addActionListener(this);

      button3 = new JButton("Eric");
      button3.setToolTipText("Vote for Eric");
      button3.addActionListener(this);

      button4 = new JButton("Onyeka");
      button4.setToolTipText("Vote for Onyeka");
      button4.addActionListener(this);

      add(button1);
      add(button2);
      add(button3);
      add(button4);
   }

   public void actionPerformed(ActionEvent e) {
      JButton button = (JButton) e.getSource();

      if (button == button1)
         count1++;
      else if (button == button2)
         count2++;
      else if (button == button3)
         count3++;
      else if (button == button4)
         count4++;

      repaint();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      final int xStep = getWidth() / 10;
      int y = 575;
      g.drawString(String.valueOf(count1), 2 * xStep, y);
      g.drawString(String.valueOf(count2), 4 * xStep, y);
      g.drawString(String.valueOf(count3), 6 * xStep, y);
      g.drawString(String.valueOf(count4), 8 * xStep, y);

      y = 580;
      g.setColor(Color.pink);
      g.fillRect(2 * xStep, y, 10, 10);
      g.setColor(Color.orange);
      g.fillRect(4 * xStep, y, 10, 10);
      g.setColor(Color.black);
      g.fillRect(6 * xStep, y, 10, 10);
      g.setColor(Color.blue);
      g.fillRect(8 * xStep, y, 10, 10);
      g.setColor(Color.black);
      g.drawString("Nick", 2 * xStep + 15, y + 10);
      g.drawString("Dan", 4 * xStep + 15, y + 10);
      g.drawString("Eric", 6 * xStep + 15, y + 10);
      g.drawString("Onyeka", 8 * xStep + 15, y + 10);

      int total = count1 + count2 + count3 + count4;
      if (total == 0)
         return;

      final int size = 4 * xStep, x = 5 * xStep - size / 2;
      y = 70;
      g.setColor(Color.lightGray);
      g.fillOval(x, y, size, size);

      int degrees, from = 0;
      degrees = countToDegrees(count1, total);
      g.setColor(Color.pink);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;
      degrees = countToDegrees(count2, total);
      g.setColor(Color.orange);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;
      degrees = countToDegrees(count3, total);
      g.setColor(Color.black);
      g.fillArc(x, y, size, size, from, degrees);
      from += degrees;
      degrees = countToDegrees(count4, total);
      g.setColor(Color.blue);
      g.fillArc(x, y, size, size, from, degrees);

      
    g.setColor(Color.black);
      y += 450; 
        if (total > 0) {
          g.drawString("Nick: " + String.format("%.1f", (count1 / (double) total) * 100) + "%", 2 * xStep, y);
          g.drawString("Dan: " + String.format("%.1f", (count2 / (double) total) * 100) + "%", 4 * xStep, y);
          g.drawString("Eric: " + String.format("%.1f", (count3 / (double) total) * 100) + "%", 6 * xStep, y);
          g.drawString("Onyeka: " + String.format("%.1f", (count4 / (double) total) * 100) + "%", 8 * xStep, y);
        }

   }

   private int countToDegrees(int count, int total) {
      return (int) ((double) count / (double) total * 360.);
   }
}
