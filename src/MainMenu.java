import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public static void MainWindow(JFrame relativeWindow){
        JFrame Mmenu = new JFrame("MainMenu");

        Mmenu.setSize(1500, 900);

        // 把新窗口的位置设置到 relativeWindow 窗口的中心
        Mmenu.setLocationRelativeTo(relativeWindow);

        // 点击窗口关闭按钮, 执行销毁窗口操作（如果设置为 EXIT_ON_CLOSE, 则点击新窗口关闭按钮后, 整个进程将结束）
        Mmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        JButton btn01 = new JButton("按钮01");
        JButton btn02 = new JButton("按钮02");
        JButton btn03 = new JButton("按钮03");
        JButton btn04 = new JButton("按钮04");
        JButton btn05 = new JButton("按钮05");



        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);



        Mmenu.setContentPane(panel);
        Mmenu.setVisible(true);        // PS: 最后再设置为可显示(绘制), 所有添加的组件才会显示


    }
}
