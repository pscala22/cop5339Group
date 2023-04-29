package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    
    public Registration() {
        super("Registration");
        
        nameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        nameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        registerButton = new JButton("Register");
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nameField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(passwordField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(registerButton, constraints);
        
        add(panel, BorderLayout.NORTH);
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("password")) {
                    dispose();
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Registration();
    }
}

