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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connect.connection;

public class fen_charge extends JFrame implements ActionListener{
	
	private JTextField txttl;
	private JLabel profid,coursid;
	private JButton bten,ann;
	private JComboBox cmbonump=new JComboBox();
	private JComboBox cmbonumc=new JComboBox();
	Statement st;
	private JButton lbrec;
	private String req1C = " select DISTINCT mat_id from  matiere";
	private String req2E = " select DISTINCT prof_id from professeur";
	
	
	connection k=new connection();
	
	public fen_charge()
	{ 
	   initCombo();
	  this.setTitle("Charge");
	  this.setSize(400,300);
	  this.setLocation(500, 200);
	  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     //JLabel lbpt=new JLabel("point :");
     JLabel lbnump=new JLabel("numero_prof:");
     JLabel lbnumc=new JLabel("Numero_cours");
     
       txttl=new JTextField();
  
    
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     //bten.addActionListener(this);
    // ann.addActionListener(this);
     
     
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
    lbnump.setBounds(30,30,120,25); p.add(lbnump);
    cmbonump.setBounds(200,30,120,25); p.add(cmbonump);
    
    
     cmbonump.setForeground(Color.CYAN); cmbonumc.setPreferredSize(new Dimension( 400 , 200));
     
      lbnumc.setBounds(30,70,120,25);  p.add(lbnumc);  lbnumc.setFont(fe);
      cmbonumc.setBounds(200,70,120,25);p.add(cmbonumc);
     
      txttl.setBounds(200,110,120,25);p.add(txttl); txttl.setFont(fe);
     
		
     
     ann.addActionListener(new ActionListener()
     {  
    		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
	}
    	 
     });
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this); bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,160,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);     ann.addActionListener(this);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	//recherche de numero cours dans le combo
	private void initCombo(){
		 
		 
			 Statement state;ResultSet res;
			 connection kk=new connection();
			 
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req1C);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonumc.addItem(res.getString("mat_id"));
					
				}res.close();state.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
	
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req2E);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonump.addItem(res.getString("prof_id"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	//fermeture de la fenetre
	
	
	
	}
/*static public void main(String[] args) {
	
	fen_charge f=new fen_charge();
	f.setVisible(true);
	
}*/

@Override
public void actionPerformed(ActionEvent a) {

	
	if(a.getSource()==bten)
	{
		
	String  n2=(String) cmbonump.getSelectedItem();
	String n = (String) cmbonumc.getSelectedItem();
	float n3 =  Float.valueOf(txttl.getText());
	


	String requete = "INSERT INTO charge VALUES ('"+n2+"','"+n+"','"+n3+"')";
	  Statement state = null;
		try {
			
			 connection kk=new connection();
			 
	state=kk.etablirconnection().createStatement();
				
		  int res =  state.executeUpdate(requete);
		  if(res!=0){
			 //state.execute(requete);
				
				JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
				
				   txttl.setText("");
		  }
		  
				//res.close();
				state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

	    
	}
}}



	 















