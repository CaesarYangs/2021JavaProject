import javax.swing.*;
import java.awt.*;

public class SearchGrade {
    public static void searchgrade(JFrame relativeWindow){
        JFrame SG = new JFrame("成绩查询");
        SG.setSize(1000, 500);

        SG.setLocationRelativeTo(relativeWindow);
        SG.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        SG.setContentPane(panel);
        SG.setVisible(true);


    }
}
