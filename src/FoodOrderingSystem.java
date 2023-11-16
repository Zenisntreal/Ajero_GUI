import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FoodOrderingSystem extends JFrame {
    private Map<JCheckBox, Double> foodPrices;
    private JRadioButton rb5, rb10, rb15, rbNone;
    private JButton btnOrder;

    public FoodOrderingSystem() {
        super("Food Ordering System");


        foodPrices = new HashMap<>();
        foodPrices.put(new JCheckBox("Pizza - Php 100"), 100.0);
        foodPrices.put(new JCheckBox("Burger - Php 80"), 80.0);
        foodPrices.put(new JCheckBox("Fries - Php 65"), 65.0);
        foodPrices.put(new JCheckBox("Soft Drinks - Php 55"), 55.0);
        foodPrices.put(new JCheckBox("Tea - Php 50"), 50.0);
        foodPrices.put(new JCheckBox("Sundae - Php 40"), 40.0);

        rb5 = new JRadioButton("5%");
        rb10 = new JRadioButton("10%");
        rb15 = new JRadioButton("15%");
        rbNone = new JRadioButton("None", true); // Default to no discount

        btnOrder = new JButton("Order");


        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);
        discountGroup.add(rbNone);


        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));


        for (JCheckBox checkBox : foodPrices.keySet()) {
            add(checkBox);
        }

        add(new JLabel("Select Discount:"));
        add(rb5);
        add(rb10);
        add(rb15);
        add(rbNone);

        add(btnOrder);


        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeTotalPrice();
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(350, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void computeTotalPrice() {
        double totalPrice = 0;


        for (JCheckBox checkBox : foodPrices.keySet()) {
            if (checkBox.isSelected()) {
                totalPrice += foodPrices.get(checkBox);
            }
        }


        if (rb5.isSelected()) {
            totalPrice *= 0.95;
        } else if (rb10.isSelected()) {
            totalPrice *= 0.90;
        } else if (rb15.isSelected()) {
            totalPrice *= 0.85;
        }


        JOptionPane.showMessageDialog(
                null,
                String.format("The total price is Php %.2f", totalPrice),
                "Food Ordering System",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FoodOrderingSystem();
            }
        });
    }
}
