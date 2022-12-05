package swingdemo;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Compare extends JFrame {
 
	
	JLabel message;  
    JLabel university_name_Label,compare_with_Label,compare_parameter_Label;
    JComboBox university_name_Field,compare_with_Field,compare_parameter_Field;
    JButton compareButton;
    Container container;
    String university_list[]={"University of calgary","Alberta University","Ontario University"};
    String compare_parameters[]={"University_ranking","Fee_Structure","Course_Ranking"};
    public Compare() {
        message = new JLabel("Compare Form");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        university_name_Label = new JLabel("University_Name");
        university_name_Field = new JComboBox(university_list);
        compare_with_Label = new JLabel("Compare_with");
        compare_with_Field = new JComboBox(university_list);
        compare_parameter_Label = new JLabel("Comparision_basedOn");
        compare_parameter_Field = new JComboBox(compare_parameters);
        
        compareButton = new JButton("Compare");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
 
    }
 
    public void setBounds() {
        message.setBounds(50, 10, 600, 30);
        university_name_Label.setBounds(50, 60, 100, 30);
        university_name_Field.setBounds(180, 60, 200, 30);
 
        compare_with_Label.setBounds(50, 110, 100, 30); 
        compare_with_Field.setBounds(180,110, 200, 30 );
        
        compare_parameter_Label.setBounds(50, 160, 100, 30); 
        compare_parameter_Field.setBounds(180, 160, 200, 30 );
 
        compareButton.setBounds(130, 220, 240, 30);
    }
 
    public void addComponents() {
        container.add(message);
        container.add(university_name_Label);
        container.add(university_name_Field);
        container.add(compare_with_Label);
        container.add(compare_with_Field);
        
        container.add(compare_parameter_Label);
        container.add(compare_parameter_Field);
        
        container.add(compareButton);
    }

    public static void main(String[] args)
    {
        Compare frame = new Compare();
        frame.setTitle("Compare Form");
        frame.setVisible(true);
        frame.setBounds(500, 100, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
 
    }
   
    
}