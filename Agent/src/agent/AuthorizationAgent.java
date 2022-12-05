package agent;



import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;

import utils.Constants;
import utils.UserDetailsDTO;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import java.util.Scanner;

import jade.core.AID;

public class AuthorizationAgent extends Agent {
	
	protected void setup() {
		
				
				addBehaviour(new AuthorizationBehaviour());
				
			
	}
	
	private class AuthorizationBehaviour extends CyclicBehaviour {

		public AuthorizationBehaviour() {
			
			new LoginFrame();
			//System.out.println(getLocalName() + " Waiting For Data From Interface Agent...");
		}
		
		public void action() {
			
			
		    ACLMessage remsg = myAgent.receive();
	        
	        if(remsg!=null){
	            System.out.println(remsg.getContent());
				System.out.println(getLocalName() + " Waiting For Data From Interface Agent...");
	            
				ACLMessage reply = remsg.createReply();
				 reply.setPerformative(ACLMessage.INFORM);
				 reply.setContent(" Hello reply from Receiver");
				 send(reply);
	        }
	        
	         block();
	           
		
		}
		
		private void createAgent(String name, String className) {
			AID agentID = new AID(name, AID.ISLOCALNAME);
			AgentContainer controller = getContainerController();
			try {
				AgentController agent = controller.createNewAgent(name, className, null);
				agent.start();
				System.out.println("Initialized: " + agentID.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public class LoginFrame {

		private JFrame frame;
		private JPanel panel;
		private JButton loginbutton,resetbutton;
		private JTextField textField;
		private JPasswordField pwdfield;
		private JLabel label;
		

		public LoginFrame() {
			frame = new JFrame();
			panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
			panel.setLayout(new GridLayout(0, 1));
			
			label = new JLabel("Login Form");
			label.setFont(new Font("Calibri", Font.BOLD, 24));
			panel.add(label);

			 label = new JLabel("Enter Registered Email Address");
			label.setFont(new Font("Calibri", Font.BOLD, 16));
			panel.add(label);
			panel.add(new JLabel(""));
			
			
			textField = new JTextField(30);
			textField.setText("");
			panel.add(textField);
			
			
			label = new JLabel("Enter Password");
			label.setFont(new Font("Calibri", Font.BOLD, 16));
			panel.add(label);
			panel.add(new JLabel(""));
			
			UserDetailsDTO ud = new UserDetailsDTO();
			

			pwdfield = new JPasswordField(30);
			panel.add(pwdfield);


			loginbutton = new JButton("Login");
			loginbutton.setBackground(Color.WHITE);
			loginbutton.setForeground(new Color(80, 155, 200));
			
			resetbutton = new JButton("Reset");
			resetbutton.setBackground(Color.WHITE);
			resetbutton.setForeground(new Color(80, 155, 200));
			
			
			
			
			loginbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					System.out.println(textField.getText().length());
					if (evt.getSource()== loginbutton) {
						String mail = textField.getText();
						String pwd = pwdfield.getText();
						
						System.out.println(mail);
						
						UserDetailsDTO ud1 = new UserDetailsDTO();
						
						
						
						if(mail.equals(ud1.getEmailID()) && pwd.equals(ud1.getPassword()))
						{
							System.out.println("Succesful Login");
							frame.dispose();
							createAgent("Welcome-1", "agent.WelcomeAgent");
							frame.dispose();
						
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Invalid Login details ");
							System.out.println("Login Failed");
						}
												
					} 
					
					
					
				}
			});
			
			
			resetbutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					if (evt.getSource()== resetbutton) {
						
						
						textField.setText("");
						pwdfield.setText("");
						
						
					}
					
					
					
				}
				
			});
			panel.add(new JLabel(""));
			panel.add(loginbutton);
			panel.add(new JLabel(""));
			
			panel.add(new JLabel(""));
			panel.add(resetbutton);
			panel.add(new JLabel(""));

			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Online Consultancy");
			frame.pack();
			frame.setVisible(true);
			

		}
	}
	
}

}