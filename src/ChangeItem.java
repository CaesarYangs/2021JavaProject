import javax.swing.*;
import java.awt.*;

public class ChangeItem {

    public static void changeitem(JFrame relativeWindow){
        JFrame changeitem = new JFrame("修改项目");
        changeitem.setSize(1000, 500);

        changeitem.setLocationRelativeTo(relativeWindow);
        changeitem.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());


        changeitem.setContentPane(panel);
        changeitem.setVisible(true);


    }
}
