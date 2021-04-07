package ui;

//main class

import exceptions.NegativeBalanceException;

// main class, creates new GUI
public class Main {
    //main method to run program, catches negative balance exception
    public static void main(String[] args) {
        try {
            new MovieTheatreGUI();
        } catch (NegativeBalanceException e) {
            System.out.println("Error: Negative Balance");;
        }


    }
}
