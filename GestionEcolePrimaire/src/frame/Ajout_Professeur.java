package frame;

import java.awt.Color;
import java.awt.Font;
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

public class Ajout_Professeur extends JFrame implements ActionListener {
	
	JTextField txtnom,txtprenom;
	JButton bten,supp,modif,rech,fer,ann;
	Statement st;
	
	
	Conn k=new Conn();
	
	public Ajout_Professeur()
	{ 
	  this.setTitle("Enregistrement_prof");
	  this.setSize(400,300);
	  this.setLocation(500, 200);
	  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnom=new JLabel("Nom du professeur :");
     JLabel lbprenom=new JLabel("Prenom du professeur :");
     
     
     txtprenom=new JTextField();
     txtnom=new JTextField();
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     bten.addActionListener(this);
     ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("Serif",0,15);
     
     /*supp=new JButton("Supprimer");
     
     modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
     
     fer=new JButton("Terminez");
     
     
     
     supp.addActionListener(this);
     modif.addActionListener(this);
     rech.addActionListener(this);
     */
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
     
     lbnom.setBounds(30,70,120,25);  p.add(lbnom);  lbnom.setFont(fe);
      txtnom.setBounds(200,70,120,25);p.add(txtnom);
     
     lbprenom.setBounds(30,100,120,25);  p.add(lbprenom);  lbprenom.setFont(fe);
     txtprenom.setBounds(200,100,120,25);p.add(txtprenom);
     
      
    
     
     
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,180,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN);   bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,180,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	

  
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		if(e.getSource()==bten)
		{
			String n,p;
			p=txtprenom.getText(); 
			n=txtnom.getText();
			
			
			String query="Insert into professeur(prof_nom, prof_prenom) values('"+n+"','"+p+"')";
			
			
			
			
		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnom.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succ�s");
			 
			   txtnom.setText("");
			   txtprenom.setText("");
			 
			 }  else {JOptionPane.showMessageDialog (null,"veuillez remplire les champs !");}
			 
			
			 } catch (SQLException e1) {
		
			//e1.printStackTrace();
				JOptionPane.showMessageDialog(this,"errure d'ajout");
		}
	
		
		}
		
		//fermeture fenetre Enregistrement

		if(e.getSource()==ann)
		{
            //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
			//dispose();
		
		
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
			    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succ�s");
				
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
			JOptionPane.showMessageDialog(this,"Modifier avec succ�s");
			
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
	

/**
 * @param args
 */
public static void main(String[] args) {
	
	Ajout_Professeur f=new Ajout_Professeur();
	f.setVisible(true);
	
	

}
	
}
