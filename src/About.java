import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class About {
    public static void About(JFrame relativeWindow){
        JFrame about = new JFrame("About");
        about.setSize(1000, 500);

        about.setLocationRelativeTo(relativeWindow);
        about.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        about.setContentPane(panel);
        about.setVisible(true);


    }

}
