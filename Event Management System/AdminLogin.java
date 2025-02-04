import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    AdminLogin() {
        setTitle("Admin Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setLayout(null);

        ImageIcon icon = new ImageIcon("E:\\versity\\Java FInal Term\\Project\\tttt.jpg");
        this.setIconImage(icon.getImage());

        JLabel adminLabel = new JLabel("Admin Login");
        adminLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        adminLabel.setBounds(120, 30, 200, 40);
        adminLabel.setForeground(new Color(70, 130, 180));
        add(adminLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(80, 100, 70, 20);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(160, 100, 150, 25);
        add(nameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(80, 140, 80, 20);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(160, 140, 150, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Lucida Fax", Font.BOLD, 16));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.setBounds(160, 180, 100, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String pass = new String(passwordField.getPassword());

                if (name.equals("Admin") && pass.equals("Admin")) {
                    JOptionPane.showMessageDialog(null, "Success");
                    AdminPanel p = new AdminPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        setVisible(true);
    }
}
