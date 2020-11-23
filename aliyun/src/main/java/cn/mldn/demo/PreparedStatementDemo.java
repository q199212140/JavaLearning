package cn.mldn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class PreparedStatementDemo {

    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@192.168.8.13:1521:orcl";
    private static final String DATABASE_USER = "scott";
    private static final String DATABASE_PASSWORD = "Soft12345";

    public static void main(String[] args) throws Exception {
        Connection conn = null;

        System.out.println("Lesson 5.162.PreparedStatement����ӣ�");

        String title = "����'����д��";
        int read = 99;
        double price = 99.89;
        String content = "��������С��";
        Date pubdate = new Date();

        String sql = "INSERT INTO news(nid,title,read,price,content,pubdate) VALUES"
            + "(news_seq.nextval,?,?,?,?,?)";//�ʺ���Ϊռλ��

        Class.forName(DATABASE_DRIVER);
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        System.out.println(conn);

        // �������ݿ��������
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //��ִ�о������ݿ����֮ǰ��ҪΪռλ����������
        pstmt.setString(1, title);
        pstmt.setInt(2, read);
        pstmt.setDouble(3, price);
        pstmt.setString(4, content);
        pstmt.setDate(5, new java.sql.Date(pubdate.getTime()));

        int count = pstmt.executeUpdate();
        System.out.println("�����²���Ӱ�������������" + count);

        System.out.println("Lesson 5.163.ʹ��PreparedStatementʵ�����ݲ�ѯ��������ѯ");
        String querySql = "SELECT nid,title,read,price,content,pubdate FROM news";

        pstmt = conn.prepareStatement(querySql);
        System.out.println("��ѯȫ������:");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(
                nid + "��" + titleTmp + "��" + readTmp + "��" + priceTmp + "��" + contentTmp + "��" + pubdateTmp);
        }

        System.out.println("\n��ѯ����id��ѯ:");
        String querySqlWithID = "SELECT nid,title,read,price,content,pubdate FROM news WHERE nid=?";
        pstmt = conn.prepareStatement(querySqlWithID);
        pstmt.setInt(1, 5);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(
                nid + "��" + titleTmp + "��" + readTmp + "��" + priceTmp + "��" + contentTmp + "��" + pubdateTmp);
        }

        System.out.println("\n��ҳ��ѯ(��ģ��):�������в�ѯ������������ܶ�ʱ�ڴ�������");
        int currentPage = 3;//�����ҳ�����
        int lineSize = 4;
        String column = "title";//ģ����ѯ��
        String keyWord = "MLDN";
        String querySqlWithPages = "SELECT * FROM ( "
            + "SELECT nid,title,read,price,content,pubdate��ROWNUM rn "
            + "FROM news WHERE " + column + " LIKE ? AND ROWNUM<=? ORDER BY nid) temp "
            + "WHERE temp.rn>?";

        pstmt = conn.prepareStatement(querySqlWithPages);
        pstmt.setString(1, "%" + keyWord + "%");
        pstmt.setInt(2, currentPage * lineSize);//��ҳ��
        pstmt.setInt(3, (currentPage - 1) * lineSize);//��ҳ��

        rs = pstmt.executeQuery();
        while (rs.next()) {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(
                nid + "��" + titleTmp + "��" + readTmp + "��" + priceTmp + "��" + contentTmp + "��" + pubdateTmp);
        }

        System.out.println("\nͳ��ָ���ؼ��ֱ��������������");
        String queryCountSql = "SELECT COUNT(*) FROM news WHERE " + column + " LIKE ?";
        pstmt = conn.prepareStatement(queryCountSql);
        pstmt.setString(1, "%" + keyWord + "%");
        rs = pstmt.executeQuery();
        if (rs.next()) {
            long n = rs.getLong(1);
            System.out.println("����������������" + n);
        }

        conn.close();
    }
}
