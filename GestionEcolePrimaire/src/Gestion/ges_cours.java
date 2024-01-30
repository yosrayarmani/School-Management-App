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

public class ges_cours extends JFrame implements ActionListener {
	
	JTextField txtnom_crs,txtHB_crs,txtdann,txtnum_crs,txtrec;
	JButton btModif,supp,rech,fer,ann;
	Statement st;
	private javax.swing.JFormattedTextField daten =new javax.swing.JFormattedTextField(DateFormat.getDateInstance());
	
	connection k=new connection();
	
	public ges_cours()
	{ 
	  this.setTitle("");
	  this.setSize(400,350);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnum_crs=new JLabel("Numero cours");
     JLabel lbnom_crs=new JLabel("Nom cours");
     JLabel lbHB=new JLabel("Nombre Heure");lbHB.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\heur.png"));
     JLabel lbann=new JLabel("Annee");
    
     
     
     
     txtnum_crs=new JTextField();
     txtnom_crs=new JTextField();
     txtHB_crs=new JTextField();
     txtdann=new JTextField("");
    
     txtrec=new JTextField(""); txtrec.setBackground(Color.WHITE);
     btModif=new JButton("Modifiez");
     ann=new JButton("Terminer");
     
     btModif.addActionListener(this);
     ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("gramound",0,15);
     
     supp=new JButton("Supprimer");
     supp.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\supp.png"));
    // modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
     rech.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\reche.png"));
     
     ann.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\fer.gif"));
      
     
     
     supp.addActionListener(this);
    // modif.addActionListener(this);
     rech.addActionListener(this);
     
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
    // lbT.setBounds(15,0,340,20); p.add(lbT);
     
     
      lbnum_crs.setBounds(30,80,110,25);  p.add(lbnum_crs);  lbnum_crs.setFont(fe);
     txtnum_crs.setBounds(200,80,120,25);p.add(txtnum_crs);
     
     lbnom_crs.setBounds(30,120,120,25);  p.add(lbnom_crs);  lbnom_crs.setFont(fe);
      txtnom_crs.setBounds(200,120,120,25);p.add(txtnom_crs);
     
           lbHB.setBounds(30,160,130,25);  p.add(lbHB);  lbHB.setFont(fe);
     txtHB_crs.setBounds(200,160,40,25);p.add(txtHB_crs);
     
     lbann.setBounds(30,200,80,25);  p.add(lbann);  lbann.setFont(fe);
     txtdann.setBounds(200,200,80,25);  p.add(txtdann);
     
      
   
     
    //ajout buttons
     
    btModif.setBounds(50,230,120,27); p.add(btModif); btModif.setFont(fe); btModif.setBackground(Color.CYAN); btModif.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\modif.png"));
    ann.setBounds(50,270,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
      txtrec.setBounds(200,40, 40, 20); p.add(txtrec);	
     rech.setBounds(50,40,130,25);  p.add(rech);
    supp.setBounds(200,230,130,25); p.add(supp); supp.setBackground(Color.cyan);
    
     //modif.setBounds(180,110,110,20); p.add(modif);
     
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	

  
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
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
			n=txtnum_crs.getText(); 
			
		String query="DELETE FROM cours WHERE num_crs='"+n+"'";
		
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
		
		
		//Modification
		if(e.getSource()==btModif)
		{
			String n,p,a,pr;
			
			n=txtnum_crs.getText(); 
			p=txtnom_crs.getText();
			pr=txtHB_crs.getText();
			String d=txtdann.getText();
			
			
			String query="UPDATE  cours  SET nom_crs='"+p+"', nbrH='"+pr+"',ann="+d+" where  num_crs="+n+"";
			
			
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
				   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
			
				
				}
					}
				 
				   
		
		//recherche
		
		if(e.getSource()==rech)
		{ String n;
			n=txtrec.getText(); 
			
   String query="SELECT * FROM cours  WHERE num_crs="+n+"";
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{   txtnum_crs.setText(rst.getString("num_crs"));
				txtnom_crs.setText(rst.getString("nom_crs"));
				txtHB_crs.setText(rst.getString("nbrH"));
				txtdann.setText(rst.getString("ann"));
				
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	
	
	
	

/*public static void main(String[] args) {
	
	ges_cours ge=new ges_cours();
	ge.setVisible(true);
	
	

}*/
	
}
