package swingdemo;

import java.awt.Container;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


 
public class Registration extends JFrame {
 
    JLabel message;
    JLabel nameLabel;
    JTextField nameField;
   
    JLabel mailIdLabel, mobileNoLabel;
    JTextField mailIdField, mobileNoField;
 
    JLabel passwordLabel, rePasswordLabel;
    JPasswordField passwordField, rePasswordField;
 
    JButton registerButton;
    Container container;
 
    public Registration() {
        message = new JLabel("Student Registration Form");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("Name");
        nameField = new JTextField();
 
        mailIdLabel = new JLabel("Mail Id");
        mailIdField = new JTextField();
 
        mobileNoLabel = new JLabel("Mobile No");
        mobileNoField = new JTextField();
 
        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
 
        rePasswordLabel = new JLabel("Re Password");
        rePasswordField = new JPasswordField();

 
        registerButton = new JButton("Register");
        
        registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				if (evt.getSource()== registerButton) {
					
					LoginFrame login=new LoginFrame();
					login.setVisible(true);
				}
		
			}
		
		});
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
 
    }
 
    public void setBounds() {
        message.setBounds(50, 10, 600, 30);
        nameLabel.setBounds(50, 60, 100, 30);
        nameField.setBounds(130, 60, 200, 30);
 
        mailIdLabel.setBounds(50, 110, 100, 30);
        mailIdField.setBounds(130, 110, 200, 30);
 
        mobileNoLabel.setBounds(50, 160, 100, 30);
        mobileNoField.setBounds(130, 160, 200, 30);
 
        passwordLabel.setBounds(50, 210, 100, 30);
        passwordField.setBounds(130, 210, 200, 30);
 
        rePasswordLabel.setBounds(50, 260, 100, 30);
        rePasswordField.setBounds(130, 260, 200, 30);
 
 
        registerButton.setBounds(130, 300, 200, 30);
    }
 
    public void addComponents() {
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(mailIdLabel);
        container.add(mailIdField);
        container.add(mobileNoLabel);
        container.add(mobileNoField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(rePasswordLabel);
        container.add(rePasswordField);
        container.add(registerButton);
    }
 
    public static void main(String[] args)
    {
        Registration frame = new Registration();
        frame.setTitle("Student Register Form");
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
 
    }
    
 
}