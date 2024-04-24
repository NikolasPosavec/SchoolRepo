import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzaParlorGUI extends JFrame {
    private JButton parlor1Button, parlor2Button;

    public PizzaParlorGUI() {
        setTitle("Pizza Parlor Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        parlor1Button = new JButton("Pizza Parlor 1");
        parlor2Button = new JButton("Pizza Parlor 2");

        add(parlor1Button);
        add(parlor2Button);

        parlor1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPizzaParlor(1);
            }
        });

        parlor2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openPizzaParlor(2);
            }
        });

        setVisible(true);
    }

    private void openPizzaParlor(int parlorNumber) {
        JFrame parlorFrame = new JFrame("Pizza Parlor " + parlorNumber);
        parlorFrame.setSize(400, 300);
        parlorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parlorFrame.setLayout(new GridLayout(9, 2));

        JLabel cheeseLabel = new JLabel("Cheese Supply:");
        JLabel pepperoniLabel = new JLabel("Pepperoni Supply:");
        JLabel veggieLabel = new JLabel("Veggie Supply:");
        JLabel kangarooLabel = new JLabel("Kangaroo Supply:");
        JLabel doughLabel = new JLabel("Dough Supply:");
        JLabel orderCheesePizzaLabel = new JLabel("Number of Cheese Pizzas to Order:");
        JLabel orderPepPizzaLabel = new JLabel("Number of Pepperoni Pizzas to Order:");
        JLabel orderVegPizzaLabel = new JLabel("Number of Veggie Pizzas to Order:");
        JLabel orderKangLabel = new JLabel("Number of Kangaroo Pizzas to Order:");

        JTextField cheeseField = new JTextField();
        JTextField pepperoniField = new JTextField();
        JTextField veggieField = new JTextField();
        JTextField kangarooField = new JTextField();
        JTextField doughField = new JTextField();
        JTextField orderCheesePizzaField = new JTextField();
        JTextField orderPepPizzaField = new JTextField();
        JTextField orderVegPizzaField = new JTextField();
        JTextField orderKangPizzaField = new JTextField();

        JButton setIngredientsButton = new JButton("Set Ingredients");

        parlorFrame.add(cheeseLabel);
        parlorFrame.add(cheeseField);
        parlorFrame.add(pepperoniLabel);
        parlorFrame.add(pepperoniField);
        parlorFrame.add(veggieLabel);
        parlorFrame.add(veggieField);
        parlorFrame.add(kangarooLabel);
        parlorFrame.add(kangarooField);
        parlorFrame.add(doughLabel);
        parlorFrame.add(doughField);
        parlorFrame.add(orderCheesePizzaLabel);
        parlorFrame.add(orderCheesePizzaField);
        parlorFrame.add(orderPepPizzaLabel);
        parlorFrame.add(orderPepPizzaField);
        parlorFrame.add(orderVegPizzaLabel);
        parlorFrame.add(orderVegPizzaField);
        parlorFrame.add(orderKangLabel);
        parlorFrame.add(orderKangPizzaField);
        parlorFrame.add(setIngredientsButton);

        setIngredientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int cheese = Integer.parseInt(cheeseField.getText());
                int pepperoni = Integer.parseInt(pepperoniField.getText());
                int veggies = Integer.parseInt(veggieField.getText());
                int kangaroo = Integer.parseInt(kangarooField.getText());
                int dough = Integer.parseInt(doughField.getText());
                int numCheesePizzas = Integer.parseInt(orderCheesePizzaField.getText());
                int numPepPizzas = Integer.parseInt(orderPepPizzaField.getText());
                int numVegPizzas = Integer.parseInt(orderVegPizzaField.getText());
                int numKangPizzas = Integer.parseInt(orderKangPizzaField.getText());

                PizzaParlor pizzaParlor = new PizzaParlor(cheese, pepperoni, veggies, kangaroo, dough);

                // Order pizzas
                pizzaParlor.orderCheese(numCheesePizzas);
                pizzaParlor.orderPepperoni(numPepPizzas);
                pizzaParlor.orderVeggie(numVegPizzas);
                pizzaParlor.orderKangaroo(numKangPizzas);

                // Display results
                JOptionPane.showMessageDialog(null, pizzaParlor.toString());

                // Close the current window
                parlorFrame.dispose();
            }
        });

        parlorFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PizzaParlorGUI());
    }
}
