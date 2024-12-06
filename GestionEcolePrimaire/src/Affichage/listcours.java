package Affichage;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import connect.Conn;
public class listcours extends javax.swing.JFrame{
	
	private JButton bfer;

	Statement stListe;
	Conn maconnexion = new Conn();
	 
	    public listcours() {
	        initComponents();
	        this.setLocation(500, 200);
	      	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        DefaultTableModel model=new DefaultTableModel();
	        model.addColumn("Numero ");
	        model.addColumn("Nom cours");
	        
	        TABLEPRO.setModel(model);
	        String requeteListe="select * from matiere";
	        try{
	            stListe=maconnexion.etablirconnection().createStatement();
	            ResultSet resultat =stListe.executeQuery(requeteListe);
	            while(resultat.next()){
	                model.addRow(new Object []{ resultat.getString("mat_id"),resultat.getString("mat_nom")});
	            }
	        }catch(SQLException ex){
	            System.out.println(ex);
	        }
	      
	            
	        bfer=new JButton("Fermer");
	        bfer.setBounds(75,150,100,30);
	        
	        
	    }                       
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        TABLE = new javax.swing.JScrollPane();
	        TABLEPRO = new javax.swing.JTable();
	       

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
	        jLabel1.setText("LISTE DES COURS ");
	       

	        TABLEPRO.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null,null},
	                {null, null, null, null,null},
	                {null, null, null, null,null},
	                {null, null, null, null,null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3"
	            }
	        ));
	        TABLE.setViewportView(TABLEPRO);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(TABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(15, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(TABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	              
	        );
	       
	        pack();
	      
	    }                       
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	       
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(listcours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(listcours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(listcours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(listcours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	    }                   
	    private javax.swing.JScrollPane TABLE;
	    private javax.swing.JTable TABLEPRO;
	    private javax.swing.JLabel jLabel1;                 
	}



