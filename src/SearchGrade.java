import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class SearchGrade {
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
        names.add("姓名");
        names.add("性别");
        names.add("专业");
        names.add("班级");
        names.add("入学日期");
        names.add("备注");
        names.add("教师文档");



        try {
            long start = System.currentTimeMillis();

            conn = DriverManager.getConnection("jdbc:mysql://118.31.60.105:3306/sssql01",
                    "SSSQL01", "Yyq132456");
            long end = System.currentTimeMillis();
            System.out.println(conn);
            System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from `Students`");
            //System.out.println("id\tname\tage\tsex");

            while (rs.next()){
                //System.out.println(rs.getString(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
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



        //System.out.print(data.get(1).get(0));

        /*for(int i=0;i<data.size();i++){
            for(int j=0;j<row.size();j++){

            }
        }*/

        /*Collections.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                System.out.print(data.get(1));



                return 0;
            }

        });*/







        JTable table = new JTable(model);
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);

        table.setRowHeight(30);

        table.setPreferredScrollableViewportSize(new Dimension(900,300));
        JScrollPane scrollPane = new JScrollPane(table);

        //panel.add(table.getTableHeader(), BorderLayout.NORTH);
        //panel.add(table, BorderLayout.CENTER);

        panel.add(scrollPane);

        SG.setContentPane(panel);
        SG.setVisible(true);


    }
}
