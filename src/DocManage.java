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
public class DocManage {
    public static void docManage(JFrame relativeWindow){
        JFrame docManage = new JFrame("文档管理");
        docManage.setSize(1000, 500);

        docManage.setLocationRelativeTo(relativeWindow);
        docManage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        docManage.setContentPane(panel);
        docManage.setVisible(true);


    }
}
