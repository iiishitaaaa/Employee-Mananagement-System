package employee.management.system.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice empChoice; 
    JButton delete, back;
    
    RemoveEmployee() {
        
        JLabel empIDToDel = new JLabel("Employee ID");
        empIDToDel.setBounds(50, 50, 100, 30);
        add(empIDToDel);
        
        empChoice = new Choice();
        empChoice.setBounds(200, 50, 100, 30);
        add(empChoice);
        
        try{
            Connect c = new Connect();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                empChoice.add(rs.getString("empID"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);
        
        try{
            Connect c = new Connect();
            String query = "select * from employee where empID = '"+empChoice.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        empChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Connect c = new Connect();
                    String query = "select * from employee where empID = '"+empChoice.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
                
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        setSize(1000, 600);
        setLocation(150, 50);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == delete) {
            try {
                Connect c = new Connect();
                String query = "delete from employee where empID = '"+empChoice.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new RemoveEmployee();
    }
}
