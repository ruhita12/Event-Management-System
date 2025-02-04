import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Offer extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton bt1;
	private JLabel label1, label2, label3, label4;
	private Font f1, f2, f3, f4;
    
    public Offer() {
        super("Ongoing Offers");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);
        
     
        Color purple = Color.decode("#602c66");
        
        

        label1 = new JLabel("Special Offers");
        label1.setBounds(160, 20, 300, 40);
        label1.setForeground(purple);
        panel.add(label1);
		f1 = new Font("Algerian", Font.BOLD, 30);
        label1.setFont(f1);

        label2 = new JLabel("1. 20% Off on Wedding Packages");
        label2.setBounds(50, 80, 300, 30);
        f2 = new Font("Algerian", Font.BOLD, 30);
        label1.setFont(f2);
        panel.add(label2);

        label3= new JLabel("2. Free Venue Decoration");
        label3.setBounds(50, 120, 300, 30);
        f3 = new Font("Algerian", Font.BOLD, 30);
        label1.setFont(f3);
        panel.add(label3);

        label4 = new JLabel("3. 15% Student Discount");
        label4.setBounds(50, 160, 300, 30);
        f4 = new Font("Algerian", Font.BOLD, 30);
        label1.setFont(f4);
        panel.add(label4);

        bt1 = new JButton("Back");
        bt1.setBounds(250, 300, 100, 30);
        bt1.setBackground(Color.YELLOW);
        bt1.setForeground(Color.BLACK);
        bt1.addActionListener(this);
        panel.add(bt1);

        this.add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            this.dispose(); 
        }
    }
}