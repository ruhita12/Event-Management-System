import javax.swing.*;
import java.awt.*;

public class Thnx extends JFrame {
    Thnx()
    {
        Dimension d= new Dimension(getToolkit().getScreenSize());
        int height =(int) d.getHeight();
        int width =(int) d.getWidth();
        setSize(500,520);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon bk = new ImageIcon(getClass().getResource("tnx.gif"));
        Image bk1 =bk.getImage();

        JLabel l = new JLabel(new ImageIcon(bk1));

        JLabel l1 = new JLabel();
        l1.setBounds(05,412,500,80);
        l1.setText("EVENTURE IS FOR YOUR DELIGHTS!!!");
        l1.setFont(new Font(" Showcard Gothic", Font.BOLD, 25));
        add(l);
        l.add(l1);
        setVisible(true);
    }
}
