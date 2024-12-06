package Gestion;

import java.awt.Color;

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


import connect.Conn;

public class Gestion_Prof extends JFrame implements ActionListener {
	
	JTextField txtnom,txtpren,txtdat,txtnum,txtsal,txtpd,txtrec;
	JButton btModif,supp,rech,fer,ann;
	Statement st;
	
	Conn k=new Conn();
	
	public Gestion_Prof()
	{ 
	  this.setTitle("");
	  this.setSize(400,350);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnum=new JLabel("Numero professeurs");
     JLabel lbnom=new JLabel("Nom");
     JLabel lbdt=new JLabel("date d'entree");  lbdt.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\calendar.png"));
     JLabel lbsal=new JLabel("salaire");
     /*JLabel lbann=new JLabel("annee");
     JLabel lbpd=new JLabel("poids");
     JLabel lbT=new JLabel("AJout D'un Nouveau Eleve");*/
     
     
     
     txtnum=new JTextField();
     txtnom=new JTextField();
     //txtpren=new JTextField();
     txtdat=new JTextField("");   
     txtsal=new JTextField();
    // txtpd=new JTextField("");
     txtrec=new JTextField(""); txtrec.setBackground(Color.WHITE);
     btModif=new JButton("Modifiez");
     ann=new JButton("Terminer");
     
     btModif.addActionListener(this);
     ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("gramound",0,15);
     
     supp=new JButton("Supprimer");
     supp.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\supp.png"));     supp.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\Originals\\supp.png"));
    // modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
     rech.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\Originals\\rech1.png"));
     
     fer=new JButton("Terminez");
     
     
     
     supp.addActionListener(this);
    // modif.addActionListener(this);
     rech.addActionListener(this);
     
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
    // lbT.setBounds(15,0,340,20); p.add(lbT);
     
     
      lbnum.setBounds(30,80,110,25);  p.add(lbnum);  lbnum.setFont(fe);
     txtnum.setBounds(200,80,120,25);p.add(txtnum);
     
     lbnom.setBounds(30,120,120,25);  p.add(lbnom);  lbnom.setFont(fe);
      txtnom.setBounds(200,120,120,25);p.add(txtnom);
     
     lbdt.setBounds(30,160,120,25);  p.add(lbdt);  lbdt.setFont(fe);
     txtdat.setBounds(200,160,120,25);p.add(txtdat);
     
     lbsal.setBounds(30,200,120,25);  p.add(lbsal);  lbsal.setFont(fe);
     txtsal.setBounds(200,200,120,25);  p.add(txtsal);
     
      
   
     
    
     
    //ajout buttons
     
    btModif.setBounds(50,230,130,27); p.add(btModif); btModif.setFont(fe); btModif.setBackground(Color.CYAN);   btModif.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\modif.png"));
    ann.setBounds(50,270,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);      ann.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\fer.gif"));
      txtrec.setBounds(200, 40, 40, 20); p.add(txtrec);	
     rech.setBounds(50,40,130,25);  p.add(rech);
    supp.setBounds(200,230,130,25); p.add(supp); supp.setBackground(Color.cyan);    rech.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\reche.png"));
    supp.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\supp.png"));
    
     //modif.setBounds(180,110,110,20); p.add(modif);
     
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	

  
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		/*if(e.getSource()==bten)
		{
			String nu,n,p,a1;
			nu=txtnum.getText(); 
			n=txtnom.getText();
			p=txtpren.getText();
			String d=txtdat.getText();
			float pd = Float.valueOf(txtpd.getText());

			a1=txtann.getText();
			
			String query="Insert into eleve values('"+nu+"','"+n+"','"+p+"','"+d+"','"+pd+"','"+a1+"')";
			
			
		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnum.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succ�s");
			 
			 txtnum.setText("");
			   txtnom.setText("");
			   txtpren.setText("");
			   txtdat.setText("");
			 
				
			 }  else {JOptionPane.showMessageDialog (null,"veuillez remplire les champs !");}
			 
			
			 } catch (SQLException e1) {
		
			//e1.printStackTrace();
				JOptionPane.showMessageDialog(this,"errure d'ajout");
		}
	
		
		}
		*/
		//fermeture fenetre Enregistrement
  //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
			//dispose();
		
		
			if(e.getSource()==ann)
			{
	            //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
				//dispose();
			
			
			   if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			   {
				   dispose();
			   }
			}
	
 //suppression
			
		if(e.getSource()==supp)
		{
			String n;
			n=txtnum.getText(); 
			
		String query="DELETE FROM professeurs WHERE num_prof='"+n+"'";
		
		try {
			 st=k.etablirconnection().createStatement();
			 
			 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment supprimez ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
			 {
			    st.executeUpdate(query);
			    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succ�s");
			 } 
			 }
			   
		
	     catch (SQLException e2) {
			   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
		
			
			}
			
       	}
		
		
		//Modification
		if(e.getSource()==btModif)
		{
			String n,p,pr;
			
			n=txtnum.getText(); 
			p=txtnom.getText();
			pr=txtdat.getText();
			String d=txtsal.getText();
			
			
			String query="UPDATE  professeurs  SET nom='"+p+"', datentre='"+pr+"',salaire='"+d+"' where  num_prof="+n+"";
			
			
			try {
				 st=k.etablirconnection().createStatement();
				 
				 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment Modifiez ? ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
				 {
				    st.executeUpdate(query);
				    JOptionPane.showMessageDialog(this,"Modification effectuez avec succ�s");
				 } 
			}
			 catch (SQLException e2) {
				   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
			
				
				}
					}
				 
				   
		
		//recherche
		if(e.getSource()==rech)
		{ String n;
			n=txtrec.getText(); 
			
   String query="SELECT * FROM professeurs  WHERE num_prof='"+n+"'";
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{   txtnum.setText(rst.getString("num_prof"));
				txtnom.setText(rst.getString("nom"));
				txtdat.setText(rst.getString("datentre"));
				txtsal.setText(rst.getString("salaire"));
				
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	
}
