import javax.swing.*;
import java.awt.*;

public class LogDoc {

    public static void logdoc(JFrame relativeWindow){
        JFrame log = new JFrame("教师录入文档");
        log.setSize(1000, 500);

        log.setLocationRelativeTo(relativeWindow);
        log.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        log.setContentPane(panel);
        log.setVisible(true);


    }

}
