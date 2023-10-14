package employee.management.system.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(80,30, 1200, 80);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.darkGray);
        add(heading);
        
        JButton clickhere = new JButton("Click here to continue");
        clickhere.setBounds(300, 400, 300,70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.YELLOW);
        clickhere.addActionListener(this);
        add(clickhere);
        
        setSize(1000, 500);
        setVisible(true);
        setLocation(150, 50);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
   
    
    public static void main(String args[]) {
        new Splash();
    }
}
