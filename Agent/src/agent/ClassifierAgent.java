package agent;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import utils.Constants;
import utils.UserDetailsDTO;

public class ClassifierAgent extends ServiceAgent {

	
	

	@Override
	protected void setup() {
		
				addBehaviour(new ClassifierBehaviour());
			}

	private class ClassifierBehaviour extends OneShotBehaviour {

	
		public ClassifierBehaviour() {
			
			new SwingMain();
			System.out.println(getLocalName() + "Waiting for input from Search form");
			
		}
		
		public void action() {
				
				ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	            msg.addReceiver(new AID("Compare-1",AID.ISLOCALNAME));
	            msg.setContent("Start Comparision");
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
			private JButton searchbutton;
			private JTextField textField;
			private JLabel label;
			private JComboBox dropdown;
			
			private String Course_type[]={"Course_based","thesis_based"};
			private String Country_list[]={"Canada","USA"};
			private String Program[]={"Computer Science ","Chemical Engineering","Mechanical Engineering","Civil Engineering"};

			public SwingMain() {
				frame = new JFrame();
				panel = new JPanel();
				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
				panel.setLayout(new GridLayout(0, 1));
				
				label = new JLabel("Search Form");
				label.setFont(new Font("Calibri", Font.BOLD, 24));
				panel.add(label);

				label = new JLabel("Choose Program name");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				
				dropdown = new JComboBox(Program);
				panel.add(dropdown);
				
				label = new JLabel("Enter Course Term");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				textField = new JTextField(30);
				panel.add(textField);
				
				label = new JLabel("Choose Course type");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				dropdown = new JComboBox(Course_type);
				panel.add(dropdown);
				
				label = new JLabel("Choose Country");
				label.setFont(new Font("Calibri", Font.BOLD, 16));
				panel.add(label);
				dropdown = new JComboBox(Country_list);
				panel.add(dropdown);
				
				

				// panel.add(new JLabel("Pick an Image file"));
				
				


				searchbutton = new JButton("Search");
				searchbutton.setBackground(Color.WHITE);
				searchbutton.setForeground(new Color(80, 155, 200));
				
				
				
				searchbutton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						
						if (evt.getSource()== searchbutton) {
							
							UserDetailsDTO ud3 = new UserDetailsDTO();
							
					        String country=dropdown.getSelectedItem().toString();
					        
					        
					        if(country.equals("Canada"))
					        {
					        	String a=Arrays.toString(ud3.strcanada);
								int count=ud3.strcanada.length;
								JPanel panel = new JPanel(new BorderLayout(10, 10));
						        String text = String.format("Searched List Of Universities", count);
						        JLabel label = new JLabel(text);
						        panel.add(label, BorderLayout.PAGE_START);
						        JList<String> list = new JList<>(ud3.strcanada);
						        panel.add(list, BorderLayout.CENTER);
						        
						        JOptionPane.showMessageDialog(null, panel, "List OF Universties", JOptionPane.INFORMATION_MESSAGE);
								
					        }
					        
					        	
							//JOptionPane.showMessageDialog(null,a,"List Of Universities",JOptionPane.INFORMATION_MESSAGE);
					        if(country.equals("USA"))
					        {
					        	String a=Arrays.toString(ud3.strUSA);
								int count=ud3.strUSA.length;
								JPanel panel = new JPanel(new BorderLayout(10, 10));
						        String text = String.format("Searched List Of Universities", count);
						        JLabel label = new JLabel(text);
						        panel.add(label, BorderLayout.PAGE_START);
						        JList<String> list = new JList<>(ud3.strUSA);
						        panel.add(list, BorderLayout.CENTER);
						        
						        JOptionPane.showMessageDialog(null, panel, "List OF Universties", JOptionPane.INFORMATION_MESSAGE);
								
					        }
							
								System.out.println("Data searched");
								frame.dispose();
						}
						
						
						
					}
					
				});
				
				panel.add(new JLabel(""));
				panel.add(searchbutton);
				
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

