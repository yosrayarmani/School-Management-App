package Affichage;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import connect.Conn;
public class listEleve extends javax.swing.JFrame{
	Statement stListe;
	Conn maconnexion = new Conn();
	 
	    public listEleve() {
	    	 this.setLocation(500, 200);
	    	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        initComponents();
	        DefaultTableModel model=new DefaultTableModel();
	        model.addColumn("Numero");
	        model.addColumn("Nom ");
	        model.addColumn("Prenom");
	        model.addColumn("Classe");
	        
	        TABLEPRO.setModel(model);
	        String requeteListe = "select  * from eleve ";
	        
	        try{
	            stListe=maconnexion.etablirconnection().createStatement();
	            ResultSet resultat =stListe.executeQuery(requeteListe);
	            while(resultat.next()){
	                model.addRow(new Object []{ resultat.getString("elv_id"), resultat.getString("elv_nom"),resultat.getString("elv_prenom"),resultat.getString("elv_cls_k")});
	            }
	        }catch(SQLException ex){
	            System.out.println(ex);
	        }
	    }

	    private void initComponents() {

	        jLabel1 = new JLabel();
	        TABLE = new JScrollPane();
	        TABLEPRO = new JTable();
	       

	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new Font("Tahoma", 1, 24)); // NOI18N
	        jLabel1.setText("Liste Des Eleves");
	       

	        TABLEPRO.setModel(new DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
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
	      
	    }                      
	 
	    public static void main(String args[]) {
	       
	        try {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(listEleve.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            Logger.getLogger(listEleve.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(listEleve.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (UnsupportedLookAndFeelException ex) {
	            Logger.getLogger(listEleve.class.getName()).log(Level.SEVERE, null, ex);
	        }}
	        
	                        
	    private JScrollPane TABLE;
	    private JTable TABLEPRO;
	    private JLabel jLabel1;             
	}



