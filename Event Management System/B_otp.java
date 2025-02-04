import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class B_otp extends JFrame {
    B_otp(){
        setTitle("BKASH");
        setSize(600,600);
        setLocationRelativeTo(null);
        ImageIcon o = new ImageIcon(getClass().getResource("bkash.paym.jpg"));
        Image o1 = o.getImage();

        Image ScaledImage = o1.getScaledInstance(600,600, Image.SCALE_SMOOTH);
        o1 = new ImageIcon(ScaledImage).getImage();

        JLabel l = new JLabel(new ImageIcon(o1));

        JLabel l1 = new JLabel();
        l1.setText("Enter the OTP ");
        l1.setBounds(220,300,400,60);
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        l1.setForeground(new Color(255,255,255));

        JPasswordField tb = new JPasswordField();
        tb.setBounds(140,350,300,40);
        tb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        tb.setHorizontalAlignment(SwingConstants.CENTER);

        JButton b = new JButton();
        b.setBackground(Color.lightGray);
        b.setText("BACK");
        b.setBounds(00,503,300,60);
        b.setFocusable(false);
        b.setFont(new Font("Times New Roman", Font.BOLD, 20 ));

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Bkash d = new Bkash();
                dispose();
            }
        });
        JButton b1 = new JButton();
        b1.setBounds(299,503,301,60);
        b1.setBackground(Color.lightGray);
        b1.setText("CONFIRM");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setFocusable(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                B_amnt o = new B_amnt();
                dispose();
            }
        });
        add(l);
        l.add(l1);
        l.add(tb);
        l.add(b);
        l.add(b1);
        setVisible(true);
    }
}
