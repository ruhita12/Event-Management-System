import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame implements ActionListener, MouseListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4, registerLabel, label5;
    private Font f1, f2, f3;
    private JTextField tf1;
    private JButton bt1, bt2, bt3, bt4; 
    private JPasswordField tf2;
    private ImageIcon img1;

    public Login() {
        super("Event Management System");
        this.setSize(900, 650);
        this.setLocation(590, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("Login");
        label1.setBounds(390, 50, 500, 90);
        f1 = new Font("Times New Roman", Font.BOLD, 40);
        label1.setFont(f1);
        panel.add(label1);

        bt4 = new JButton("Admin");
        bt4.setBounds(720, 30, 120, 40);
        bt4.setFocusable(false);
        bt4.setForeground(Color.BLACK);
        bt4.setBackground(Color.ORANGE);
        bt4.addActionListener(this);
        panel.add(bt4);

        label2 = new JLabel("User Name");
        label2.setBounds(250, 150, 500, 45);
        f2 = new Font("Times New Roman", Font.BOLD, 25);
        label2.setFont(f2);
        panel.add(label2);

        tf1 = new JTextField();
        tf1.setBounds(380, 155, 200, 40);
        tf1.setFont(f2);
        panel.add(tf1);

        label3 = new JLabel("Password");
        label3.setBounds(251, 210, 500, 45);
        label3.setFont(f2);
        panel.add(label3);

        tf2 = new JPasswordField();
        tf2.setBounds(380, 215, 200, 40);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        panel.add(tf2);

        bt1 = new JButton("Exit");
        bt1.setBounds(700, 500, 130, 40);
        bt1.setFocusable(false);
        bt1.setForeground(Color.BLACK);
        bt1.setBackground(Color.ORANGE);
        bt1.addActionListener(this);
        panel.add(bt1);

        bt2 = new JButton("Back");
        bt2.setBounds(500, 500, 130, 40);
        bt2.setFocusable(false);
        bt2.setForeground(Color.BLACK);
        bt2.setBackground(Color.ORANGE);
        bt2.addActionListener(this);
        panel.add(bt2);

        bt3 = new JButton("SignIn");
        bt3.setBounds(400, 300, 130, 40);
        bt3.setFocusable(false);
        bt3.setForeground(Color.BLACK);
        bt3.setBackground(Color.ORANGE);
        bt3.addActionListener(this);
        bt3.addMouseListener(this);
        panel.add(bt3);

        JPanel registerPanel = new JPanel();
        registerPanel.setBounds(300, 350, 300, 40);
        registerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        registerPanel.setOpaque(false);

        label4 = new JLabel("Don't have any account?");
        f3 = new Font("Times New Roman", Font.BOLD, 16);
        label4.setFont(f3);
        registerPanel.add(label4);

        registerLabel = new JLabel("Register");
        registerLabel.setFont(f3);
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(this);
        registerPanel.add(registerLabel);

        panel.add(registerPanel);

        img1 = new ImageIcon("flower.png");
        label5 = new JLabel(img1);
        label5.setBounds(0, 0, 900, 650);
        panel.add(label5);

        this.add(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == registerLabel) {
            try {
                new Registration().setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error opening registration page: " + ex.getMessage());
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == bt3) {
            bt3.setBackground(Color.RED);
        } else if (e.getSource() == registerLabel) {
            registerLabel.setForeground(Color.RED);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == bt3) {
            bt3.setBackground(Color.YELLOW);
        } else if (e.getSource() == registerLabel) {
            registerLabel.setForeground(Color.BLUE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            new Welcome().setVisible(true);  
            this.dispose();
        } else if (e.getSource() == bt2) {
            new Welcome().setVisible(true);
            this.dispose();
        } else if (e.getSource() == bt3) {
            String username = tf1.getText().trim();
            String password = new String(tf2.getPassword()).trim();
            
            if(username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Please fill in both username and password fields!", 
                    "Empty Fields", 
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            EventHomepage h = new EventHomepage();
            this.dispose();
        } else if (e.getSource() == bt4) {
            new AdminLogin().setVisible(true); 
            this.dispose();
        }
    }
}