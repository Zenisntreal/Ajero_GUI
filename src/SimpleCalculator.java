import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1, tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;

    public SimpleCalculator() {

        super("Simple Calculator");



        ImageIcon image = new ImageIcon("logosmile.jpg");
        setIconImage(image.getImage());


        tfNumber1 = new JTextField(10);
        tfNumber2 = new JTextField(10);

        String[] operators = {"+", "-", "*", "/"};
        cbOperations = new JComboBox<>(operators);

        btnCompute = new JButton("Compute");
        lblResult = new JLabel("Result: ");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));


        add(new JLabel("Number 1:"));
        add(tfNumber1);
        add(new JLabel("Number 2:"));
        add(tfNumber2);
        add(new JLabel("Operation:"));
        add(cbOperations);
        add(btnCompute);
        add(lblResult);


        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeResult();
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(300, 200);

        setVisible(true);
    }

    private void computeResult() {
        try {
            double num1 = Double.parseDouble(tfNumber1.getText());
            double num2 = Double.parseDouble(tfNumber2.getText());
            String operation = (String) cbOperations.getSelectedItem();
            double result = 0;


            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }


            lblResult.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
