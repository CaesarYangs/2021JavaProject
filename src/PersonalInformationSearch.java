import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class PersonalInformationSearch {
    public static void PISearchWindow(JFrame relativeWindow){
        JFrame PISW = new JFrame("个人信息查询");
        PISW.setSize(1000, 500);

        PISW.setLocationRelativeTo(relativeWindow);
        PISW.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        Object[] columnNames = {"姓名", "语文", "数学", "英语", "总分"};
        Object[][] rowData = {
                {"张三", 80, 80, 80, 240},
                {"John", 70, 80, 90, 240},
                {"Sue", 70, 70, 70, 210},
                {"Jane", 80, 70, 60, 210},
                {"Joe", 80, 70, 60, 210}
        };

        JTable table = new JTable(rowData, columnNames);
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        //panel.add(table, BorderLayout.CENTER);

        panel.add(table);
        PISW.setContentPane(panel);
        PISW.setVisible(true);



    }
}
