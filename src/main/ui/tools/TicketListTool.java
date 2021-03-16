package ui.tools;

import model.Movie;
import ui.MovieTheatre;
import ui.MovieTheatreGUI;

import javax.swing.*;
import java.awt.*;

public class TicketListTool extends JPanel {

    MovieTheatreGUI ui;

    private static final String CANCEL_COMMAND = "cancel";
    private static final String SAVE_COMMAND = "save";
    private static final String LOAD_COMMAND = "load";

    public TicketListTool(MovieTheatreGUI gui) {
        this.setBackground(new Color(196, 199, 242));
        ui = gui;
    }

}
