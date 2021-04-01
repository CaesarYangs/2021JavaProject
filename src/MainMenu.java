import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public static void MainWindow(JFrame relativeWindow){
        JFrame Mmenu = new JFrame("MainMenu");

        Mmenu.setSize(1500, 800);

        // 把新窗口的位置设置到 relativeWindow 窗口的中心
        Mmenu.setLocationRelativeTo(relativeWindow);

        // 点击窗口关闭按钮, 执行销毁窗口操作（如果设置为 EXIT_ON_CLOSE, 则点击新窗口关闭按钮后, 整个进程将结束）
        Mmenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        //----------menu--------------

        JMenuBar menuBar = new JMenuBar();

        JMenu micon = new JMenu(" ");
        JMenu fileMenu = new JMenu("文件");
        JMenu editMenu = new JMenu("编辑");
        JMenu viewMenu = new JMenu("视图");
        JMenu helpMenu = new JMenu("帮助");
        JMenu aboutMenu = new JMenu("关于");

        menuBar.add(micon);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);

        //文件 子菜单
        JMenuItem file_open = new JMenuItem("打开");
        JMenuItem file_new = new JMenuItem("新建");
        JMenuItem file_quit = new JMenuItem("退出");
        fileMenu.add(file_new);
        fileMenu.add(file_open);
        fileMenu.addSeparator();
        fileMenu.add(file_quit);

        file_quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(
                        Mmenu,
                        "确认退出？",
                        "提示",
                        JOptionPane.YES_NO_OPTION
                );

                if(result==0){
                    Mmenu.dispose();
                    System.exit(0);
                }


            }
        });


        //编辑 子菜单
        //视图 子菜单
        //帮助 子菜单
        //关于 子菜单

        Mmenu.setJMenuBar(menuBar);


        //主界面视图
        GroupLayout levelhead = new GroupLayout(panel);
        panel.setLayout(levelhead);
        levelhead.setAutoCreateGaps(true);
        levelhead.setAutoCreateContainerGaps(true);

        JLabel H1label = new JLabel();
        H1label.setText("准毕业生管理系统");
        JButton Mbt01 = new JButton("测试按钮");

        GroupLayout.SequentialGroup hSeqGroup = levelhead.createSequentialGroup().addGap(35).addComponent(H1label).addGap(20).addComponent(Mbt01);

        levelhead.setHorizontalGroup(hSeqGroup);

        GroupLayout.ParallelGroup vParalGroup01 = levelhead.createParallelGroup().addGap(300).addComponent(H1label).addComponent(Mbt01);




        levelhead.setVerticalGroup(vParalGroup01);


        Mmenu.setContentPane(panel);
        Mmenu.setVisible(true);        // PS: 最后再设置为可显示(绘制), 所有添加的组件才会显示


    }
}
