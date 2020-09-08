package com.sunil.sun.lesson;

import java.text.ParseException;
import java.util.UUID;

/**
 * @ClassName JavaApiDemo
 * @Description 第7章 java常用类库
 * @Author jian.sun.qd
 * @Date 26/08/2020 10:30
 * @Version 1.0
 **/
/*
7.26 StringBuffer
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "Hello ";
//        change(str);
//        System.out.println(str);
//    }
//    public static void change(String temp) { //内容未改变
//        temp += "World !";
//    }
//}
//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("Hello ");
//        change(sb);
//        System.out.println(sb);
//    }
//    public static void change(StringBuffer temp) {
//        temp.append("World ！"); //内容改变
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        StringBuffer buf = new StringBuffer();
//        buf.append(".com").insert(0,"www.").insert(4,"faw");
//        System.out.println(buf);
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        StringBuffer buf = new StringBuffer();
//        buf.append("Hello World !").delete(6,12).insert(6, "VW");
//        System.out.println(buf);
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        StringBuffer buf = new StringBuffer();
//        buf.append("Hello World !");
//        System.out.println(buf.reverse());
//    }
//}

/*
7.27 CharSequence
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        CharSequence str = "www.faw.com";  //子类实例向父接口转型
//    }
//}
//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        CharSequence str = "www.faw.com";
//        CharSequence sub = str.subSequence(4,7);
//        System.out.println(sub);
//    }
//}

/*
7.28 AutoCloseable接口
 */

//public class JavaApiDemo{
//
//    public static void main(String[] args) {
//        NetMessage nm = new NetMessage("www.faw.com");  //定义要发送的处理
//        nm.send();    //消息发送
//        nm.close();  //关闭连接
//    }
//}
//interface IMessage {
//    public void send(); //消息发送
//}
//class NetMessage implements IMessage { //实现消息的处理机制
//    private String msg;
//    public NetMessage(String msg) {
//        this.msg = msg;
//    }
//    public boolean open() { //获取资源连接处
//        System.out.println("【OPEN】获取消息发送连接资源");
//        return true;
//    }
//    @Override
//    public void send() {
//        if(this.open()) {
//            System.out.println("【*** 发送消息 ***】" + this.msg);
//        }
//    }
//    public void close() {
//        System.out.println("【CLOSE】关闭消息发送通道");
//    }
//}

//public class JavaApiDemo{
//    public static void main(String[] args) {
//        try(IMessage nm = new NetMessage("www.faw.com")){
//            nm.send();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//interface IMessage extends AutoCloseable{
//    public void send(); //消息发送
//}
//class NetMessage implements IMessage { //实现消息的处理机制
//    private String msg;
//    public NetMessage(String msg) {
//        this.msg = msg;
//    }
//    public boolean open() { //获取资源连接处
//        System.out.println("【OPEN】获取消息发送连接资源");
//        return true;
//    }
//    @Override
//    public void send() {
//        if(this.open()) {
//            System.out.println("【*** 发送消息 ***】" + this.msg);
//        }
//    }
//    @Override
//    public void close() {
//        System.out.println("【CLOSE】关闭消息发送通道");
//    }
//}

/*
7.29 Runtime类
 */
//public class JavaApiDemo{
//    public static void main(String[]args){
//        Runtime run = Runtime.getRuntime(); //获取实例化对象
//        System.out.println(run.availableProcessors());
//    }
//}

//public class JavaApiDemo{
//    public static void main(String[] args) {
//        Runtime run = Runtime.getRuntime();
//        System.out.println("【1】MAX_MEMORY：   " + run.maxMemory());
//        System.out.println("【1】TOTAL_MEMORY： " + run.totalMemory());
//        System.out.println("【1】FREE_MEMORY：  " + run.freeMemory());
//        String str = "";
//        for (int i = 0; i < 30000; i++) {
//            str += i;     //产生大量垃圾空间
//        }
//        System.out.println("【2】MAX_MEMORY：   " + run.maxMemory());
//        System.out.println("【2】TOTAL_MEMORY： " + run.totalMemory());
//        System.out.println("【2】FREE_MEMORY：  " + run.freeMemory());
//        run.gc();
//        System.out.println("【3】MAX_MEMORY：   " + run.maxMemory());
//        System.out.println("【3】TOTAL_MEMORY： " + run.totalMemory());
//        System.out.println("【3】FREE_MEMORY：  " + run.freeMemory());
//    }
//}

/*
7.30 System类
 */
//public class JavaApiDemo{
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        String str = "";
//        for (int i = 0; i < 30000; i++) {
//            str += i;     //产生大量垃圾空间
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("操作耗时：" + (end - start));
//    }
//}

/*
7.31 Cleaner类
 */
//class Member {
//    public Member() {
//        System.out.println("【构造】在一个雷电交加的日子里面，林XX诞生了");
//    }
//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println("【回收】最终你一定要死的。");
//        throw new Exception("我还要再活500年。。。");
//    }
//}
//
//public class JavaApiDemo{
//    public static void main(String[] args) {
//        Member mem = new Member();  //诞生
//        mem = null; //成为垃圾
//        Runtime.getRuntime().gc();
//        System.out.println("太阳照样升起，地球照样转动。");
//    }
//}
//
//class Member implements Runnable {
//
//    public Member() {
//        System.out.println("【构造】在一个雷电交加的日子里面，林XX诞生了");
//    }
//
//    @Override
//    public void run() {
//        System.out.println("【回收】最终你一定要死的。");
//    }
//}
//
//class MemberCleaning implements AutoCloseable { //实现清除的处理
//
//    private static final Cleaner cleaner = Cleaner.create();
//    private Member member;
//    private Cleaner.Cleanable cleanable;
//
//    public MemberCleaning() {
//        this.member = new Member(); //创建新对象
//        this.cleanable = this.cleaner.register(this, this.member); //注册使用的对象
//    }
//
//    @Override
//    public void close() throws Exception {
//        this.cleanable.clean();  //启动多线程清除
//    }
//}
//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        try (MemberCleaning mc = new MemberCleaning()) {
//            //中间可以执行一些相关的代码
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

/*
7.32 对象克隆
 */
//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception{
//        Memeber memeberA = new Memeber("林强",30);
//        Memeber memeberB = (Memeber) memeberA.clone();
//        System.out.println(memeberA);
//        System.out.println(memeberB);
//    }
//}
//class Memeber implements Cloneable{
//    private String name;
//    private int age;
//    public Memeber(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//    @Override
//    public String toString() {
//        return "【" + super.toString() + "】name = " + this.name + "、age = " + this.age;
//    }
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();  //调用父类中提供的clone方法
//    }
//}

/*
8.33 Math类
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        System.out.println(Math.abs(-10.1));
//        System.out.println(Math.max(10.2, 20.3));
//        System.out.println(Math.log(5));
//        System.out.println(Math.round(15.1));
//        System.out.println(Math.round(-15.5));
//        System.out.println(Math.round(-15.51));
//        System.out.println(Math.pow(10.2, 20.2));
//    }
//}
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        System.out.println(MathUtil.round(19.86273, 2));
//    }
//}
//class MathUtil {
//    private MathUtil() { }
//    /**
//     * 实现数据的四舍五入操作
//     *
//     * @param num   要进行四舍五入的数字
//     * @param scale 四舍五入保留小数位数
//     * @return 四舍五入处理后的结果
//     */
//    public static double round(double num, int scale) {
//        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
//    }
//}

/*
8.34 Random类
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        Random rand = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(rand.nextInt(100) + "、");
//        }
//    }
//}

//public class JavaApiDemo{
//    public static void main(String[] args) {
//        int data [] = new int [7];  //开辟七个中奖号的空间
//        Random rand = new Random();
//        int foot = 0; //操作data脚标
//        while(foot < 7) { //选择7个数字
//            int num = rand.nextInt(37);  //生成一个数字
//            if(isUse(num,data)) { //该数字现在可以使用
//                data[foot ++] = num; //保存数据
//            }
//        }
//        //Arrays.sort(data);
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + "、");
//        }
//    }
//
//    public static boolean isUse(int num, int temp[]) {
//        if(num == 0) {
//            return false;
//        }
//        for (int i = 0; i < temp.length; i++) {
//            if(num == temp[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

/*
8.35 大数字处理
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        BigInteger bigA = new BigInteger("234234234234234234234");
//        BigInteger bigB = new BigInteger("234234234");
//        System.out.println("加法操作：" + bigA.add(bigB));
//        System.out.println("减法操作：" + bigB.subtract(bigA));
//        System.out.println("乘法操作：" + bigA.multiply(bigB));
//        System.out.println("除法操作：" + bigA.divide(bigB));
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception{
//        BigInteger bigA = new BigInteger("234234234234234234");
//        System.out.println(bigA.pow(Integer.MAX_VALUE));
//    }
//}
//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        BigInteger bigA = new BigInteger("234234234234234234234");
//        BigInteger bigB = new BigInteger("234234234");
//        BigInteger result [] = bigA.divideAndRemainder(bigB);
//        System.out.println("商：" + result[0] + "、余数：" + result[1]);
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        BigDecimal bigA = new BigDecimal("3289757092842");
//        BigDecimal bigB = new BigDecimal("1892039");
//        System.out.println("加法操作：" + bigA.add(bigB));
//        BigDecimal result [] = bigA.divideAndRemainder(bigB);
//        System.out.println("商：" + result[0] + "、余数：" + result[1]);
//    }
//}

/*
9.36 Date日期处理
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println(date);
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        Date date = new Date();
//        long current = date.getTime();
//        current += 864000000;  //10天的毫秒数
//        System.out.println(new Date(current));
//    }
//}

/*
9.37 日期格式化
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String str = sdf.format(date);
//        System.out.println(str);
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String birthday = "2011-11-11 11:11:11.111";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date date = sdf.parse(birthday);
//        System.out.println(date);
//    }
//}

/*
10.38 认识正则表达式
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "12a3";
//        if(str.matches("\\d+")) {
//            int num = Integer.parseInt(str);
//            System.out.println(num * 2);
//        }
//    }
//}

/*
10.40 String对正则的支持
 */
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "LILI*)JDN)IS*21&*(CX#$%^&*A124PSPL#@IJS";
//        String regex = "[^a-zA-Z0-9]+";    //正则表达式
//        System.out.println(str.replaceAll(regex,""));
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "a1b22c333d4444e55555f666666g";
//        String regex = "\\d+";    //正则表达式
//        String[] result = str.split(regex);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + "、");
//        }
//    }
//}
//

//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "100.32"; //要判断的数据
//        String regex = "\\d+\\.\\d+";    //正则表达式
//        System.out.println(str.matches(regex));
//    }
//}

//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        String str = "100.32"; //要判断的数据
//        String regex = "\\d+(\\.\\d+)?";    //正则表达式
//        System.out.println(str.matches(regex));
//        System.out.println("100".matches(regex));
//        System.out.println("100.".matches(regex));
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String str = "1999-12-31"; //要判断的数据
//        String regex = "\\d{4}-\\d{2}-\\d{2}";    //正则表达式
//        if(str.matches(regex)) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str));
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2222-22-22"));
//        }
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String str = "(010)-55535397"; //要判断的数据
//        String regex = "((\\d{3,4})|(\\(\\d{3,4}\\)-))?\\d{7,8}";    //正则表达式
//        System.out.println(str.matches(regex));
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String str = "xxx123@faw.com"; //要判断的数据
//        String regex = "[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|com.cn|gov)";    //正则表达式
//        System.out.println(str.matches(regex));
//    }
//}

/*
10.41 regex包支持
 */

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String str = "LILI*)JDN)IS*21&*(CX#$%^&*A124PSPL#@IJS"; //要判断的数据
//        String regex = "[^a-zA-z]+";    //正则表达式
//        Pattern pat = Pattern.compile(regex);  //编译正则表达式
//        String[] result = pat.split(str);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + "、");
//        }
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        String str = "101"; //要判断的数据
//        String regex = "\\d+";    //正则表达式
//        Pattern pat = Pattern.compile(regex);  //编译正则表达式
//        Matcher mat = pat.matcher(str);
//        System.out.println(mat.matches());
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        //要求取出“#{内容}"标记中的所有内容
//        String str = "INSERT INTO dept(deptno,dname) VALUES (#{deptno},#{dname})"; //要判断的数据
//        String regex = "#\\{\\w+\\}";    //正则表达式
//        Pattern pat = Pattern.compile(regex);  //编译正则表达式
//        Matcher mat = pat.matcher(str);
//        while(mat.find()) { //是否有 匹配成功的内容
//            System.out.println(mat.group(0).replaceAll("#|\\{|\\}",""));
//        }
//    }
//}

/*
11.42 国际性程序实现原理
 */
//import java.util.Locale;
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        Locale loc = new Locale("zh","CN"); //中文环境
//        System.out.println(loc);
//    }
//}

/*
import java.util.Locale;
public class JavaApiDemo {
    public static void main(String[] args) {
        Locale loc = Locale.CHINA;
        System.out.println(loc);
    }
}
*/



/*
11.44 配置文件
 */

/*
import java.util.ResourceBundle;

public class JavaApiDemo {
    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("message.Message");
            String val = resource.getString("info");
        System.out.println(val);
    }
}
*/

/*
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class JavaApiDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ResourceBundle resource = ResourceBundle.getBundle("message.Message");
        String val = new String(resource.getString("info").getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(val);
    }
}

*/

/*
11.45 国际化程序实现
 */

/*
11.46 消息格式化
 */

/*
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
public class JavaApiDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale loc = new Locale("zh", "CN");
        ResourceBundle resource = ResourceBundle.getBundle("message.Message",loc);
        String val = new String(resource.getString("info"). getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(MessageFormat.format(val,"admin",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
    }
}
*/






/*
12.47 UUID类
 */
/*
public class JavaApiDemo {
    public static void main(String[] args) throws ParseException {
        UUID uid = UUID.randomUUID();
        System.out.println(uid.toString());
    }
}

 */


/*
13.52 比较器
 */
/*
import java.util.Arrays;
public class JavaApiDemo {
    public static void main(String[] args) {
        Integer data[] = new Integer[] {10,9,5,2,20};
        Arrays.sort(data) ; //进行对象排序 ;
        System.out.println(Arrays.toString(data));
    }
}

 */

/*
import java.util.Arrays;
public class JavaApiDemo {
    public static void main(String[] args) {
        String data[] = new String[] {"X","B","A","E","G"};
        Arrays.sort(data) ; //进行对象排序 ;
        System.out.println(Arrays.toString(data));
    }
}

 */

/*
import java.util.Arrays;
public class JavaApiDemo {
    public static void main(String[] args) {
        Person data [] = new Person[] {
            new Person("小强A", 80),
            new Person("小强B", 50),
            new Person("小强C", 100)};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
class Person {
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //无参构造 setter getter略
    @Override
    public String toString() {
        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
    }
}

 */

/*
import java.util.Arrays;
public class JavaApiDemo {
    public static void main(String[] args) {
        Person data [] = new Person[] {
            new Person("小强A", 80),
            new Person("小强B", 50),
            new Person("小强C", 100)};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //无参构造 setter getter略
    @Override
    public String toString() {
        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
    }

    @Override
    public int compareTo(Person per) {
        return this.age - per.age;
    }
}

 */


/*
13.56 二叉树基础实现
 */

public class JavaApiDemo {

    public static void main(String[] args) {

    }
}
class BinaryTree<T extends Comparable<T>> {
    private class Node {
        private Comparable<T> data; //保存Comparable，可以比较大小
        private Node parent; //保存父节点
        private Node left; //保存左子树
        private Node right;  //保存右子树
        public Node(Comparable<T> data) { //构造方法直接负责进行数据的存储
            this.data = data;
        }
        /**
         * 实现节点数据的适当位置的存储
         * @param newNode 创建的新节点
         */
        public void addNode(Node newNode) {
            if(newNode.data.compareTo((T) this.data) <= 0) {

            }
        }


    }
}
