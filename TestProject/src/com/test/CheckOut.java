package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckOut extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel checkOut;
    private JButton cashPay;
    private JButton backBtn;
    private JButton cardPay;
    private JTextArea Cart;
    private JScrollPane scrollPane;

    public CheckOut() {

        checkOut = new JLabel("CHECK OUT");
        cashPay = new JButton("Cash");
        cardPay = new JButton("Card");
        backBtn = new JButton("Back");
        Cart = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(Cart);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;

        constraints.gridx = 3;
        constraints.gridy = 3;
        panel.add(checkOut, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(cashPay, constraints);

        constraints.gridx = 4;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(cardPay, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        panel.add(backBtn, constraints);

        JPanel cartPanel = new JPanel();
        cartPanel.add(scrollPane);


        add(panel, BorderLayout.CENTER);
        add(cartPanel, BorderLayout.NORTH);

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOut.this.setVisible(false);
                ShoppingCart.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}