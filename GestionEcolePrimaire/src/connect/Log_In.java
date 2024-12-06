package connect;
import Acceuil.Menu_accueil;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Log_In extends JFrame {
	JTextField txtlog;
	JPasswordField txtpwd;
	JButton connBtn,annulerBtn;
	JCheckBox showpassword;
	JLabel titleLogin, pwdLabel, usernameLabel;
	JPanel containerPanel;
	
	Statement sendSqlQuery;
	ResultSet resultSqlQuery;
	
	Conn dbConnection = new Conn();
	
	public Log_In(){  
		Container c = getContentPane(); // Conteneur principal de la fenêtre
		c.setBackground( Color.white);
		this.setTitle("Login");
		this.setBounds(200,160,600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		  
		txtlog = new JTextField();
		txtpwd = new JPasswordField();
		titleLogin = new JLabel("-- Username : admin     &     Password : admin --");
		pwdLabel = new JLabel("PASSWORD");   
		usernameLabel = new JLabel("USERNAME"); 
	  connBtn = new JButton("CONNECT");
	  annulerBtn = new JButton("CLOSE");
	  showpassword = new JCheckBox("Show Password");
	         
	  titleLogin.setBounds(60,60,400,40);
	  usernameLabel.setBounds(60,150,100,30);
	  pwdLabel.setBounds(60,220,100,30);
	  txtlog.setBounds(160,150,150,30);
	  txtpwd.setBounds(160,220,150,30);
		connBtn.setBounds(160,300,100,30); containerPanel.add(connBtn);
		annulerBtn.setBounds(280,300,100,30); containerPanel.add(annulerBtn);
		showpassword.setBounds(160,260,150,30);
	            
	  containerPanel.add(usernameLabel);
	  containerPanel.add(txtlog);
	  containerPanel.add(titleLogin);
	  containerPanel.add(pwdLabel);
	  containerPanel.add(txtpwd);
	  containerPanel.add(showpassword);

		connBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String getInputTxt, getInputPwd;
				getInputTxt = txtlog.getText(); 
				getInputPwd = String.valueOf(txtpwd.getPassword());

				if(getInputTxt.equalsIgnoreCase("admin") && getInputPwd.equalsIgnoreCase("admin")) {
					Menu_accueil f=new Menu_accueil();
					f.setVisible(true); 
					dispose();
				} else { 
					JOptionPane.showMessageDialog(null, "Invalid Username or Password ! \nThe username is \"admin\" and the password is \"admin\"");
				}
			}
			}
	  );
	      
	  annulerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { dispose(); }
			}     
		);

		showpassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(showpassword.isSelected()) {
						txtpwd.setEchoChar((char) 0);
					} else {
						txtpwd.setEchoChar('*');
					}
			}
		}     
		);
	      
	  this.setContentPane(containerPanel);
	}

		public static void main(String[] args) {
			Log_In fenetre = new Log_In();
			fenetre.setVisible(true);
		}

}

	


