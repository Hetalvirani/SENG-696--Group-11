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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.lang.acl.*;
import utils.*;



public class WelcomeAgent extends ServiceAgent {

	
	

	@Override
	protected void setup() {
		
				addBehaviour(new WelcomeBehaviour());
			}

	private class WelcomeBehaviour extends CyclicBehaviour {

	
		public WelcomeBehaviour() {
			
			new Welcomepage();
			System.out.println(getLocalName() + "Waiting for input from Login form");
			
		}
		
		public void action() {
				
			ACLMessage msg;
//			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//	            msg.addReceiver(new AID("Compare-1",AID.ISLOCALNAME));
//	            msg.setContent("process data");
//	            send(msg);
			
			
			
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

		

		
		
		public class Welcomepage {

			private JFrame frame;
			private JPanel panel;
			private JButton searchbutton,comparebutton;
			
			private JLabel label;
			
			
			public Welcomepage() {
				frame = new JFrame();
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(0, 1));
				
				label = new JLabel("Welcome to Online Consultancy");
				label.setFont(new Font("Calibri", Font.BOLD, 24));
				panel.add(label);

				
				
				panel.add(new JLabel(""));
				

				// panel.add(new JLabel("Pick an Image file"));
				
				


				searchbutton = new JButton("Search");
				searchbutton.setBackground(Color.WHITE);
				searchbutton.setForeground(new Color(80, 155, 200));
				
				comparebutton = new JButton("Compare");
				comparebutton.setBackground(Color.WHITE);
				comparebutton.setForeground(new Color(80, 155, 200));
				
				searchbutton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						if (evt.getSource()== searchbutton) {
							
							createAgent("Classifier-1", "agent.ClassifierAgent");
								System.out.println("Data searched");
						}
						
						
						
					}
					
				});
				comparebutton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						if (evt.getSource()== comparebutton) {
							
							
							
							System.out.println("Enter data to compare");
							createAgent("Compare-1", "agent.CompareAgent");
							
						}
						
						
						
					}
					
				});
				
				panel.add(searchbutton);
				panel.add(comparebutton);
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

