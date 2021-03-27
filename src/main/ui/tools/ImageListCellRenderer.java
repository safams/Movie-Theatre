package ui.tools;

import javax.swing.*;
import java.awt.*;

//Class to create a ListCellRenderer to use for imageJList
public class ImageListCellRenderer implements ListCellRenderer {

    //EFFECTS: constructs a cell with colours and blank JLabel
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean is,
                                                  boolean cellHasFocus) {

        if (value instanceof JPanel) {
            Component c = (Component) value;
            c.setForeground(Color.white);
            c.setBackground(is ? UIManager.getColor("Table.focusCellForeground") : Color.black);
            return c;
        } else {
            return new JLabel("???");
        }
    }
}

