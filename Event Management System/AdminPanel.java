import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminPanel extends JFrame {
    private DefaultTableModel tableModel;
    private JTable userTable;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private File userFile = new File("details.txt");
    
    public AdminPanel() {
        setTitle("Admin Panel");
        setSize(750, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setLayout(null);

        JPanel contentPane = new JPanel(null) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(224, 255, 255);
                Color color2 = new Color(251, 174, 210);
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(contentPane);

        ImageIcon icon = new ImageIcon("E:\\versity\\Java FInal Term\\Project\\tttt.jpg");
        this.setIconImage(icon.getImage());

        JLabel titleLabel = new JLabel("Admin's Territory");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setBounds(270, 10, 400, 50);
        contentPane.add(titleLabel);

        addLabel(contentPane, "Name:", 200, 70);
        nameField = addTextField(contentPane, 350, 70);

        addLabel(contentPane, "Password:", 200, 130);
        passwordField = new JPasswordField();
        passwordField.setBounds(350, 130, 200, 30);
        contentPane.add(passwordField);

        addLabel(contentPane, "Email:", 200, 190);
        emailField = addTextField(contentPane, 350, 190);

        JButton addButton = addButton(contentPane, "Add", 150, 260);
        addButton.addActionListener(e -> addUser());

        JButton updateButton = addButton(contentPane, "Update", 375, 260);
        updateButton.addActionListener(e -> updateUser());

        tableModel = new DefaultTableModel(new String[]{"Name", "Password", "Email"}, 0);
        userTable = new JTable(tableModel);
        userTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(50, 320, 650, 150);
        contentPane.add(scrollPane);

        userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = userTable.getSelectedRow();
                    if (selectedRow != -1) {
                        nameField.setText((String) tableModel.getValueAt(selectedRow, 0));
                        passwordField.setText((String) tableModel.getValueAt(selectedRow, 1));
                        emailField.setText((String) tableModel.getValueAt(selectedRow, 2));
                    }
                }
            }
        });

        JButton deleteButton = addButton(contentPane, "Delete", 160, 500);
        deleteButton.addActionListener(e -> deleteUser());
        
        JButton backButton = addButton(contentPane, "Back", 430, 500);
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });

        loadUserDetails();
        setVisible(true);
    }

    private void addLabel(JPanel panel, String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 30);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        panel.add(label);
    }

    private JTextField addTextField(JPanel panel, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        panel.add(textField);
        return textField;
    }

    private JButton addButton(JPanel panel, String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 200, 40);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setBackground(new Color(251, 174, 210));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(button);
        return button;
    }

    private void addUser() {
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email must be a @gmail.com address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
            writer.write(username + "," + password + "," + email);
            writer.newLine();
            tableModel.addRow(new Object[]{username, password, email});
            JOptionPane.showMessageDialog(this, "User added successfully!");
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to update!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String originalName = (String) tableModel.getValueAt(selectedRow, 0);
        String originalPassword = (String) tableModel.getValueAt(selectedRow, 1);
        String originalEmail = (String) tableModel.getValueAt(selectedRow, 2);

        String newName = nameField.getText();
        String newPassword = new String(passwordField.getPassword());
        String newEmail = emailField.getText();

        if (newName.isEmpty() || newPassword.isEmpty() || newEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newEmail.contains("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email must be a @gmail.com address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.setValueAt(newName, selectedRow, 0);
        tableModel.setValueAt(newPassword, selectedRow, 1);
        tableModel.setValueAt(newEmail, selectedRow, 2);

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(originalName + "," + originalPassword + "," + originalEmail)) {
                    line = newName + "," + newPassword + "," + newEmail;
                }
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "User updated successfully!");
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUser() {
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nameToDelete = tableModel.getValueAt(selectedRow, 0).toString();
        String passwordToDelete = tableModel.getValueAt(selectedRow, 1).toString();
        String emailToDelete = tableModel.getValueAt(selectedRow, 2).toString();

        List<String> updatedUsers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(nameToDelete + "," + passwordToDelete + "," + emailToDelete)) {
                    updatedUsers.add(line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading user data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            for (String user : updatedUsers) {
                writer.write(user);
                writer.newLine();
            }
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "User deleted successfully!");
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadUserDetails() {
        if (!userFile.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    tableModel.addRow(new Object[]{userData[0], userData[1], userData[2]});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading user data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void clearFields() {
        nameField.setText("");
        passwordField.setText("");
        emailField.setText("");
    }
}