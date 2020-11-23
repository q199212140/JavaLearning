package cn.mldn.demo;

public class RegularExpressionDemo {

    public static void main(String[] args) {
        System.out.println("\n������ʽ��");

        System.out.println("\n�������룺");
        String strInput = "12a3";
        if (strInput.matches("\\d+")) {
            int num = Integer.parseInt(strInput);
            System.out.println(num * 2);
        }

        System.out.println("\n����ƥ�����ⵥ��ĸ��");
        String strREInput = "a";
        String strRE = "b";
        System.out.println(strREInput.matches(strRE));

        System.out.println("\n����ƥ���ַ�����");
        String strREInput1 = "a";
        String strRE1 = "[abc]";
        String strRE2 = "[^abc]";
        System.out.println(strREInput1.matches(strRE1));
        System.out.println(strREInput1.matches(strRE2));

        System.out.println("\n����ƥ�䣺");
        String strREInput3 = "";
        String strRE3 = "\\w+";
        System.out.println(strREInput3.matches(strRE3));

        System.out.println("\n����ƥ�䣺");
        String strREInput4 = "a";
        String strRE4 = "\\w{3,}";
        System.out.println(strREInput4.matches(strRE4));
    }
}
