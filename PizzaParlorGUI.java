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
        parlorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel cheeseLabel = new JLabel("Cheese Supply:");
        JLabel pepperoniLabel = new JLabel("Pepperoni Supply:");
        JLabel veggieLabel = new JLabel("Veggie Supply:");
        JLabel kangarooLabel = new JLabel("Kangaroo Supply:");
        JLabel doughLabel = new JLabel("Dough Supply:");
        JLabel orderCheesePizzaLabel = new JLabel("Number of Cheese Pizzas to Order:");
        JLabel orderPepPizzaLabel = new JLabel("Number of Pepperoni Pizzas to Order:");
        JLabel orderVegPizzaLabel = new JLabel("Number of Veggie Pizzas to Order:");
        JLabel orderKangLabel = new JLabel("Number of Kangaroo Pizzas to Order:");

        JTextField cheeseField = new JTextField(10);
        JTextField pepperoniField = new JTextField(10);
        JTextField veggieField = new JTextField(10);
        JTextField kangarooField = new JTextField(10);
        JTextField doughField = new JTextField(10);
        JTextField orderCheesePizzaField = new JTextField(10);
        JTextField orderPepPizzaField = new JTextField(10);
        JTextField orderVegPizzaField = new JTextField(10);
        JTextField orderKangPizzaField = new JTextField(10);

        JButton setIngredientsButton = new JButton("Set Ingredients");

        // Add components to the panel
        panel.add(cheeseLabel);
        panel.add(cheeseField);
        panel.add(pepperoniLabel);
        panel.add(pepperoniField);
        panel.add(veggieLabel);
        panel.add(veggieField);
        panel.add(kangarooLabel);
        panel.add(kangarooField);
        panel.add(doughLabel);
        panel.add(doughField);
        panel.add(orderCheesePizzaLabel);
        panel.add(orderCheesePizzaField);
        panel.add(orderPepPizzaLabel);
        panel.add(orderPepPizzaField);
        panel.add(orderVegPizzaLabel);
        panel.add(orderVegPizzaField);
        panel.add(orderKangLabel);
        panel.add(orderKangPizzaField);
        panel.add(setIngredientsButton);

        // Add the panel to the frame
        parlorFrame.add(panel);

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

                pizzaParlor.orderCheese(numCheesePizzas);
                pizzaParlor.orderPepperoni(numPepPizzas);
                pizzaParlor.orderVeggie(numVegPizzas);
                pizzaParlor.orderKangaroo(numKangPizzas);

                JOptionPane.showMessageDialog(null, pizzaParlor.toString());

                parlorFrame.dispose();
            }
        });

        parlorFrame.pack();
        parlorFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PizzaParlorGUI());
    }
}
