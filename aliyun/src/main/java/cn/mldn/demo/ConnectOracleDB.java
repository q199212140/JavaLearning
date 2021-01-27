package cn.mldn.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectOracleDB {

    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@192.168.8.13:1521:orcl";
    private static final String DATABASE_USER = "scott";
    private static final String DATABASE_PASSWORD = "Soft12345";

    public static void main(String[] args) throws Exception {
        Connection conn = null;

        // ����

        String sql = "INSERT INTO news(nid,title,read,price,content,pubdate) " +
            " VALUES(news_seq.nextval,'MLDN-News',10,9.9,'������������', " +
            " TO_DATE('1981-04-05','yyyy-mm-dd'))";

        // �޸�
        // String sql = "UPDATE news SET title='�ش�����dddd', content='��������¶�Ϊ1��ddd',
        // read=99998 WHERE nid=5";

        // ɾ��
        //String sql = "DELETE FROM news WHERE nid IN (3,4,6)";

        System.out.println("Lesson 5.157.����Oracle���ݿ�");

        Class.forName(DATABASE_DRIVER);
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        System.out.println(conn);

        // �������ݿ��������
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        System.out.println("�ò���Ӱ���������" + count);

        // ����һ�أ������ˣ�û��Ҫ��Statement
        conn.close();

        System.out.println("\n��ѯ��");
        String querySql = "SELECT nid,title,read,price,content,pubdate FROM news";

        Class.forName(DATABASE_DRIVER);
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(querySql);
        while (rs.next()) {
            int nid = rs.getInt(1);
            String title = rs.getString(2);
            int read = rs.getInt(3);
            double price = rs.getDouble(4);
            String content = rs.getString(5);
            Date pubdate = rs.getDate(6);
            System.out.println(nid + "��" + title + "��" + read + "��" + price + "��" + content + "��" + pubdate);
        }

        // ����һ�أ������ˣ�û��Ҫ��Statement
        conn.close();

        System.out.println("\nLesson 5.161.ʹ��PreparedStatement�������ݿ⣺");

    }
}
