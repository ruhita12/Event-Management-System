import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disn extends JFrame{
        Disn(){
            setSize(800,700);
            setLayout(null);
            setLocationRelativeTo(null);

            setTitle("PAYMANET PLANE");

            JLabel l = new JLabel();
            l.setText(" MAKE PAYMENT ");
            l.setBounds(190,20,415,40);
            l.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 45));

            JLabel l1 = new JLabel();
            l1.setText("MOBILE BANKING: ");
            l1.setBounds(25,100,500,50);
            l1.setFont(new Font("Arial Narrow", Font.BOLD, 30));

            ImageIcon img = new ImageIcon(getClass().getResource("Bkash-Logo.png"));
            Image i = img.getImage();

            Image scaledImage = i.getScaledInstance(130, 60, Image.SCALE_SMOOTH);
            i = new ImageIcon(scaledImage).getImage();

            JButton b = new JButton();
            b.setBounds(50,160,200,55);
            b.setIcon(new ImageIcon(i));
            b.setFocusable(false);
            b.setBackground(new Color(225, 192, 203));

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Bkash b = new Bkash();
                    dispose();
                }
            });
            ImageIcon img1 = new ImageIcon(getClass().getResource("n.gad.png"));
            Image i1 = img1.getImage();

            Image scaledImage1 = i1.getScaledInstance(130, 50, Image.SCALE_AREA_AVERAGING);
            i1 = new ImageIcon(scaledImage1).getImage();

            JButton b1 = new JButton();
            b1.setBounds(275,160,200,55);
            b1.setFocusable(false);
            b1.setIcon(new ImageIcon(i1));
            b1.setBackground(new Color(250, 200, 152));

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Nagad n = new Nagad();
                    dispose();
                }
            });

            ImageIcon img2 = new ImageIcon(getClass().getResource("r.oket.jpg"));
            Image i2 = img2.getImage();
            Image scaledImage2 = i2.getScaledInstance(150, 60, Image.SCALE_AREA_AVERAGING);
            i2 = new ImageIcon(scaledImage2).getImage();

            JButton b2 = new JButton();
            b2.setBounds(500,160,200,55);
            b2.setFocusable(false);
            b2.setIcon(new ImageIcon(i2));
            b2.setBackground(new Color(137,40,143,255));

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Rocket r = new Rocket();
                    dispose();
                }
            });
            JLabel l2 = new JLabel();
            l2.setText("PAY WITH CARD: ");
            l2.setBounds(30,250,250,40);
            l2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));

            ImageIcon img3 = new ImageIcon(getClass().getResource("crd.jpg"));
            Image i3 = img3.getImage();

            Image scaledImage3 = i3.getScaledInstance(300, 60, Image.SCALE_AREA_AVERAGING);
            i3 = new ImageIcon(scaledImage3).getImage();

            JLabel l3 = new JLabel();
            l3.setBounds(250,245,300,50);
            l3.setFocusable(false);
            l3.setIcon(new ImageIcon(i3));

            JLabel ln = new JLabel();
            ln.setText("First name");
            ln.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
            ln.setBounds(30,330,300, 25);

            JLabel ln1 = new JLabel();
            ln1.setText("Last name");
            ln1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
            ln1.setBounds(400,330,400, 25);

            JTextField tn1 = new JTextField();
            tn1.setBounds(400,360,370,40);
            tn1.setFont(new Font("Arial ", Font.BOLD,20 ));

            JTextField tn = new JTextField();
            tn.setBounds(30,360,350,40);
            tn.setFont(new Font("Arial ", Font.BOLD,20 ));

            JLabel l4 = new JLabel();
            l4.setText("Card no. ");
            l4.setBounds(30,400,300,50);
            l4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));

            JTextField t = new JTextField();
            t.setBounds(30,440,500,40);
            t.setFont(new Font("Arial ", Font.BOLD,20 ));

            JLabel l5 = new JLabel();
            l5.setText("MM/YY ");
            l5.setBounds(30,480,380,50);
            l5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));

            JTextField t1 = new JTextField();
            t1.setBounds(30,520,350,40);
            t1.setFont(new Font("Arial ", Font.BOLD,20 ));

            JLabel l6 = new JLabel();
            l6.setText("CVV ");
            l6.setBounds(400,480,400,50);
            l6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));

            JTextField t2 = new JTextField();
            t2.setBounds(400,520,370,40);
            t2.setFont(new Font("Arial ", Font.BOLD,20 ));

            ImageIcon img4 = new ImageIcon(getClass().getResource("submit.png"));
            Image i4 = img4.getImage();

            Image scaledImage4 = i4.getScaledInstance(60,55, Image.SCALE_AREA_AVERAGING);
            i4 = new ImageIcon(scaledImage4).getImage();

            JButton b3 = new JButton();
            b3.setText("SUBMIT");
            b3.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
            b3.setBounds(500, 590, 200, 55);
            b3.setFocusable(false);
            //b3.setForeground(new Color(00,00,00));
           // b3.setBackground(new Color(160,160,160));
            b3.setIcon(new ImageIcon(i4));

            JButton bb = new JButton();
            bb.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
            bb.setBounds(100,590,200,55);
            bb.setText("BACK");
            bb.setIcon(new ImageIcon(i4));
            bb.setFocusable(false);

            bb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EventHomepage ev = new EventHomepage();
                }
            });

            b3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,"THANK YOU FOR YOUR PAYMENT.");
                    Thnx t = new Thnx();
                    dispose();
                }
            });
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            add(l);
            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
            add(l6);
            add(ln);
            add(ln1);
            add(t);
            add(t1);
            add(t2);
            add(tn);
            add(tn1);
            add(b);
            add(b1);
            add(b2);
            add(b3);
            add(bb);
            setVisible(true);
        }
}