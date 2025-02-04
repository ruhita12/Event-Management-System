import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bkash extends JFrame {
    Bkash(){
        setTitle("BKASH");
        setSize(600,600);
        setLocationRelativeTo(null);

        ImageIcon bk = new ImageIcon(getClass().getResource("bkash.paym.jpg"));
        Image bk1 =bk.getImage();

        Image scaledImage4 = bk1.getScaledInstance(600,580, Image.SCALE_SMOOTH);
        bk1= new ImageIcon(scaledImage4).getImage();

        JLabel l = new JLabel(new ImageIcon(bk1));

        JLabel l1 = new JLabel();
        l1.setText("Your Bkash Account number ");
        l1.setBounds(150,300,400,60);
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        l1.setForeground(new Color(255,255,255));

        JTextField tb = new JTextField();
        tb.setBounds(50,350,490,40);
        tb.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
        tb.setHorizontalAlignment(SwingConstants.CENTER);

        JButton b = new JButton();
        b.setBackground(Color.lightGray);
        b.setText("BACK");
        b.setBounds(00,495,300,60);
        b.setFocusable(false);
        b.setFont(new Font("Times New Roman", Font.BOLD, 20 ));

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Disn d = new Disn();
                dispose();
            }
        });
        JButton b1 = new JButton();
        b1.setBounds(299,495,301,60);
        b1.setBackground(Color.lightGray);
        b1.setText("CONFIRM");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setFocusable(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                B_otp o = new B_otp();
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
