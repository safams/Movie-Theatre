package ui.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//From stackOverfow, class to turn an icon into an image
public class IconToImage {
    Icon icon;
    Image image;


    //EFFECTS: constructor
    public IconToImage(Icon icon) {
        this.icon = icon;
        image = iconToImage();
    }

    //EFFECTS: converts an icon to an instance of an image
    public Image iconToImage() {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon)icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }


    /**
     * @return the image
     */
    //EFFECTS: returns constructed image
    public Image getImage() {
        return image;
    }
}
