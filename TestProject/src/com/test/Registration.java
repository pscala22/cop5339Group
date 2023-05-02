package com.test;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://Pauls-MacBook-Pro.local:3306/COP5339account";
    private static final String USER = "root";
    private static final String PASS = "Ps10222001";
    
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
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO COP5339account (username, password) VALUES (?, ?)");
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    int rows = stmt.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(null, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // close the registration window
                        new Login(); // open the login window
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while registering. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}
}
