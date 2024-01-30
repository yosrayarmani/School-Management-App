package frame;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connect.connection;

public class Fen_ajout_cours extends JFrame implements ActionListener {
	
	JTextField txtnom;
	JButton bten,supp,modif,rech,fer,ann;
	Statement st;
	
	
	connection k=new connection();
	
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
     
     
      
    
     
     
    bten.setBounds(50,180,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN);   bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,180,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
    		
     
     add(p); 
       
		
		
	}
	
	
@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		if(e.getSource()==bten)
		{
			String nu,pd,d,n,p,a1; 
			n=txtnom.getText();
			
			
			String query="Insert into matiere(mat_nom) values('"+n+"')";
			
			
		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnom.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succès");
			 
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
	}
		  
		/*else 
		   {
			   
		   }
			   
		
		
	              // suppression
		if(e.getSource()==supp)
		{
			String n;
			n=txtnom.getText(); 
			
		String query="DELETE FROM db WHERE nom='"+n+"'";
		
		
			
		try {
			 st=k.etablirconnection().createStatement();
			 
			 if(JOptionPane.showConfirmDialog(this,"Voulez Vous vraiment Supprimez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION & (n==txtnom.getText()))
				 
			 {   st.executeUpdate(query);
			    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succès");
				
			}  
			 
		
				 
		}
			 
	  catch (SQLException e2) {
			   JOptionPane.showMessageDialog(null, "Erreur de suppresion");
		
			
			}
			
       	
	
		}
		
		
		//Modification
		if(e.getSource()==modif)
		{
			String n,p,a;
			n=txtnom.getText(); 
			p=txtpren.getText();
			a=txtage.getText();
			
			String query="UPDATE  db  SET  prenom='"+p+"', age="+a+"  where  nom='"+n+"'";
			
			
		try {
			st=	k.etablirconnection().createStatement();
			
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(this,"Modifier avec succès");
			
			System.out.println("Enregistrement Succeful");
			
			
			
			} catch (SQLException e1) {
		
			 JOptionPane.showMessageDialog(this,"Vous Devez remplir les champs");
				
		}
	
		
		}
		
		//recherche
		if(e.getSource()==rech)
		{ String n;
			n=txtrec.getText(); 
			
   String query="SELECT * FROM db  WHERE nom='"+n+"'";
			
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{
				txtnom.setText(rst.getString("nom"));
				txtpren.setText(rst.getString("prenom"));
				txtage.setText(String.valueOf(rst.getInt("age")));
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	
	
	*/
	

public static void main(String[] args) {
	
	Fen_ajout_cours f=new Fen_ajout_cours();
	f.setVisible(true);
	
	

}
	
}
