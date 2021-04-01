package ui;

//main class

import exceptions.NegativeBalanceException;

public class Main {
    public static void main(String[] args) {
        try {
            new MovieTheatreGUI();
        } catch (NegativeBalanceException e) {
            System.out.println("Error: Negative Balance");;
        }


    }
}
