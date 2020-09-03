package cn.mldn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class PreparedStatementDemo
{
    private static final String DATABASE_DRIVER   = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL      = "jdbc:oracle:thin:@192.168.8.13:1521:orcl";
    private static final String DATABASE_USER     = "scott";
    private static final String DATABASE_PASSWORD = "Soft12345";
    
    public static void main(String[] args) throws Exception
    {
        Connection conn = null;
        
        System.out.println("Lesson 5.162.PreparedStatement：添加：");
        
        String title = "新闻'老李写的";
        int read = 99;
        double price = 99.89;
        String content = "滨江地区小雨";
        Date pubdate = new Date();
        
        String sql = "INSERT INTO news(nid,title,read,price,content,pubdate) VALUES"
                + "(news_seq.nextval,?,?,?,?,?)";//问号作为占位符
                       
        Class.forName(DATABASE_DRIVER);
        conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        System.out.println(conn);

        // 创建数据库操作对象
        PreparedStatement pstmt  = conn.prepareStatement(sql);
                
        //在执行具体数据库操作之前需要为占位符设置内容
        pstmt.setString(1, title);
        pstmt.setInt(2, read);
        pstmt.setDouble(3, price);
        pstmt.setString(4, content);
        pstmt.setDate(5, new java.sql.Date(pubdate.getTime()));
        
        int count = pstmt.executeUpdate();       
        System.out.println("更创新操作影响的数据行数：" + count);
        
                    
        System.out.println("Lesson 5.163.使用PreparedStatement实现数据查询操作：查询");
        String querySql = "SELECT nid,title,read,price,content,pubdate FROM news";
        
        pstmt  = conn.prepareStatement(querySql);
        System.out.println("查询全部数据:");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next())
        {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(nid + "、" + titleTmp + "、" + readTmp + "、" + priceTmp + "、" + contentTmp + "、" + pubdateTmp);
        }
        
        System.out.println("\n查询根据id查询:");
        String querySqlWithID = "SELECT nid,title,read,price,content,pubdate FROM news WHERE nid=?";
        pstmt  = conn.prepareStatement(querySqlWithID);
        pstmt.setInt(1, 5);
        rs = pstmt.executeQuery();
        while(rs.next())
        {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(nid + "、" + titleTmp + "、" + readTmp + "、" + priceTmp + "、" + contentTmp + "、" + pubdateTmp);
        }

        System.out.println("\n分页查询(带模糊):返回所有查询结果，如果结果很多时内存会溢出：");
        int currentPage = 3;//输出的页数序号
        int lineSize = 4;
        String column = "title";//模糊查询列
        String keyWord = "MLDN";        
        String querySqlWithPages = "SELECT * FROM ( "
                + "SELECT nid,title,read,price,content,pubdate，ROWNUM rn "
                + "FROM news WHERE " + column + " LIKE ? AND ROWNUM<=? ORDER BY nid) temp "
                + "WHERE temp.rn>?";
        
        pstmt  = conn.prepareStatement(querySqlWithPages);
        pstmt.setString(1, "%" + keyWord + "%");
        pstmt.setInt(2, currentPage * lineSize);//总页数
        pstmt.setInt(3, (currentPage - 1) * lineSize);//总页数
        
        rs = pstmt.executeQuery();
        while(rs.next())
        {
            int nid = rs.getInt(1);
            String titleTmp = rs.getString(2);
            int readTmp = rs.getInt(3);
            double priceTmp = rs.getDouble(4);
            String contentTmp = rs.getString(5);
            Date pubdateTmp = rs.getDate(6);
            System.out.println(nid + "、" + titleTmp + "、" + readTmp + "、" + priceTmp + "、" + contentTmp + "、" + pubdateTmp);
        }
        
        System.out.println("\n统计指定关键字标题的新闻数量：");
        String queryCountSql = "SELECT COUNT(*) FROM news WHERE " + column + " LIKE ?";
        pstmt  = conn.prepareStatement(queryCountSql);
        pstmt.setString(1, "%" + keyWord + "%");
        rs = pstmt.executeQuery();
        if(rs.next())
        {
            long n = rs.getLong(1);
            System.out.println("符合条件数据量：" + n);
        }
        
        conn.close();
    }
}
