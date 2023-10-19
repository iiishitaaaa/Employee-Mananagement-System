package employee.management.system.java;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton addEmp, updateEmp, removeEmp, viewEmp; 
    
    Home() {
        
        setLayout(null);
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(100,20, 1200, 80);
        heading.setFont(new Font("TAHOMA", Font.PLAIN, 60));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        addEmp = new JButton("Add Employee");
        addEmp.setBounds(300,200, 150, 40);
        addEmp.setBackground(Color.BLACK);
        addEmp.setForeground(Color.WHITE);
        addEmp.addActionListener(this);
        add(addEmp);
        
        viewEmp = new JButton("View Employee");
        viewEmp.setBounds(600,200, 150, 40);
        viewEmp.setBackground(Color.BLACK);
        viewEmp.setForeground(Color.WHITE);
        viewEmp.addActionListener(this);
        add(viewEmp);
        
        updateEmp = new JButton("Update Employee");
        updateEmp.setBounds(300,400, 150, 40);
        updateEmp.setBackground(Color.BLACK);
        updateEmp.setForeground(Color.WHITE);
        updateEmp.addActionListener(this);
        add(updateEmp);
        
        removeEmp = new JButton("Remove Employee");
        removeEmp.setBounds(600,400, 150, 40);
        removeEmp.setBackground(Color.BLACK);
        removeEmp.setForeground(Color.WHITE);
        removeEmp.addActionListener(this);
        add(removeEmp);
        
        setSize(1000, 500);
        setVisible(true);
        setLocation(150, 50);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        if(ae.getSource() == addEmp) {
            setVisible(false);
            new AddEmployee();
        }       
        else if (ae.getSource() == viewEmp) {
            setVisible(false);
            new ViewEmployee();
        }
        else if (ae.getSource() == updateEmp) {
            setVisible(false);
            new ViewEmployee();
        }
        else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]) {
        new Home();
    }
}
