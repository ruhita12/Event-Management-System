import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class N_amnt extends JFrame{
        N_amnt(){
            setTitle("NAGAD");
            setSize(400,700);
            setLocationRelativeTo(null);

            ImageIcon i = new ImageIcon(getClass().getResource("nagad.paym.jpg"));
            Image i1 = i.getImage();

            Image scaledImage = i1.getScaledInstance(400,680, Image.SCALE_SMOOTH);
            i1 = new ImageIcon(scaledImage).getImage();

            JLabel l = new JLabel(new ImageIcon(i1));

            JLabel l1 = new JLabel();
            l1.setBounds(100,430,200,30);
            l1.setText("Enter The Amount");
            l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
            l1.setForeground(Color.lightGray);

            JTextField t = new JTextField();
            t.setBounds(45, 460, 300, 30);
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
                    N_otp d = new N_otp();
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
                    JOptionPane.showMessageDialog(null,"PAYMENT COMPLETE!");
                    JOptionPane.showMessageDialog(null,"Please press submit button");
                    Disn d = new Disn();
                    dispose();
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
