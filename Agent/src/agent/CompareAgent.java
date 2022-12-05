package agent;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.UserDetailsDTO;




public class CompareAgent extends Agent {
	
	
	
	
	@Override
	protected void setup() {
		
				
				addBehaviour(new CompareBehaviour());
				
			
	}
	


	private class CompareBehaviour extends CyclicBehaviour {

		public CompareBehaviour() {
			
			new CompareFrame();
			System.out.println(getLocalName() + " Waiting For Data From classifier Agent...");
			
		}
		
		public void action() {
			// TODO Auto-generated method stub
			
             ACLMessage remsg = myAgent.receive();
	        
	        if(remsg!=null){
	            System.out.println(remsg.getContent());
	            
	        }else{
	            block();
	        }
			
		}
	
	public class CompareFrame {

		private JFrame frame;
		private JPanel panel;
		private JPanel panel1;
		private JButton button;
		private JComboBox univ1_dropdown , univ2_dropdown,param_dropdown;
		private JLabel label;
		private String university_list[]={"University of calgary","Alberta University","Toronto University"};
	    private String compare_parameters[]={"University_ranking","Fee_Structure","Course_Ranking"};
		public CompareFrame() {
			frame = new JFrame();
			panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
			panel.setLayout(new GridLayout(0, 1));

			label = new JLabel("Compare Form");
			label.setFont(new Font("Calibri", Font.BOLD, 24));
			panel.add(label);
			
			
			 label = new JLabel("Select university");
			label.setFont(new Font("Calibri", Font.BOLD, 16));
			panel.add(label);
			panel.add(new JLabel(""));
			// panel.add(new JLabel("Pick an Image file"));
			univ1_dropdown = new JComboBox(university_list);
			panel.add(univ1_dropdown);
			
			 label = new JLabel("select university to compare");
			label.setFont(new Font("Calibri", Font.BOLD, 16));
			panel.add(label);
			panel.add(new JLabel(""));
			// panel.add(new JLabel("Pick an Image file"));
			univ2_dropdown = new JComboBox(university_list);
			panel.add(univ2_dropdown);
			
			label = new JLabel(" compare based on");
			label.setFont(new Font("Calibri", Font.BOLD, 16));
			panel.add(label);
			panel.add(new JLabel(""));
			// panel.add(new JLabel("Pick an Image file"));
			param_dropdown = new JComboBox(compare_parameters);
			panel.add(param_dropdown);
			


			button = new JButton("Compare");
			button.setBackground(Color.WHITE);
			button.setForeground(new Color(80, 155, 200));
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					
					if (evt.getSource()== button) {
							
						UserDetailsDTO ud4 = new UserDetailsDTO();
						ud4.Univ1=univ1_dropdown.getSelectedItem().toString();
						ud4.Univ2=univ2_dropdown.getSelectedItem().toString();
						int univ1_count,univ2_count;
						JList<String> Univ1_list,Univ2_list;
						if(ud4.Univ1.equals("University of calgary") && ud4.Univ1.equals("University Of Toronto") )
						{
						    univ1_count=ud4.UOC.length;
						    univ2_count=ud4.UOT.length;
						     Univ1_list = new JList<>(ud4.UOC);
					        Univ2_list = new JList<>(ud4.UOT);
						    
						}
						
						else if(ud4.Univ1.equals("University of calgary") && ud4.Univ1.equals("University Of Alberta") )
						{
							univ1_count=ud4.UOC.length;
						    univ2_count=ud4.UOA.length;
						 Univ1_list = new JList<>(ud4.UOC);
					       Univ2_list = new JList<>(ud4.UOA);
						    
						}
						else 
						{
							univ1_count=ud4.UOT.length;
						    univ2_count=ud4.UOA.length;
						     Univ1_list = new JList<>(ud4.UOT);
					         Univ2_list = new JList<>(ud4.UOA);
						    
						}
						
						
						
						JPanel panel = new JPanel(new BorderLayout(10, 10));
				        String text = String.format("Compared List Of  " +" " + ud4.Univ1+" & " +ud4.Univ2);
				        JLabel label = new JLabel(text);
				        panel.add(label, BorderLayout.PAGE_START);
				        
				        panel.add(Univ1_list, BorderLayout.CENTER);
						panel.add(Univ2_list, BorderLayout.WEST);
				        
				        if(Univ1_list != null || Univ2_list!=null){
				        JOptionPane.showMessageDialog(null, panel, "List OF Universties", JOptionPane.INFORMATION_MESSAGE);
				        
							System.out.println("Successfully compared");
				        }
						} else {
							label.setText("Comparision Failure");
							
						}
			
					
					frame.dispose();
					
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