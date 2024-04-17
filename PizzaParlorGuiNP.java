import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


public class PizzaParlorGuiNP {
    public static void main(String[] args){
    
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new FlowLayout());
    JButton cheesePizzaButton = new JButton("Cheese Pizza");
    JButton pepPizzaButton = new JButton("Pepperoni Pizza");
    JButton vegPizzaButton = new JButton("Veggie Pizza");
    JButton kangPizzaButton = new JButton("Kangaroo Pizza");

    panel.add(cheesePizzaButton);
    panel.add(pepPizzaButton);
    panel.add(vegPizzaButton);
    panel.add(kangPizzaButton);

    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,400);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    }
}
