import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearChecker() {

        super("Leap Year Checker");


        tfYear = new JTextField();
        tfYear.setMaximumSize(new Dimension(200, 50));
        btnCheckYear = new JButton("Check Year");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));


        add(new JLabel("Enter a year:"));
        add(tfYear);
        add(btnCheckYear);


        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setSize(300, 200);

        setVisible(true);
    }

    private void checkLeapYear() {
        try {
            int year = Integer.parseInt(tfYear.getText());


            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);


            String message = isLeapYear ? "Leap year" : "Not a leap year";
            JOptionPane.showMessageDialog(null, message, "Leap Year Checker", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LeapYearChecker();
            }
        });
    }
}
