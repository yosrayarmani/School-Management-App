package connect;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Acceuil.Menu_accueil;



public class login extends JFrame {
	//creating components for the JFrame
	JTextField txtlog;
	JPasswordField txtpwd;
	
	JButton con,ann;
	JCheckBox showpassword;
	
	JLabel keepconnected, password, username, ac,icon;
	JPanel p;
	
	Font f24= new Font(" Serif",Font.BOLD,24);//creating object of Font class
	Font f12= new Font(" Serif",Font.BOLD,12);
    Font italic= new Font(" Serif",Font.ITALIC,14);
	Statement st;
	ResultSet rt;
	
	connection kk=new connection();
	
	public login(){  
		Container c=getContentPane();
	    c.setBackground( Color.white);
		this.setTitle("Login");
		this.setBounds(200,160,600,500);;
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	    p=new JPanel();
		p.setLayout(null);
		  
		txtlog=new JTextField();
		txtpwd=new JPasswordField();
		keepconnected=new JLabel("KEEP CONNECTED");
	    password=new JLabel("PASSWORD");   
	    username=new JLabel("USERNAME");
	    ac=new JLabel("");
	      
	    con=new JButton("CONNECT");
	    ann=new JButton("CLOSE");
	    showpassword = new JCheckBox("Show Password");



	    username.setFont(italic);
	    password.setFont(italic);
	    keepconnected.setFont(f12);
	    con.setFont(f12);
	    ann.setFont(f12);
	         
	         
	         
	          
	  //set location and size of each components using setBounds() method
	         
	    keepconnected.setBounds(200,60,200,40);
	    username.setBounds(60,150,100,30);
	    password.setBounds(60,220,100,30);
	    ac.setBounds(5, 90, 160, 90);

	    txtlog.setBounds(160,150,150,30);
	    txtpwd.setBounds(160,220,150,30);
	    
		con.setBounds(160,300,100,30); p.add(con);
		ann.setBounds(280,300,100,30); p.add(ann);
		
        showpassword.setBounds(160,260,150,30);
	       
      //add components 
	    p.add(ac)	;      
	    p.add(username);
	    p.add(txtlog);
	    p.add(keepconnected);
	    p.add(password);
	    p.add(txtpwd);
	    p.add(showpassword);

	      

	  //adding functionalities to our JButton and JChexkBox, so that when we click on them, they should perform some actions
	  //add Action listener to components
	  //ActionListener contains only one method: ActionPerformed(ActionEvent e) so after implementing the ActionListener interface in our class, then we have to override its method actionPerformed(ActionEvent e) into that class
	 //CONNECTION EVENT
	      
	      con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String c,p;
				c=txtlog.getText(); 
				p = String.valueOf(txtpwd.getPassword());
				
				String query="SELECT * FROM public.eleve WHERE eleve.elv_nom='"+c+"' and eleve.elv_prenom='"+p+"'"; 
				
				
				try {
					st=kk.etablirconnection().createStatement();
					rt=st.executeQuery(query);
					
					if(rt.next()) {
						
						if(c.equalsIgnoreCase(rt.getString("elv_nom")) && p.equalsIgnoreCase(rt.getString("elv_prenom")))
						{
							Menu_accueil f=new Menu_accueil();
							f.setVisible(true); 
							dispose();
							
						}
					}
					 
					else 
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	      );
	      
	      
	      
	      //CLOSE EVENT
	      
	      ann.addActionListener(new ActionListener() 
	      {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				
			}
		  }     );
	      
	    //coding part of show password button
	      showpassword.addActionListener(new ActionListener() 
	      {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
					if(showpassword.isSelected()) {
						txtpwd.setEchoChar((char) 0);
					} else {
						txtpwd.setEchoChar('*');
					}
			}
		  }     );
	      
	     this.setContentPane(p);
	   }


		public static void main(String[] args) {
			//create object of Login class and setting its properties
			login fen=new login();
			fen.setVisible(true);
		}

	}

	


