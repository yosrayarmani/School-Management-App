package frame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jlabel extends JFrame {

	public Jlabel()
	{    this.setResizable(false);
		 this.setTitle("ABOUT");
		 this.setSize(400,300);
		 JPanel p=new JPanel();
		  
		  p.setLayout(null);
	
		 
		  Font fer = new Font("BOLD",0, 16);
		  
		  this.setLocation(500, 200);
		  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         
      JLabel ch1=new JLabel("Mini_Projet realisé par:"); ch1.setBounds(40, 10, 180,  20); p.add(ch1); ch1.setForeground(Color.black);
	  JLabel ch2=new JLabel("  Yarmani Yosra  ");      ch2.setFont(fer); ch2.setBounds(40, 40, 400,  20);   p.add(ch2);
	  JLabel ch3=new JLabel("Classe :   L2CS1  ");  ch3.setFont(fer);     ch3.setBounds(40, 60, 400,  20);   p.add(ch3);
	 
	  add(p);
	  
}

}






