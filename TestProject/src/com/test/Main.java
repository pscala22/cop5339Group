package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    public Main() {
        super("Main");

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Registration();
            }
        });
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });
        JButton shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ShoppingCart();
            }
        });

        JPanel panel = new JPanel();
        panel.add(registerButton);
        panel.add(loginButton);
        panel.add(shoppingCartButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
