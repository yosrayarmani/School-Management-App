package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Ajout_Eleve extends JFrame implements ActionListener {

    JTextField firstNameInputField, lastNameInputField;
    JButton saveBtn, closeBtn;
    Conn k = new Conn();
    
    public Ajout_Eleve() {
        this.setTitle("Add Student");
        this.setSize(400, 350);
        this.setLocation(500, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel p = new JPanel();
        p.setBackground(Color.white);
        p.setLayout(null);
        
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");

        JLabel addNewStudentTxt = new JLabel("Add a new student");

        firstNameInputField = new JTextField();
        lastNameInputField = new JTextField();

        saveBtn = new JButton("Save");
        closeBtn = new JButton("Close");

        saveBtn.addActionListener(this);
        closeBtn.addActionListener(this);

        Font fe = new Font("gramound", 0, 15);

        addNewStudentTxt.setBounds(30, 20, 340, 20);
        p.add(addNewStudentTxt);

        firstNameLabel.setBounds(30, 70, 120, 25);
        p.add(firstNameLabel);
        firstNameLabel.setFont(fe);

        firstNameInputField.setBounds(160, 70, 120, 25);
        p.add(firstNameInputField);

        lastNameLabel.setBounds(30, 100, 120, 25);
        p.add(lastNameLabel);
        lastNameLabel.setFont(fe);

        lastNameInputField.setBounds(160, 100, 120, 25);
        p.add(lastNameInputField);

        ImageIcon closeIcon = new ImageIcon("images1\\close.png");
        Image resizedCloseIcon = closeIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);

        ImageIcon saveIcon = new ImageIcon("images1\\save.png");
        Image resizedSaveIcon = saveIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        saveBtn.setBounds(50, 230, 130, 27);
        p.add(saveBtn);
        saveBtn.setFont(fe);
        saveBtn.setBackground(Color.CYAN);
        saveBtn.setIcon(new ImageIcon(resizedSaveIcon));

        closeBtn.setBounds(200, 230, 130, 27);
        p.add(closeBtn);
        closeBtn.setFont(fe);
        closeBtn.setBackground(Color.CYAN);
        closeBtn.setIcon(new ImageIcon(resizedCloseIcon));

        add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveBtn) {
            String firstName = firstNameInputField.getText();
            String lastName = lastNameInputField.getText();

            if (firstName.length() != 0 && lastName.length() != 0) {
                String query = "INSERT INTO eleve (elv_nom, elv_prenom, elv_cls_k) VALUES ('" 
                               + firstName + "', '" + lastName + "', NULL)"; 

                try {
                    Statement st = k.etablirconnection().createStatement();

                    if (JOptionPane.showConfirmDialog(this, "Do you want to save?", "Attention", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        st.executeUpdate(query);
                        JOptionPane.showMessageDialog(this, "Student added successfully!");
                        firstNameInputField.setText("");
                        lastNameInputField.setText("");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error while adding student: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
            }
        }

        if (e.getSource() == closeBtn) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Major Incident", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }
}
