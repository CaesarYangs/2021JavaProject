import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class PersonalInformationChange {

    public static void PIChangeWindow(JFrame relativeWindow){
        JFrame PICW = new JFrame("个人信息查询");
        PICW.setSize(1000, 500);

        PICW.setLocationRelativeTo(relativeWindow);
        PICW.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        PICW.setContentPane(panel);
        PICW.setVisible(true);


    }
}
