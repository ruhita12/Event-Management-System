import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nagad extends JFrame {
    Nagad (){
        setTitle("NAGAD");
        setSize(400,700);
        setLocationRelativeTo(null);

        ImageIcon i = new ImageIcon(getClass().getResource("nagad.paym.jpg"));
        Image i1 = i.getImage();

        Image scaledImage = i1.getScaledInstance(400,680, Image.SCALE_SMOOTH);
        i1 = new ImageIcon(scaledImage).getImage();

        JLabel l = new JLabel(new ImageIcon(i1));

        JLabel l1 = new JLabel();
        l1.setBounds(60,430,350,30);
        l1.setText("Your Nagad Account Number");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l1.setForeground(Color.lightGray);

        JTextField t = new JTextField();
        t.setBounds(30, 460, 320, 30);
        t.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        t.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel l2 = new JLabel();
        l2.setText("By Clicking CONFIRM you are procedding......");
        l2.setBounds(20,500,350,30);
        l2.setForeground(Color.lightGray);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 15));

        JButton b = new JButton();
        b.setText("BACK");
        b.setBounds(0,615,200,50);
        b.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b.setBackground(Color.lightGray);
        b.setFocusable(false);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Disn d = new Disn();
                dispose();
            }
        });
        JButton b1 = new JButton();
        b1.setText("CONFIRM");
        b1.setBounds(199,615,201,50);
        b1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        b1.setFocusable(false);
        b1.setBackground(Color.lightGray);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                N_otp n1 = new N_otp();
            }
        });
         add(l);
         l.add(l1);
         l.add(l2);
         l.add(t);
         l.add(b);
         l.add(b1);
        setVisible(true);

    }
}
