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
   }
}
   
class PollWindow extends JPanel implements ActionListener {
   JButton button1, button2, button3;
   int count1, count2, count3;
  
  public PollWindow()
  {
    button1 = new JButton(" Tami");
    button1.setToolTipText("Vote for Tami");
    button1.addActionListener(this);

    button2 = new JButton("Brian");
    button2.setToolTipText("Vote for Brian");
    button2.addActionListener(this);

    button3 = new JButton(" Liz ");
    button3.setToolTipText("Vote for Liz");
    button3.addActionListener(this);

    add(button1);
    add(button2);
    add(button3);
  }

  /**
   *  Processes button events
   */
  public void actionPerformed(ActionEvent e)
  {
    JButton button = (JButton)e.getSource();

    if (button == button1)
      count1++;
    else if (button == button2)
      count2++;
    else if (button == button3)
      count3++;

    repaint();
  }
  
  /**
   *  Displays the numbers and the pie chart
   */
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int xStep = getWidth()/8;

    // Display numbers
    int y = 575;
    g.drawString(String.valueOf(count1), 2*xStep, y);
    g.drawString(String.valueOf(count2), 4*xStep, y);
    g.drawString(String.valueOf(count3), 6*xStep, y);

    // Display legend (colors)
    y = 580;
    g.setColor(Color.red);
    g.fillRect(2*xStep, y, 10, 10);
    g.setColor(Color.blue);
    g.fillRect(4*xStep, y, 10, 10);
    g.setColor(Color.green);
    g.fillRect(6*xStep, y, 10, 10);

    // Display pie chart
    int total = count1 + count2 + count3;
    if (total == 0)
      return;

    final int size = 4*xStep, x = 4*xStep - size/2;
    y = 70;
    g.setColor(Color.lightGray);
    g.fillOval(x, y, size, size);

    int degrees, from = -90;
    degrees = countToDegrees(count1, total);
    g.setColor(Color.red);
    g.fillArc(x, y, size, size, from, degrees);
    from += degrees;
    degrees = countToDegrees(count2, total);
    g.setColor(Color.blue);
    g.fillArc(x, y, size, size, from, degrees);
    from += degrees;
    degrees = countToDegrees(count3, total);
    g.setColor(Color.green);
    g.fillArc(x, y, size, size, from, degrees);
  }

  /**
   *  Converts the count as a fraction of the total into
   *  the size of the pie slice in degrees.
   */
  private int countToDegrees(int count, int total)
  {
    return (int)((double)count / (double)total * 360.);
  }
}

