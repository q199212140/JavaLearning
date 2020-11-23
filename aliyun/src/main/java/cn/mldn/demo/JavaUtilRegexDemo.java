package cn.mldn.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtilRegexDemo {

    public static void main(String[] args) {
        System.out
            .println("java.util.regex��֧��[��֡��滻��ƥ�䣬����Ҫjava.util.regex��������String�����㣬regex���й��������]��");
        //ȥ��#{Ŀ�괮}����е��������ݡ����������鹦��
        String DbStr = "INSERT INTO dept(deptno,dname,loc) VALUE (#{DEPTNO},#{dname},#{loc})";
        String DbRex = "#\\{\\w+\\}";
        Pattern pat = Pattern.compile(DbRex);
        Matcher mat = pat.matcher(DbStr);
        while (mat.find()) {
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}", ""));
        }
    }
}
