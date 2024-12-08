package frame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Jlabel extends JFrame {

    public Jlabel() {
        this.setResizable(false);
        this.setTitle("ABOUT");
        this.setSize(800, 300);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(null);

        JLabel ch1 = new JLabel("Project By: YARMANI Yosra");
        ch1.setBounds(10, 10, 180, 20);
        ch1.setForeground(Color.BLACK);
        p.add(ch1);

        JLabel ch3 = new JLabel("Group : L2 CS1");
        ch3.setBounds(10, 30, 400, 20);
        ch3.setForeground(Color.BLACK);
        p.add(ch3);

        JTextArea ch4 = new JTextArea(
            "Desktop application designed to streamline administrative operations. Built using Java with a Swing GUI "
            + "and integrated with a PostgreSQL database, this application provides a centralized platform to manage key aspects "
            + "of school administration efficiently."
        );
        ch4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        ch4.setForeground(new Color(0, 0, 139));
        ch4.setLineWrap(true);
        ch4.setWrapStyleWord(true);
        ch4.setEditable(false);
        ch4.setOpaque(false);
        ch4.setBounds(10, 70, 600, 120);
        p.add(ch4);

        add(p);
    }
}
