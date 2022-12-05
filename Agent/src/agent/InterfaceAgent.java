package agent;

import utils.*;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import utils.UserDetailsDTO;

public class InterfaceAgent extends ServiceAgent {

	public Set<AID> AuthorizationAgents = new HashSet<>();
	
	@Override
	protected void setup() {
	
				addBehaviour(new InterfaceBehaviour());
		
	}

	private class InterfaceBehaviour extends OneShotBehaviour {

		
		public InterfaceBehaviour() {
			
			new SwingMain();
			System.out.println(getLocalName() + " Waiting for input from SwingUI(User Registration)");
     		
		}
		
		public void action() {
				
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
				msg.setSender(this.myAgent.getAID());	
	            msg.addReceiver(new AID("Authorization-1",AID.ISLOCALNAME));
	            msg.setContent("User Details send to the Authorization Agent for Verification...");
	            send(msg);
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

		public class SwingMain {

			private JFrame frame;
			private JPanel panel;
			private JButton button;
			private JTextField namefield,mailfield,mobilefield;
			private JPasswordField pwdfield, repwdfield;
			private JLabel label;

			public SwingMain() {
				frame = new JFrame();
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(0, 1));
				
				label = new JLabel("Registration Form");
				label.setFont(new Font("Calibri", Font.BOLD, 24));
				panel.add(label);
				
				
				label = new JLabel("Enter Your Name");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				namefield = new JTextField(30);
				panel.add(namefield);
				
				
				
				
				label = new JLabel("Enter Your Email-ID");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				mailfield = new JTextField(30);
				panel.add(mailfield);
				
			
				
				label = new JLabel("Enter Your MobileNo");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				mobilefield = new JTextField(30);
				panel.add(mobilefield);
				
				label = new JLabel("Enter Your Password");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				pwdfield = new JPasswordField(30);
				panel.add(pwdfield);
				
				label = new JLabel("Retype Password");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				repwdfield = new JPasswordField(30);
				panel.add(repwdfield);



				button = new JButton("Register");
				button.setBackground(Color.WHITE);
				button.setForeground(new Color(80, 155, 200));
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						if (evt.getSource()== button) {
							
							String name = namefield.getText();
							String mail=mailfield.getText();
							String phno = mobilefield.getText();
							String pwd = pwdfield.getText();
							String repwd =repwdfield.getText();
							int p = pwdfield.toString().length();
							int rp = repwdfield.toString().length();
							
							UserDetailsDTO ud = new UserDetailsDTO();
							UserDetailsDTO.Name=namefield.getText();
							System.out.println(ud.getName());
							
							
							UserDetailsDTO.EmailID=mailfield.getText();
							System.out.println(ud.getEmailID());
							
							
							UserDetailsDTO.mobileNO=mobilefield.getText();
							System.out.println(ud.getMobileNO());
							
							
							ud.Password=pwdfield.getText().toString();
							System.out.println(ud.getPassword());
							
							
							ud.RePassword=repwdfield.getText().toString();
							System.out.println(ud.getRePassword());
							
							
							if(name.equals("") || mail.equals("") || phno.equals("") || pwd.equals("") || repwd.equals(""))
							{
							JOptionPane.showMessageDialog(null,"Enter all the details to register");
							System.out.println("Registration is  UnSuccessful");
							}
							else if (pwd.equals(repwd) && p==rp && p>0 && rp >0 ) {
									
									System.out.println("Registration is Successful");
									frame.dispose();
									createAgent("Authorization-1", "agent.AuthorizationAgent");
									System.out.println("Interface Send data successfully to the Authorization Agent");
									
							} else {
									JOptionPane.showMessageDialog(null,"Passwords are not Matching");
									System.out.println("Registration is Unsuccessful");
							}
						} 
							
							
					}
					
					
					
				});
				panel.add(new JLabel(""));
				panel.add(button);
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



