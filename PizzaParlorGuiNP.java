import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


public class PizzaParlorGuiNP {
    public static void main(String[] args){
    
    JFrame frame = new JFrame();
    
    //Pizza buttons
    JButton cheesePizzaButton = new JButton("Cheese Pizza");
    JButton pepPizzaButton = new JButton("Pepperoni Pizza");
    JButton vegPizzaButton = new JButton("Veggie Pizza");
    JButton kangPizzaButton = new JButton("Kangaroo Pizza");
    //Panel setup
    JPanel basePanel = new JPanel(new FlowLayout());
    basePanel.setBackground(Color.black);
    basePanel.add(cheesePizzaButton);
    basePanel.add(pepPizzaButton);
    basePanel.add(vegPizzaButton);
    basePanel.add(kangPizzaButton);
    //Frame setup
    frame.add(basePanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    //Plus and minus buttons & plus and minus icons
    Icon plus = new ImageIcon("plus.png");
    Icon minus = new ImageIcon("minus.png");

    JButton IncCheese = new JButton(plus);
    JButton DecCheese = new JButton(minus);
    JButton IncPep = new JButton(plus);
    JButton DecPep = new JButton(minus);
    JButton IncVeg = new JButton(plus);
    JButton DecVeg = new JButton(minus);
    JButton IncKang = new JButton(plus);
    JButton DecKang = new JButton(minus);
    basePanel.add(IncCheese);
    basePanel.add(DecCheese);
    basePanel.add(IncPep);
    basePanel.add(DecPep);
    }
}
