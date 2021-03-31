

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginWindow {

    public static String Username;
    public static String Password;

    LoginWindow(){
        Username = "admin";
        Password = "132456";
    }

    public static void LoginW(JFrame relativeWindow) {
        Username = "admin";
        Password = "132456";

        JFrame newJFrame = new JFrame("登陆");

        newJFrame.setSize(700, 400);

        // 把新窗口的位置设置到 relativeWindow 窗口的中心
        newJFrame.setLocationRelativeTo(relativeWindow);

        // 点击窗口关闭按钮, 执行销毁窗口操作（如果设置为 EXIT_ON_CLOSE, 则点击新窗口关闭按钮后, 整个进程将结束）
        newJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        Box hBox01 = Box.createVerticalBox();
        Box user = Box.createHorizontalBox();
        Box pass = Box.createHorizontalBox();
        Box loginbuttons = Box.createHorizontalBox();

        JLabel biglable01 = new JLabel();
        biglable01.setText("系统登陆");

        JLabel label01 = new JLabel();
        label01.setText("用户名");
        //label01.setFont(new Font(null, Font.PLAIN, 25));  // 设置字体，null 表示使用默认字体
        final JTextField textField = new JTextField(8);


        JLabel label02 = new JLabel();
        label02.setText("密码 ");
        final JPasswordField passwordField = new JPasswordField(10);



        JButton login = new JButton("登陆");
        final JButton register = new JButton("注册");

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String u = textField.getText();
                String p = new String(passwordField.getPassword());

                if(u.equals(Username)&&p.equals(Password)) {
                    MainMenu.MainWindow(newJFrame);
                    newJFrame.dispose();

                }else {

                }

            }
        });

        Component hGlue = Box.createHorizontalStrut(20);
        Component vGlue = Box.createVerticalStrut(10);


        user.add(hGlue);
        user.add(label01);
        user.add(textField);
        user.add(hGlue);


        pass.add(hGlue);
        pass.add(label02);
        pass.add(passwordField);
        pass.add(hGlue);

        loginbuttons.add(login);
        loginbuttons.add(register);


        hBox01.add(vGlue);
        hBox01.add(user);
        hBox01.add(vGlue);
        hBox01.add(pass);
        hBox01.add(vGlue);
        hBox01.add(loginbuttons);

        newJFrame.setContentPane(hBox01);
        newJFrame.pack();
        newJFrame.setVisible(true);
    }
}
