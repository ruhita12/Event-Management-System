import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rocket extends JFrame {
     Rocket(){
        setSize(450,600);
        setTitle("Rocket");
        setLocationRelativeTo(null);

         ImageIcon r = new ImageIcon(getClass().getResource("rocket.paym.jpg"));
         Image r1 = r.getImage();

         Image scaledImage4 = r1.getScaledInstance(450,580, Image.SCALE_SMOOTH);
         r1 = new ImageIcon(scaledImage4).getImage();

         JLabel rk = new JLabel(new ImageIcon(r1));

         JLabel rk1 = new JLabel();
         rk1.setText("Your Rocket Account Number");
         rk1.setFont(new Font("Times New Roman", Font.BOLD, 20));
         rk1.setBounds(80,325,380,40);
         rk1.setForeground(Color.lightGray);

         JTextField tr = new JTextField();
         tr.setBounds(20,360,400,30);
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
                 Disn d = new Disn();
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
                 R_otp r = new R_otp();

         }
     });
         add(rk);
         rk.add(rk1);
         rk.add(rk2);
         rk.add(tr);
         rk.add(br1);
         rk.add(br);
        setVisible(true);
    }
}
