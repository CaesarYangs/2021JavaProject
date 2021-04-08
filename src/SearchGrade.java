import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class SearchGrade {
    static class GradeComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if((float)o1>(float)o2){
                return 1;
            }else if((float)o1<(float)o2){
                return -1;
            }else {
                return 0;
            }

        }
    }

    public static void searchgrade(JFrame relativeWindow){
        JFrame SG = new JFrame("成绩查询");
        SG.setSize(1000, 500);

        SG.setLocationRelativeTo(relativeWindow);
        SG.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());

        DefaultTableModel model = new DefaultTableModel();
        Vector row = new Vector();
        Vector<Vector> data = new Vector();
        Vector names = new Vector();
        model.setDataVector(data, names);


        //database connect
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        names.add("学号");
        names.add("总加权");
        names.add("公共基础课加权");
        names.add("专业课加权");
        names.add("学分通过率");
        names.add("获奖情况");
        names.add("加分");
        names.add("备注");



        try {
            long start = System.currentTimeMillis();

            conn = DriverManager.getConnection("jdbc:mysql://118.31.60.105:3306/sssql01",
                    "SSSQL01", "Yyq132456");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            stmt = conn.createStatement();

            if(LoginWindow.Status!=1){
                rs = stmt.executeQuery("select * from `StudentGrades`");
                //System.out.println("id\tname\tage\tsex");

                while (rs.next()){
                    row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getString(4));
                    row.add(rs.getString(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    row.add(rs.getString(8));

                    data.add(row);

                }
            }else {
                rs = stmt.executeQuery("SELECT * FROM StudentGrades WHERE ID ="+LoginWindow.Username);
                rs.next();
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                row.add(rs.getString(8));

                data.add(row);
            }

        }catch (SQLException d) {
            d.printStackTrace();
        }


        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton SG_01 = new JButton("按总学分排序");
        SG_01.setFont(new Font(null,Font.ITALIC,15));

        /*Collections.sort(data, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                if((float)o1.get(1)>(float)o2.get(1)){
                    return 1;
                }else if((float)o1.get(1)<(float)o2.get(1)){
                    return -1;
                }else {
                    return 0;
                }

            }

        });*/

        Vector finalRow = row;
        SG_01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i=0;i<data.size();i++){
                    boolean flag = true;
                    for(int j=0;j<data.size()-i-1;j++){
                        if(Float.parseFloat((String) data.get(j).get(1))<Float.parseFloat((String) data.get(j+1).get(1))){
                            Vector tmp = new Vector();
                            tmp.add(data.get(j+1));
                            data.set(j+1,data.get(j));
                            data.set(j, (Vector) tmp.firstElement());

                            flag = false;
                        }
                    }
                }


                table.updateUI();
                scrollPane.updateUI();
            }
        });

        /*Collections.sort(data, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {

                if((float)o1.get(1)>(float)o2.get(1)){
                    return 1;
                }else if((float)o1.get(1)<(float)o2.get(1)){
                    return -1;
                }else {
                    return 0;
                }

            }

        });*/


        //System.out.print(data.get(1).get(0));

        /*for(int i=0;i<data.size();i++){
            for(int j=0;j<row.size();j++){

            }
        }*/










        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);

        table.setRowHeight(30);

        table.setPreferredScrollableViewportSize(new Dimension(900,300));


        //panel.add(table.getTableHeader(), BorderLayout.NORTH);
        //panel.add(table, BorderLayout.CENTER);

        panel.add(SG_01);
        panel.add(scrollPane);

        SG.setContentPane(panel);
        SG.setVisible(true);


    }
}
