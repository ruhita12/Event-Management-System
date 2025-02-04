import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Welcome extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JPanel panel;
    private JButton bt1, bt2; 
    private Font f1;
    private ImageIcon img1;

    public Welcome() {
        super("Event Management System");
        this.setSize(900, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);

        label1 = new JLabel("WELCOME TO EVENTURE");
        label1.setBounds(200, 100, 600, 50);
        label1.setForeground(new Color(54,1,63));
        f1 = new Font("Algerian", Font.BOLD, 40);
        label1.setFont(f1);
        panel.add(label1);

        label2 = new JLabel("where every event becomes an adventure");
        label2.setBounds(270, 130, 400, 60);
        label2.setForeground(Color.decode("#602c66"));
        f1 = new Font("Arial Black", Font.BOLD, 15);
        label2.setFont(f1);
        panel.add(label2);

        bt1 = new JButton("Continue");
        bt1.setBounds(700, 500, 130, 40);
        bt1.setFocusable(false);
        bt1.setForeground(Color.BLACK);
        bt1.setBackground(Color.ORANGE);
        bt1.addActionListener(this);
        panel.add(bt1);
        
        bt2 = new JButton("Ongoing Offers");
        bt2.setBounds(700, 20, 130, 30); 
        bt2.setFocusable(false);
        bt2.setForeground(Color.BLACK);
        bt2.setBackground(Color.ORANGE);
        bt2.addActionListener(this);
        panel.add(bt2);
		
		img1 = new ImageIcon("welcome.png");
        label3 = new JLabel(img1);
        label3.setBounds(0, 0, 900, 650);
        panel.add(label3);


        this.add(panel);
        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bt1) {
        new Login().setVisible(true);
        this.dispose();
    } else if (e.getSource() == bt2) {  
        new Offer().setVisible(true); 
    }
}
}
   