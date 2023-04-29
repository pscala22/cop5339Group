package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    
    public Login() {
        super("Login");
        
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField(10);
        passField = new JPasswordField(10);
        loginButton = new JButton("Login");
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(userLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(userField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(passField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        panel.add(loginButton, constraints);
        
        add(panel);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                
                // check if username and password are valid
                if (isValidLogin(username, password)) {
                    // create an instance of the ShoppingCart class
                    ShoppingCart cart = new ShoppingCart();
                    cart.setVisible(true);
                    
                    // hide the login window
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private boolean isValidLogin(String username, String password) {
        // replace this with your own code to validate username and password
        return (username.equals("admin") && password.equals("password"));
    }
    
    public static void main(String[] args) {
        new Login();
    }
}


