package Gestion;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.Date;

import connect.connection;

public class ges_eleve extends JFrame implements ActionListener {
	
	JTextField txtnom,txtprenom,txtnum;
	JButton btModif,supp,rech,fer,ann;
	Statement st;
	connection k=new connection();
	
	public ges_eleve()
	{ 
	  this.setTitle("Gestion ");
	  this.setSize(400,350);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnum=new JLabel("Numero d'elève");
     JLabel lbnom=new JLabel("Nom d'elève");
     JLabel lbpren=new JLabel("Prenom d'èlève");
     JLabel lbT=new JLabel("AJout D'un Nouveau Eleve");
     
     txtnum=new JTextField();
     txtnom=new JTextField();
     txtprenom=new JTextField();
     btModif=new JButton("Modifiez");
     ann=new JButton("Terminer"); 
     
     btModif.addActionListener(this);
     ann.addActionListener(this);      
     
     
     //boutton
     Font fe=new Font("gramound",0,15);
     
     supp=new JButton("Supprimer");
     
     rech=new JButton("Rechercher");
     
     fer=new JButton("Terminez");
     
     
     
     supp.addActionListener(this);
     rech.addActionListener(this);
     
     lbnum.setBounds(30,40,120,25);  p.add(lbnum);  lbnum.setFont(fe);
     txtnum.setBounds(200,40,120,25);p.add(txtnum);
     
     lbnom.setBounds(30,70,120,25);  p.add(lbnom);  lbnom.setFont(fe);
      txtnom.setBounds(200,70,120,25);p.add(txtnom);
     
     lbpren.setBounds(30,100,120,25);  p.add(lbpren);  lbpren.setFont(fe);
     txtprenom.setBounds(200,100,120,25);p.add(txtprenom);
     
     
    //ajout buttons
     
    btModif.setBounds(50,230,130,27); p.add(btModif); btModif.setFont(fe); btModif.setBackground(Color.CYAN); 
    ann.setBounds(50,270,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
    	
     rech.setBounds(50,5,130,25);  p.add(rech);
    supp.setBounds(200,230,130,25); p.add(supp); supp.setBackground(Color.cyan);
    
     
     add(p); 
       
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			if(e.getSource()==ann)
			{
			
			   if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			   {
				   dispose();
			   }
			}
	
//------------------------- DELETE ----------------------------------------
			
		if(e.getSource()==supp)
		{
			String n,p;
			n=txtnom.getText(); 
			p=txtprenom.getText(); 
		String query="DELETE FROM eleve WHERE elv_nom='"+n+"' AND elv_prenom='"+p+"'";
		
		try {
			 st=k.etablirconnection().createStatement();
			 
			 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment supprimez ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
			 {
			    st.executeUpdate(query);
			    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succès");
			 } 
			 else if (JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
				}
				
			 }
			   
		
	     catch (SQLException e2) {
			   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
		
			
			}
			
       	}
		
		
//---------------- UPDATE ------------------------------------------
		if(e.getSource()==btModif)
		{
			String n,p,num;
			
			n=txtnom.getText();
			p=txtprenom.getText();
			num=txtnum.getText();
			
			String query="UPDATE  eleve  SET elv_nom='"+n+"', elv_prenom='"+p+"' where  elv_id="+num+"";
			
			
			try {
				 st=k.etablirconnection().createStatement();
				 
				 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment Modifiez ? ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
				 {
				    st.executeUpdate(query);
				    JOptionPane.showMessageDialog(this,"Modification effectuez avec succès");
				 } 
				 else if (JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
					}
			}
			 catch (SQLException e2) {
				   JOptionPane.showMessageDialog(null, "Erreur verifiez le lien ou n'existe pas");
				   e2.printStackTrace();
			
				
				}
					}
				 
				   
		
//------------------- SEARCH -------------------------------------------------
		if(e.getSource()==rech)
		{ String num;
		num=txtnum.getText();
   String query="SELECT * FROM eleve  WHERE num_elv='"+num+"'";
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{   
				txtnom.setText(rst.getString("elv_nom"));
				txtprenom.setText(rst.getString("elv_prenom"));
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	

	
}
