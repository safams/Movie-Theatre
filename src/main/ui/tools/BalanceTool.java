package ui.tools;

import ui.MovieTheatreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceTool extends JPanel implements ActionListener {

    private static final String RELOAD_COMMAND = "reload";
    private static JLabel currentBalance;
    int balance;
    MovieTheatreGUI ui;
    JTextField input;
    JButton reloadButton;
    JLabel balanceLabel;


    public BalanceTool(MovieTheatreGUI gui) {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(161, 209, 209));
        ui = gui;
        setBalance();
        setReload();
    }

    public void setBalance() {
        balance = ui.getBalance();
        balanceLabel = new JLabel("Your Current Balance: $" + balance);
        this.add(balanceLabel, BorderLayout.PAGE_START);
    }

    private void setReload() {
        JLabel reloadLabel = new JLabel("Enter dollar amount to reload to account $:");
        this.add(reloadLabel, BorderLayout.BEFORE_LINE_BEGINS);
        input = new JTextField("", 5);
        reloadButton = new JButton("Reload");
        reloadButton.addActionListener(this);
        this.add(input);
        this.add(reloadButton, BorderLayout.AFTER_LAST_LINE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = input.getText();
        int amount = Integer.parseInt(text);
        ui.reload(amount);
        balanceLabel.setText("Current Balance: $" + ui.getBalance());
    }



    //add "enter dollar amount" text
    //add button with "reload" label
    //add text entry field









}
