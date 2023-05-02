package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShoppingCart extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel fruitLabel;
    private JComboBox<String> fruitList;
    private JPanel quantityPanel;
    private JLabel priceLabel;
    private JTextField priceField;
    private JButton addButton;
    private JButton clearButton;
    private JTextArea cartArea;
    private double totalPrice;
    
    private String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes", "Pineapple", "Watermelon"};
    private double[] prices = {1.00, 0.75, 1.50, 2.00, 1.25, 2.50, 3.00};
    private int[] quantities = {0, 0, 0, 0, 0, 0, 0};
    
    public ShoppingCart() {
        super("Shopping Cart");
        
        fruitLabel = new JLabel("Fruit:");
        fruitList = new JComboBox<String>(fruits);
        quantityPanel = new JPanel(new GridLayout(1, 3));
        JLabel quantityLabel = new JLabel("Quantity:");
        JButton minusButton = new JButton("-");
        JTextField quantityField = new JTextField(2);
        JButton plusButton = new JButton("+");
        quantityField.setEditable(false);
        quantityPanel.add(minusButton);
        quantityPanel.add(quantityField);
        quantityPanel.add(plusButton);
        
        priceLabel = new JLabel("Price:");
        priceField = new JTextField(10);
        priceField.setEditable(false);
        addButton = new JButton("Add to Cart");
        clearButton = new JButton("Clear Cart");
        cartArea = new JTextArea(10, 30);
        
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(fruitLabel);
        inputPanel.add(fruitList);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityPanel);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(cartArea, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fruit = (String) fruitList.getSelectedItem();
                int quantity = quantities[fruitList.getSelectedIndex()];
                double price = prices[fruitList.getSelectedIndex()];
                double total = price * quantity;

                cartArea.append(fruit + " x " + quantity + " @ $" + price + " each = $" + total + "\n");

                totalPrice += total;
                setTitle("Shopping Cart - Total: $" + totalPrice);

                quantities[fruitList.getSelectedIndex()] = 0;
                quantityField.setText("0");
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cartArea.setText("");
                totalPrice = 0;
                setTitle("Shopping Cart");
                fruitList.setSelectedIndex(0);
                for (int i = 0; i < quantities.length; i++) {
                    quantities[i] = 0;
                }
                quantityField.setText("0");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fruit = (String) fruitList.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = prices[fruitList.getSelectedIndex()];
                if (quantity > 0) {
                    quantity--;
                    cartArea.append("- " + fruit + " x " + quantity + " @ $" + price + " each = -$" + price + "\n");
                    totalPrice -= price;
                    setTitle("Shopping Cart - Total: $" + totalPrice);
                    quantityField.setText(Integer.toString(quantity));
                }
            }
         });
 
        plusButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String fruit = (String) fruitList.getSelectedItem();
        		int quantity = Integer.parseInt(quantityField.getText());
        		double price = prices[fruitList.getSelectedIndex()];
        		quantity++;
        		cartArea.append("+ " + fruit + " x " + quantity + " @ $" + price + " each = +$" + price + "\n");
        		totalPrice += price;
        		setTitle("Shopping Cart - Total: $" + totalPrice);
        		quantityField.setText(Integer.toString(quantity));
        		}
 }			);

        fruitList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	int quantity = quantities[fruitList.getSelectedIndex()];
        	double price = prices[fruitList.getSelectedIndex()];
        priceField.setText(Double.toString(price));
        quantityField.setText(Integer.toString(quantity));
    }
});

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
    	}

};