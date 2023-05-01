package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShoppingCart extends JFrame {
    
    private static final long serialVersionUID = 1L;
	private JLabel itemLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JTextField itemField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton addButton;
    private JButton clearButton;
    private JTextArea cartArea;
    private JButton checkOut;
    private double totalPrice = 0;
    
    public ShoppingCart() {
        super("Shopping Cart");
        
        itemLabel = new JLabel("Item:");
        priceLabel = new JLabel("Price:");
        quantityLabel = new JLabel("Quantity:");
        itemField = new JTextField(10);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);
        addButton = new JButton("Add to Cart");
        clearButton = new JButton("Clear Cart");
        cartArea = new JTextArea(20, 40);
        checkOut = new JButton("Check Out");
        JScrollPane scrollPane = new JScrollPane(cartArea);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(itemLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(itemField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(priceLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(priceField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(quantityLabel, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(quantityField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(addButton, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(clearButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        panel.add(checkOut, constraints);
        
        JPanel cartPanel = new JPanel();
        cartPanel.add(scrollPane);
        
        add(panel, BorderLayout.NORTH);
        add(cartPanel, BorderLayout.CENTER);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = itemField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                double total = price * quantity;
                
                cartArea.append(item + " x " + quantity + " @ $" + price + " each = $" + total + "\n");
                
                totalPrice += total;
                setTitle("Shopping Cart - Total: $" + totalPrice);
                
                itemField.setText("");
                priceField.setText("");
                quantityField.setText("");
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cartArea.setText("");
                totalPrice = 0;
                setTitle("Shopping Cart");
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ShoppingCart();
    }
}
