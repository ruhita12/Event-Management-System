import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class EventHomepage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField tfCapacity, tfDate, tfDirections;
    private JComboBox<String> cbFoodType, jb;
    private JButton btSubmit, btShow, btExit;
    private JRadioButton indoorRadio, outdoorRadio;

    public EventHomepage() {
        super("Event Management System");
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 216, 230));

        label1 = new JLabel("Pick your event type to begin!");
        label1.setBounds(200, 20, 400, 50);
        label1.setFont(new Font("Cambria", Font.BOLD, 24));
        label1.setForeground(Color.BLUE);
        panel.add(label1);

        label2 = new JLabel("Event Type:");
        label2.setBounds(50, 100, 100, 30);
        panel.add(label2);

        String[] eventTypes = {" ", "Birthday", "Wedding", "Anniversary", "Corporate", "Concert"};
        jb = new JComboBox<>(eventTypes);
        jb.setBounds(200, 100, 200, 30);
        jb.setBackground(new Color(16, 108, 115));
        jb.setForeground(Color.WHITE);
        jb.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(jb);

        label3 = new JLabel("Venue Type:");
        label3.setBounds(50, 150, 100, 30);
        panel.add(label3);

        JPanel venuePanel = new JPanel();
        venuePanel.setBounds(200, 150, 200, 30);
        venuePanel.setLayout(new FlowLayout());
        venuePanel.setBackground(new Color(173, 216, 230)); 

        indoorRadio = new JRadioButton("Indoor");
        indoorRadio.setSelected(true);
        indoorRadio.setBackground(new Color(16, 108, 115));
        indoorRadio.setForeground(Color.WHITE);
        indoorRadio.setOpaque(true);
        indoorRadio.setBorderPainted(false);

        outdoorRadio = new JRadioButton("Outdoor");
        outdoorRadio.setBackground(new Color(16, 108, 115));
        outdoorRadio.setForeground(Color.WHITE);
        outdoorRadio.setOpaque(true);
        outdoorRadio.setBorderPainted(false);

        ButtonGroup venueGroup = new ButtonGroup();
        venueGroup.add(indoorRadio);
        venueGroup.add(outdoorRadio);

        venuePanel.add(indoorRadio);
        venuePanel.add(outdoorRadio);
        panel.add(venuePanel);

        label4 = new JLabel("Capacity:");
        label4.setBounds(50, 200, 100, 30);
        panel.add(label4);

        tfCapacity = new JTextField();
        tfCapacity.setBounds(200, 200, 200, 30);
        tfCapacity.setBackground(new Color(16, 108, 115));
        tfCapacity.setForeground(Color.WHITE);
        panel.add(tfCapacity);

        label5 = new JLabel("Date:");
        label5.setBounds(50, 250, 100, 30);
        panel.add(label5);

        tfDate = new JTextField();
        tfDate.setBounds(200, 250, 200, 30);
        tfDate.setBackground(new Color(16, 108, 115));
        tfDate.setForeground(Color.WHITE);
        panel.add(tfDate);

        label6 = new JLabel("Food Type:");
        label6.setBounds(50, 300, 100, 30);
        panel.add(label6);

        String[] foodTypes = {" ", "Traditional", "Chinese", "Indian Cuisine", "Buffet"};
        cbFoodType = new JComboBox<>(foodTypes);
        cbFoodType.setBounds(200, 300, 200, 30);
        cbFoodType.setBackground(new Color(16, 108, 115));
        cbFoodType.setForeground(Color.WHITE);
        panel.add(cbFoodType);

        label7 = new JLabel("Directions:");
        label7.setBounds(50, 350, 100, 30);
        panel.add(label7);

        tfDirections = new JTextField();
        tfDirections.setBounds(200, 350, 200, 30);
        tfDirections.setBackground(new Color(16, 108, 115));
        tfDirections.setForeground(Color.WHITE);
        panel.add(tfDirections);

        btSubmit = new JButton("Submit");
        btSubmit.setBounds(50, 400, 100, 30);
        btSubmit.setBackground(new Color(16, 108, 115));
        btSubmit.setForeground(Color.WHITE);
        btSubmit.addActionListener(this);
        panel.add(btSubmit);

        btShow = new JButton("Show");
        btShow.setBounds(200, 400, 100, 30);
        btShow.setBackground(new Color(16, 108, 115));
        btShow.setForeground(Color.WHITE);
        btShow.addActionListener(this);
        panel.add(btShow);

        btExit = new JButton("Exit");
        btExit.setBounds(350, 400, 100, 30);
        btExit.setBackground(new Color(16, 108, 115));
        btExit.setForeground(Color.WHITE);
        btExit.addActionListener(this);
        panel.add(btExit);
        super.add(panel);
        setVisible(true);
    }
public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSubmit) {
            String capacity = tfCapacity.getText();
            try {
                int cap = Integer.parseInt(capacity);
                if (cap < 250 || cap > 2000) {
                    JOptionPane.showMessageDialog(this, "Capacity must be between 250 and 2000.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacity must be an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            String date = tfDate.getText();
            if (!isValidDate(date)) {
                JOptionPane.showMessageDialog(this, "Date must be in DD/MM/YYYY format.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            String eventType = (String) jb.getSelectedItem();
            String venueType = indoorRadio.isSelected() ? "Indoor" : "Outdoor";
            String foodType = (String) cbFoodType.getSelectedItem();
            String directions = tfDirections.getText();

            JOptionPane.showMessageDialog(this, "Event Submitted Successfully!");

            SwingUtilities.invokeLater(() -> {
                new Calculation(eventType, venueType, capacity, date, foodType, directions);
                this.dispose();  
            });
        } else if (e.getSource() == btShow) {
            String eventType = (String) jb.getSelectedItem();
            String venueType = indoorRadio.isSelected() ? "Indoor" : "Outdoor";
            String capacity = tfCapacity.getText();
            String date = tfDate.getText();
            String foodType = (String) cbFoodType.getSelectedItem();
            String directions = tfDirections.getText();
            new EventDetails(eventType, venueType, capacity, date, foodType, directions);
        } else if (e.getSource() == btExit) {
            this.dispose();
            new Login().setVisible(true);
        }
    }
    private boolean isValidDate(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    class EventDetails extends JFrame {
        public EventDetails(String eventType, String venueType, String capacity, String date, String foodType,
                            String directions) {
            super("Event Details");
            setBounds(600, 200, 400, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    EventHomepage.this.setVisible(true);
                }
            });
            JPanel panel = new JPanel(new GridLayout(6, 2));
            panel.add(new JLabel("Event Type:"));
            panel.add(new JLabel(eventType));
            panel.add(new JLabel("Venue Type:"));
            panel.add(new JLabel(venueType));
            panel.add(new JLabel("Capacity:"));
            panel.add(new JLabel(capacity));
            panel.add(new JLabel("Date:"));
            panel.add(new JLabel(date));
            panel.add(new JLabel("Food Type:"));
            panel.add(new JLabel(foodType));
            panel.add(new JLabel("Directions:"));
            panel.add(new JLabel(directions));
            add(panel);
            setVisible(true);
        }
    }

    class Calculation extends JFrame implements ActionListener {
        private JLabel totalCostLabel;
        private JButton goForPaymentButton;

        public Calculation(String eventType, String venueType, String capacity, String date, String foodType, String directions) {
            super("Calculation");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(7, 2));
            panel.add(new JLabel("Event Type:"));
            panel.add(new JLabel(eventType));
            panel.add(new JLabel("Venue Type:"));
            panel.add(new JLabel(venueType));
            panel.add(new JLabel("Capacity:"));
            panel.add(new JLabel(capacity));
            panel.add(new JLabel("Date:"));
            panel.add(new JLabel(date));
            panel.add(new JLabel("Food Type:"));
            panel.add(new JLabel(foodType));
            panel.add(new JLabel("Directions:"));
            panel.add(new JLabel(directions));
			
            double totalCost = calculateTotalCost(eventType, venueType, capacity, foodType);
            totalCostLabel = new JLabel("Total Cost: $" + totalCost);
            panel.add(totalCostLabel);
            goForPaymentButton = new JButton("Go for Payment");
            goForPaymentButton.addActionListener(this);
			goForPaymentButton.setFocusable(false);
            panel.add(goForPaymentButton);
            add(panel);
            setVisible(true);
        }
        private double calculateTotalCost(String eventType, String venueType, String capacity, String foodType) {
            double cost = 0;
            switch (eventType) {
                case "Birthday":
                    cost += 500;
                    break;
                case "Wedding":
                    cost += 2000;
                    break;
                case "Anniversary":
                    cost += 1000;
                    break;
                case "Corporate":
                    cost += 1500;
                    break;
                case "Concert":
                    cost += 3000;
                    break;
            }
            if (venueType.equals("Indoor")) {
                cost += 300;
            } else if (venueType.equals("Outdoor")) {
                cost += 500;
            }
            int cap = Integer.parseInt(capacity);
            if (cap > 100) {
                cost += cap * 5;
            } else {
                cost += cap * 10;
            }
            switch (foodType) {
                case "Traditional":
                    cost += 200;
                    break;
                case "Chinese":
                    cost += 300;
                    break;
                case "Indian Cuisine":
                    cost += 400;
                    break;
                case "Buffet":
                    cost += 500;
                    break;
            }
            return cost;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == goForPaymentButton) {
                SwingUtilities.invokeLater(() -> {
                    new Disn();  
                    this.dispose(); 
                });
            }
        }
    }
}