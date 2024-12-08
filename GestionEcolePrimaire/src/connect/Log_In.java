package connect;
import Acceuil.Menu_accueil;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Log_In extends JFrame {
	JTextField usernameInput;
	JPasswordField pwdInputField;
	JButton connectBtn,closeBtn;
	JCheckBox showpassword;
	JLabel titleLogin, pwdLabel, usernameLabel;
	JPanel containerPanel;
	
	Statement sendSqlQuery;
	ResultSet resultSqlQuery;
	
	Conn dbConnection = new Conn();
	
	public Log_In(){  
		Container c = getContentPane(); // Conteneur principal de la fenêtre
		c.setBackground( Color.white);
		this.setTitle(" AdministrationLogin ");
		this.setBounds(200,160,600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containerPanel = new JPanel();
		containerPanel.setLayout(null);
		  
		usernameInput = new JTextField();
		pwdInputField = new JPasswordField();
		titleLogin = new JLabel("-- Username : admin     &     Password : admin --");
		usernameLabel = new JLabel("USERNAME :"); 
		pwdLabel = new JLabel("PASSWORD :");   

	  connectBtn = new JButton("CONNECT");
		ImageIcon connectIcon = new ImageIcon("images1\\connect.png");
		Image resizedConnectIcon = connectIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		connectBtn.setIcon(new ImageIcon(resizedConnectIcon));

	  closeBtn = new JButton("CLOSE");
		ImageIcon closeIcon = new ImageIcon("images1\\close.png");
		Image resizedCloseIcon = closeIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		closeBtn.setIcon(new ImageIcon(resizedCloseIcon));

	  showpassword = new JCheckBox("Show Password");
	         
	  titleLogin.setBounds(60,60,400,40);
	  usernameLabel.setBounds(60,150,100,30);
	  pwdLabel.setBounds(60,220,100,30);
	  usernameInput.setBounds(160,150,150,30);
	  pwdInputField.setBounds(160,220,150,30);
		connectBtn.setBounds(160,300,145,30); 
		containerPanel.add(connectBtn);
		closeBtn.setBounds(345,300,145,30); 
		containerPanel.add(closeBtn);
		showpassword.setBounds(160,250,150,30);
	            
	  containerPanel.add(usernameLabel);
	  containerPanel.add(usernameInput);
	  containerPanel.add(titleLogin);
	  containerPanel.add(pwdLabel);
	  containerPanel.add(pwdInputField);
	  containerPanel.add(showpassword);

		connectBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String getInputTxt, getInputPwd;
				getInputTxt = usernameInput.getText(); 
				getInputPwd = String.valueOf(pwdInputField.getPassword());

				if(getInputTxt.equalsIgnoreCase("admin") && getInputPwd.equalsIgnoreCase("admin")) {
					Menu_accueil f = new Menu_accueil();
					f.setVisible(true); 
					dispose();
				} else { 
					JOptionPane.showMessageDialog(null, "Invalid Username or Password ! \nThe username is \"admin\" and the password is \"admin\"");
				}
			}
			}
	  );

	  closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) { dispose(); }
			}     
		);

		showpassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					if(showpassword.isSelected()) {
						pwdInputField.setEchoChar((char) 0);
					} else {
						pwdInputField.setEchoChar('*');
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

	


