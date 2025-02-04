import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class R_amnt extends JFrame {
    R_amnt(){

        setSize(450,600);
        setTitle("ROCKET");
        setLocationRelativeTo(null);

        ImageIcon i = new ImageIcon(getClass().getResource("rocket.paym.jpg"));
        Image i1 = i.getImage();

        Image scaledImage = i1.getScaledInstance(450,580, Image.SCALE_SMOOTH);
        i1= new ImageIcon(scaledImage).getImage();

        JLabel l = new JLabel(new ImageIcon(i1));

        JLabel rk1 = new JLabel();
        rk1.setText("Enter the Amount");
        rk1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rk1.setBounds(130,325,380,40);
        rk1.setForeground(Color.lightGray);

        JTextField tr = new JTextField();
        tr.setBounds(80,360,250,30);
        tr.setFont(new Font("Arial Rounded MT Bold" , Font.PLAIN, 20));
        tr.setHorizontalAlignment(SwingConstants.CENTER);


        JLabel rk2 = new JLabel();
        rk2.setBounds(25,420,400,40);
        rk2.setText("By Clicking CONFIRM you are procedding....");
        rk2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        rk2.setForeground(Color.lightGray
        );
        JButton br = new JButton();
        br.setText("BACK");
        br.setFont(new Font("Times New Roman", Font.BOLD, 20 ));
        br.setBounds(0,515,225,50);
        br.setFocusable(false);
        br.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                R_otp d = new R_otp();
                dispose();
            }
        });
        JButton br1 = new JButton();
        br1.setText("CONFIRM");
        br1.setFont(new Font("Times New Roman", Font.BOLD, 20 ));
        br1.setBounds(224,515,225,50);
        br1.setFocusable(false);
        br1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "PAYMENT COMPLETE!");
                JOptionPane.showMessageDialog(null,"Please press submit button");
                Disn d = new Disn();
            }
        });
        add (l);
        l.add(rk1);
        l.add(rk2);
        l.add(tr);
        l.add(br1);
        l.add(br);
        setVisible(true);
    }
}
