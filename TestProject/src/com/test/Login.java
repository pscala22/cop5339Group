package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://Pauls-MacBook-Pro.local:3306/COP5339account";
    private static final String USER = "root";
    private static final String PASS = "Ps10222001";

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
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM COP5339account WHERE username=? AND password=?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            stmt.close();
            conn.close();
            return count > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while validating login. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void main(String[] args) {
        new Login();
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }
}
