package Affichage;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import connect.Conn;

public class listprofesseurs extends javax.swing.JFrame{
	
	private JButton bfer;
	 private String query = "SELECT  * FROM professeur order by  prof_nom asc";
	
	Statement stListe;
	Conn maconnexion = new Conn();
	 
	    public listprofesseurs() {
	        initComponents();
	        this.setLocation(500, 200);
	      	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        DefaultTableModel model=new DefaultTableModel();
	        model.addColumn("Numero ");
	        model.addColumn("Nom");
	        model.addColumn("prenom");
	        
	        TABLEPRO.setModel(model);
	      
	        try{
	            stListe=maconnexion.etablirconnection().createStatement();
	            ResultSet resultat =stListe.executeQuery(query);
	            while(resultat.next()){
	                model.addRow(new Object []{ resultat.getString("prof_id"),resultat.getString("prof_nom"),resultat.getString("prof_prenom")});
	            }
	        }catch(SQLException ex){
	            System.out.println(ex);
	        }
	      
	            
	        bfer=new JButton("Fermer");
	        bfer.setBounds(75,150,100,30);
	        
	        
	    }
			                       
	    private void initComponents() {

	        jLabel1 = new JLabel();
	        TABLE = new JScrollPane();
	        TABLEPRO = new JTable();
	       

	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new Font("Tahoma", 1, 14)); 
	        jLabel1.setText("LISTE DES PROFFESSEURS");
	       

	        TABLEPRO.setModel(new DefaultTableModel(
	            new Object [][] {
	                {null, null, null},
	                {null, null, null},
	                {null, null, null},
	                {null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3"
	            }
	        ));
	        TABLE.setViewportView(TABLEPRO);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(TABLE, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(15, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(TABLE, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	              
	        );
	       
	        pack();
	      
	    }// </editor-fold>                        
	 
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
	            java.util.logging.Logger.getLogger(listprofesseurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(listprofesseurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(listprofesseurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(listprofesseurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	    }
	                        
	    private javax.swing.JScrollPane TABLE;
	    private javax.swing.JTable TABLEPRO;
	    private javax.swing.JLabel jLabel1;              
	}



