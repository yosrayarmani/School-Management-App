package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import connect.Conn;

public class Fen_ajout_cours extends JFrame implements ActionListener {
	
	JTextField txtnom;
	JButton bten,supp,modif,rech,fer,ann;
	Statement st;
	
	
	Conn k=new Conn();
	
	public Fen_ajout_cours()
	{ 
	  this.setTitle("Cours");
	  this.setSize(400,300);
  
     
      this.setLocation(500, 200);
  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnom=new JLabel("Nom du cours");
     
     
     txtnom=new JTextField();
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Annuler");
     
     bten.addActionListener(this);
     ann.addActionListener(this);
     
     
     Font fe=new Font("Serif",0,15);
     
     lbnom.setBounds(30,70,120,25);  p.add(lbnom);  lbnom.setFont(fe);
      txtnom.setBounds(200,70,120,25);p.add(txtnom);
     
     
      
    
     
     
    bten.setBounds(50,180,120,27); 
		p.add(bten); 
		bten.setFont(fe); 
		bten.setBackground(Color.CYAN);   
		bten.setIcon(new ImageIcon("images1\\save.png"));


		ImageIcon originalIcon = new ImageIcon("images1\\close.png");
		Image resizedImage = originalIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ann.setIcon(new ImageIcon(resizedImage));

    ann.setBounds(200,180,120,27); 
		p.add(ann);  
		ann.setFont(fe);  
		ann.setBackground(Color.CYAN);
    add(p);
	}
	
	
@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		if(e.getSource()==bten)
		{
			String n; 
			n=txtnom.getText();
			String query="Insert into matiere(mat_nom) values('"+n+"')";

		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnom.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succ�s");
			 
			   txtnom.setText("");	
			 
			 
			 
			 }  else {JOptionPane.showMessageDialog (null,"veuillez remplire les champs !");}
			 
			 } catch (SQLException e1) {
		
			e1.printStackTrace();
				JOptionPane.showMessageDialog(this,"errure d'ajout");
		}
		}

		if(e.getSource()==ann)
		{
		   if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		   {
			   dispose();
		   }
		}
	}public static void main(String[] args) {
	
	Fen_ajout_cours f=new Fen_ajout_cours();
	f.setVisible(true);
}
	
}
