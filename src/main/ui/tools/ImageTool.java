package ui.tools;

import ui.MovieTheatreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Designs a JPanel to display image icons and text
public class ImageTool extends JPanel {

    MovieTheatreGUI ui;
    JLabel imageLabel1;
    JLabel imageLabel2;
    JLabel imageLabel3;

    JLabel l1;
    JLabel l2;
    JLabel l3;

    JLabel label;


    JList images;
    Icon image1;
    Icon image2;
    Icon image3;

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    JScrollPane imagesScrollPane;
    JButton click;



    //EFFECTS: constructs imageTool JPanel with background colours and method calls and the MovieTheatreGUI passed in
    public ImageTool(MovieTheatreGUI gui) {
        this.setBackground(new Color(56, 4, 14));
        ui = gui;
        images = new JList();
        setUp();
        click = new JButton("Get Details");
        this.add(click);
        label = new JLabel();
        clickButton();
    }

    //EFFECTS: eventlistener for the details button click, sets the value of a JLabel to be a String
    private void clickButton() {
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = images.getSelectedIndex();
                if (i == 0) {
                    setStuff("  Rotten Tomatoes: 69%  ||  *****  ||  Robert Downey Jr., Chris Hemsworth...");
                } else if (i == 1) {
                    setStuff("  Rotten Tomatoes: 98%  ||   ***   ||  Matthew McConaughey, Anne Hathaway...");
                } else if (i == 2) {
                    setStuff("  Rotten Tomatoes: 45%  ||    *    ||  Kevin Hart, Karen Gillan... ");
                }
            }
        });
    }

    //MODIFIES: this
    //EFFECTS: sets t to be text of a JLabel and adds it to panel
    public void setStuff(String t) {
        label.setText(t);
        label.setForeground(Color.white);
        this.add(label);
        label.revalidate();
    }


    //MODIFIES: this
    //EFFECTS: creates imageicons of movie posters, adds to a JLabel, and then into a scrollable list
    public void setUp() {
        images.setCellRenderer(new ImageListCellRenderer());

        image1 = new ImageIcon("./data/Avengers.jpg");
        image2 = new ImageIcon("./data/Interstellar.jpg");
        image3 = new ImageIcon("./data/jumanji.jpg");

        imageLabel1 = new JLabel(image1, JLabel.LEFT);
        imageLabel2 = new JLabel(image2, JLabel.LEFT);
        imageLabel3 = new JLabel(image3, JLabel.LEFT);



        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel1.add(imageLabel1);
        panel2.add(imageLabel2);
        panel3.add(imageLabel3);

        Object[] panels = {panel1, panel2, panel3};

        images.setListData(panels);

        scrollableImage();
    }

    //MODIFIES: this
    //EFFECTS: customizes scrollable list visually and adds it to panel
    public void scrollableImage() {
        images.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        images.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        images.setFixedCellHeight(250);
        imagesScrollPane = new JScrollPane(images);
        imagesScrollPane.setMinimumSize(new Dimension(300, 100));
        images.setVisibleRowCount(1);
        this.add(imagesScrollPane);
    }

}
