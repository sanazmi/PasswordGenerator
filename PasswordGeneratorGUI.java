import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGeneratorGUI {

    public static String generateRandomPassword(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Creating a new JFrame
        System.out.println("Starting GUI...");
        JFrame frame = new JFrame("Password Generator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Creating the components for JFrame 
        JLabel label = new JLabel("Enter password length:");
        label.setBounds(50, 30, 200, 30);
        JTextField textField = new JTextField();
        textField.setBounds(200, 30, 100, 30);
        JButton generateButton = new JButton("Generate Password");
        generateButton.setBounds(50, 80, 200, 30);
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 120, 300, 30);

        //button action listener
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(textField.getText());
                    String password = generateRandomPassword(length);
                    resultLabel.setText("Generated Password: " + password);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });

        // Adding components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(generateButton);
        frame.add(resultLabel);

        // frame visiblity
        frame.setVisible(true);
    }
}
