package ui.tools;

import ui.MovieTheatreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


//BalanceTool panel to display user's account balance and allow them to reload
public class BalanceTool extends JPanel {


    int balance;
    MovieTheatreGUI ui;
    JTextField input;
    JButton reloadButton;
    JLabel balanceLabel;
    JButton save;
    JButton load;


    //EFFECTS: constructs a BalanceTool with the movietheatre GUI passed in, sets up background
    ///        and layout, and calls methods in order of operations
    public BalanceTool(MovieTheatreGUI gui) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(56, 4, 14));
        ui = gui;
        setBalance();
        setReload();
        save();
        loadButton();
        this.validate();
    }

    //MODIFIES: this
    //EFFECTS: creates a JLabel that displays user's balance
    public void setBalance() {
        balance = ui.getBalance();
        balanceLabel = new JLabel("Your Current Balance: $" + balance);
        balanceLabel.setFont(new Font("SansSerif Plain", Font.BOLD, 18));
        balanceLabel.setForeground(Color.white);
        balanceLabel.setSize(50,50);
        this.add(balanceLabel);
    }

    //MODIFIES: this, balance
    //EFFECTS: creates a Reload button that and textfield to let user input money to add to balance
    public void setReload() {
        JLabel reloadLabel = new JLabel("Enter dollar amount to reload to account $:");
        reloadLabel.setForeground(Color.white);
        this.add(reloadLabel);
        input = new JTextField(1);
        input.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, input.getPreferredSize().height));
        reloadButton = new JButton("Reload");
        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();
                int amount = Integer.parseInt(text);
                ui.reload(amount);
                balanceLabel.setText("Your Current Balance: $" + ui.getBalance());
                balanceLabel.setForeground(Color.white);
            }
        });
        this.add(input);
        this.add(reloadButton);
    }


    //MODIFIES: this
    //EFFECTS: creates a new JButton to save the user's balance and list of tickets to file
    public void save() {
        save = new JButton("Save To File");
        this.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ui.save();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }

    //MODIFIES: this
    //EFFECTS: creates a new JButton to load the user's balance and list of tickets from file
    public void loadButton() {
        load = new JButton("Load From File");
        this.add(load);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ui.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }



}
