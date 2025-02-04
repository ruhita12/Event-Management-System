import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Registration extends JFrame implements ActionListener {
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel, textLabel, usernameLabel, passwordLabel, passwordLabel2, emailLabel;
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, passwordField2;
    private JButton RegisterButton, LoginButton;

    public Registration() {
        super("Eventure");
        setBounds(600, 180, 700, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("re.jpg");
        this.setIconImage(icon.getImage());

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        ImageIcon backgroundIcon = new ImageIcon("re.jpg");
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        textLabel = new JLabel("Registration");
        textLabel.setBounds(215, 10, 260, 50);
        textLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
        textLabel.setBackground(new Color(224, 255, 255));
        textLabel.setForeground(Color.BLACK);
        textLabel.setOpaque(true);
        Border thickBorder = BorderFactory.createLineBorder(new Color(251, 174, 210), 0);
        textLabel.setBorder(thickBorder);
        layeredPane.add(textLabel, JLayeredPane.PALETTE_LAYER);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(140, 130, 100, 25);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(Color.BLACK);
        layeredPane.add(usernameLabel, JLayeredPane.PALETTE_LAYER);

        usernameField = new JTextField();
        usernameField.setBounds(140, 160, 450, 30);
        layeredPane.add(usernameField, JLayeredPane.PALETTE_LAYER);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(140, 200, 100, 25);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setForeground(Color.BLACK);
        layeredPane.add(passwordLabel, JLayeredPane.PALETTE_LAYER);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 230, 450, 30);
        layeredPane.add(passwordField, JLayeredPane.PALETTE_LAYER);

        passwordLabel2 = new JLabel("Confirm Password:");
        passwordLabel2.setBounds(140, 270, 200, 25);
        passwordLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel2.setForeground(Color.BLACK);
        layeredPane.add(passwordLabel2, JLayeredPane.PALETTE_LAYER);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(140, 300, 450, 30);
        layeredPane.add(passwordField2, JLayeredPane.PALETTE_LAYER);

        emailLabel = new JLabel("E-Mail:");
        emailLabel.setBounds(140, 340, 200, 25);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setForeground(Color.BLACK);
        layeredPane.add(emailLabel, JLayeredPane.PALETTE_LAYER);

        emailField = new JTextField();
        emailField.setBounds(140, 370, 450, 30);
        layeredPane.add(emailField, JLayeredPane.PALETTE_LAYER);

        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(230, 420, 100, 40);
        RegisterButton.addActionListener(this);
        RegisterButton.setBackground(Color.RED);
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.setFocusPainted(false);
        layeredPane.add(RegisterButton, JLayeredPane.PALETTE_LAYER);

        LoginButton = new JButton("Go Login");
        LoginButton.setBounds(350, 420, 100, 40);
        LoginButton.setBackground(new Color(34, 139, 34));
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setFocusPainted(false);
        layeredPane.add(LoginButton, JLayeredPane.PALETTE_LAYER);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
        super.add(layeredPane);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(passwordField2.getPassword());
            saveDetails(username, password, confirmPassword, email);
        }
    }
    private void saveDetails(String username, String password, String confirmPassword, String email) {
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
        } else if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (!email.toLowerCase().endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email must end with @gmail.com", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            File file = new File("details.txt");
            File file1 = new File("emailPass.txt");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                 FileWriter writer2 = new FileWriter(file1, true)) {

                writer.write(username + "," + password);
                writer.newLine();

                writer2.write(email + "\n" + username + "\n" + password + "\n\n");

                JOptionPane.showMessageDialog(this, "Registration Successful!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}