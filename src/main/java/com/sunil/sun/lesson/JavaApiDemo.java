package com.sunil.sun.lesson;

// import java.text.ParseException;
// import java.util.UUID;

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
12.48 Optional类
 */
//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//
//    }
//}
//class MessageUtil {
//    private MessageUtil() {}
//    public static IMessage getImessage() {
//        return null;
//    }
//    public static void useMessage(IMessage msg) {
//        if(msg != null) {
//            System.out.println(msg.getContent());    //有可能出现null，导致空指针
//        }
//    }
//}
//interface IMessage {
//    public String getContent();
//}
//class MessageImpl implements IMessage {
//    @Override
//    public String getContent() {
//        return "this is a Message";
//    }
//}

//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        IMessage temp = MessageUtil.getMessage().get();    //获取数据
//        MessageUtil.useMessage(temp);
//    }
//}
//class MessageUtil {
//    private MessageUtil() {}
//    public static Optional<IMessage> getMessage() {
//        return Optional.of(new MessageImpl()); //有对象
//    }
//    public static void useMessage(IMessage msg) {
//        if(msg != null) {
//            System.out.println(msg.getContent());    //有可能出现null，导致空指针
//        }
//    }
//}
//interface IMessage {
//    public String getContent();
//}
//class MessageImpl implements IMessage {
//    @Override
//    public String getContent() {
//        return "this is a Message";
//    }
//}




//public class JavaApiDemo {
//    public static void main(String[] args) throws ParseException {
//        IMessage temp = MessageUtil.getMessage().orElse(new MessageImpl());    //获取数据
//        MessageUtil.useMessage(temp);
//    }
//}
//class MessageUtil {
//    private MessageUtil() {}
//    public static Optional<IMessage> getMessage() {
//        return Optional.ofNullable(null); //无对象
//    }
//    public static void useMessage(IMessage msg) {
//        if(msg != null) {
//            System.out.println(msg.getContent());    //有可能出现null，导致空指针
//        }
//    }
//}
//interface IMessage {
//    public String getContent();
//}
//class MessageImpl implements IMessage {
//    @Override
//    public String getContent() {
//        return "this is a Message";
//    }
//}



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

// import java.util.Arrays;
// public class JavaApiDemo {
//     public static void main(String[] args) {
//         Person data [] = new Person[] {
//             new Person("小强A", 80),
//             new Person("小强B", 50),
//             new Person("小强C", 100)};
//         Arrays.sort(data);
//         System.out.println(Arrays.toString(data));
//     }
// }
// class Person implements Comparable<Person>{
//     private String name;
//     private int age;
//     public Person(String name,int age) {
//         this.name = name;
//         this.age = age;
//     }

//     //无参构造 setter getter略
//     @Override
//     public String toString() {
//         return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
//     }

//     @Override
//     public int compareTo(Person per) {
//         return this.age - per.age;
//     }
// }



/*
13.56 二叉树基础实现
 */
// import java.util.Arrays;

// public class JavaApiDemo {
//     public static void main(String[] args) {
//     	BinaryTree<Person> tree = new BinaryTree<Person>();
//     	tree.add(new Person("小强-80", 80));
//     	tree.add(new Person("小强-30", 30));
//     	tree.add(new Person("小强-50", 50));
//     	tree.add(new Person("小强-60", 60));
//     	tree.add(new Person("小强-90", 90));
//     	System.out.println(Arrays.toString(tree.toArray()));
//     }
// }
// /**
//  *实现二叉树操作
//  */
// class BinaryTree<T extends Comparable<T>> {
//     private class Node {
//         private Comparable<T> data; //保存Comparable，可以比较大小
//         private Node parent; //保存父节点
//         private Node left; //保存左子树
//         private Node right;  //保存右子树
//         public Node(Comparable<T> data) { //构造方法直接负责进行数据的存储
//             this.data = data;
//         } //
//         /**
//          * 实现节点数据的适当位置的存储
//          * @param newNode 创建的新节点
//          */
//         public void addNode(Node newNode) {
//             if(newNode.data.compareTo((T) this.data) <= 0) { //比当前节点数据小
//             	if (this.left == null) { //现在没有左子树
//             		this.left = newNode;  //保存左子树
//             		newNode.parent = this;  //保存父节点
//             	} else { //需要向左边继续判断
//             		this.left.addNode(newNode);  //继续往下判断
//             	}

//             } else { //比根节点数据大
//             	if (this.right == null) {
//             		this.right = newNode; //没有右子树
//             		newNode.parent = this;  //保存父节点
//             	} else {
//             		this.right.addNode(newNode);  //继续向下判断
//             	}
//             } 
//         }
//         /**
//          * 实现所有数据的获取处理，按照中序遍历的形式来完成
//          */
//         public void toArrayNode() {
//         	if (this.left != null) { //有左子树
//         		this.left.toArrayNode(); //递归调用
//         	}
//         	BinaryTree.this.returnData[BinaryTree.this.foot ++ ] = this.data;
//         	if(this.right != null) {
//         		this.right.toArrayNode();
//         	}
//         }
//     }

//     //-----------以下为二叉树的功能实现--------------
//     private Node root;  //保存的是根结点
//     private int count;  //保存数据个数
//     private Object [] returnData;  //返回的数据
//     private int foot = 0; //脚标控制
//     /**
//      * 进行数据的保存
//      * @param data 要保存的数据内容
//      * @exception NullPointerException 保存数据为空时抛出异常
//      */
//     public void add(Comparable<T> data) {
//     	if (data == null) {
//     		throw new NullPointerException("保存的数据不允许为空！");
//     	}
//     	// 所有的数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
//     	Node newNode = new Node(data);  //保存节点
//     	if (this.root == null) { //现在没有根结点，则第一个节点作为根结点
//     		this.root = newNode ;
//     	} else { //需要为其保存到一个合适的节点
//     		this.root.addNode(newNode); //交由Node类负责处理
//     	}
//     	this.count ++ ;
//     }

//     /**
//      * 以对象数组的形式返回全部数据，如果没有数据返回null
//      * @return 全部数据
//      */
//     public Object[] toArray() {
//     	if (this.count == 0) {
//     		return null;
//     	}
//     	this.returnData = new Object[this.count];  //保存长度为数组长度
//     	this.foot = 0 ; //脚标清零
//     	this.root.toArrayNode();   //直接通过Node类负责
//     	return this.returnData;  //返回全部的数据
//     }
// }

// class Person implements Comparable<Person>{
//     private String name;
//     private int age;
//     public Person(String name,int age) {
//         this.name = name;
//         this.age = age;
//     }

//     //无参构造 setter getter略
//     @Override
//     public String toString() {
//         return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
//     }

//     @Override
//     public int compareTo(Person per) {
//         return this.age - per.age;
//     }
// }


import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 二叉树删除
 */
//import java.util.Arrays;
//
//public class JavaApiDemo {
//    public static void main(String[] args) {
//    	BinaryTree<Person> tree = new BinaryTree<Person>();
//    	tree.add(new Person("小强-80", 80));
//    	tree.add(new Person("小强-50", 50));
//    	tree.add(new Person("小强-60", 60));
//    	tree.add(new Person("小强-30", 30));
//    	tree.add(new Person("小强-90", 90));
//    	tree.add(new Person("小强-10", 35));
//    	tree.add(new Person("小强-55", 55));
//    	tree.add(new Person("小强-70", 70));
//    	tree.add(new Person("小强-85", 85));
//    	tree.add(new Person("小强-95", 95));
//
//		System.out.println("原始：\n" + Arrays.toString(tree.toArray()));
//
//    	tree.remove(new Person("小强-95", 95));
//		System.out.println("第一类删除-无孩子 有兄弟：\n" + Arrays.toString(tree.toArray()));
//		tree.remove(new Person("小强-90", 90));
//		System.out.println("第二类删除-有左子 有兄弟：\n" + Arrays.toString(tree.toArray()));
//		tree.remove(new Person("小强-30", 30));
//		System.out.println("第二类删除-有右子 有兄弟：\n" + Arrays.toString(tree.toArray()));
//		tree.remove(new Person("小强-60", 60));
//		System.out.println("第三类删除-有两子：\n" + Arrays.toString(tree.toArray()));
//		tree.remove(new Person("小强-80", 80));
//		System.out.println("删除根结点：\n" + Arrays.toString(tree.toArray()));
//
//
//
//	}
//}
///**
// *实现二叉树操作
// */
//class BinaryTree<T extends Comparable<T>> {
//    private class Node {
//        private Comparable<T> data; //保存Comparable，可以比较大小
//        private Node parent; //保存父节点
//        private Node left; //保存左子树
//        private Node right;  //保存右子树
//        public Node(Comparable<T> data) { //构造方法直接负责进行数据的存储
//            this.data = data;
//        } //
//        /**
//         * 实现节点数据的适当位置的存储
//         * @param newNode 创建的新节点
//         */
//        public void addNode(Node newNode) {
//            if(newNode.data.compareTo((T) this.data) <= 0) { //比当前节点数据小
//            	if (this.left == null) { //现在没有左子树
//            		this.left = newNode;  //保存左子树
//            		newNode.parent = this;  //保存父节点
//            	} else { //需要向左边继续判断
//            		this.left.addNode(newNode);  //继续往下判断
//            	}
//
//            } else { //比根节点数据大
//            	if (this.right == null) {
//            		this.right = newNode; //没有右子树
//            		newNode.parent = this;  //保存父节点
//            	} else {
//            		this.right.addNode(newNode);  //继续向下判断
//            	}
//            }
//        }
//        /**
//         * 实现所有数据的获取处理，按照中序遍历的形式来完成
//         */
//        public void toArrayNode() {
//        	if (this.left != null) { //有左子树
//        		this.left.toArrayNode(); //递归调用
//        	}
//        	BinaryTree.this.returnData[BinaryTree.this.foot ++ ] = this.data;
//        	if(this.right != null) {
//        		this.right.toArrayNode();
//        	}
//        }
//        /**
//         * 进行数据的检索处理
//         * @param data 要检索的数据
//         * @return 找到返回true
//         */
//        public boolean containsNode(Comparable<T> data) {
//        	if(data.compareTo((T)this.data) == 0) {
//        		return true; //找到了
//        	} else if (data.compareTo((T)this.data) <0 ) { //左边有数据
//        		if (this.left != null) {
//        			return this.left.containsNode(data);
//        		} else {
//        			return false;
//        		}
//        	} else {
//
//        		if (this.right != null) {
//        			return this.right.containsNode(data);
//        		} else {
//        			return false;
//        		}
//        	}
//        }
//		/**
//		 * 获得要删除的节点对象
//		 * @param data 比较的对象
//		 * @return 要删除的节点对象，一定存在
//		 */
//		public Node getRemoveNode(Comparable<T> data) {
//			if (data.compareTo((T)this.data) == 0) {
//				return this;  //查找到了
//				//左边有数据
//			} else if (data.compareTo((T)this.data) <0) {
//				if(this.left != null) {
//					return this.left.getRemoveNode(data);
//				} else {
//					return null;
//				}
//			}else {
//				if (this.right != null) {
//					return this.right.getRemoveNode(data);
//				} else {
//					return null;
//				}
//			}
//		}
//    }
//
//    //-----------以下为二叉树的功能实现--------------
//    private Node root;  //保存的是根结点
//    private int count;  //保存数据个数
//    private Object [] returnData;  //返回的数据
//    private int foot = 0; //脚标控制
//    /**
//     * 进行数据的保存
//     * @param data 要保存的数据内容
//     * @exception NullPointerException 保存数据为空时抛出异常
//     */
//    public void add(Comparable<T> data) {
//    	if (data == null) {
//    		throw new NullPointerException("保存的数据不允许为空！");
//    	}
//    	// 所有的数据本身不具备有节点关系的匹配，那么一定要将其包装在Node类之中
//    	Node newNode = new Node(data);  //保存节点
//    	if (this.root == null) { //现在没有根结点，则第一个节点作为根结点
//    		this.root = newNode ;
//    	} else { //需要为其保存到一个合适的节点
//    		this.root.addNode(newNode); //交由Node类负责处理
//    	}
//    	this.count ++ ;
//    }
//
//    /**
//     * 以对象数组的形式返回全部数据，如果没有数据返回null
//     * @return 全部数据
//     */
//    public Object[] toArray() {
//    	if (this.count == 0) {
//    		return null;
//    	}
//    	this.returnData = new Object[this.count];  //保存长度为数组长度
//    	this.foot = 0 ; //脚标清零
//    	this.root.toArrayNode();   //直接通过Node类负责
//    	return this.returnData;  //返回全部的数据
//    }
//    /**
//     * 现在的检索主要依靠Comparale实现的数据比较
//     */
//    public boolean contains(Comparable<T> data) {
//    	if (this.count == 0) { //还没有数据
//    		return false;
//    	}
//    	return this.root.containsNode(data); // 该操作一定交由Node类完成
//    }
//
//	/**
//	 * 执行数据删除处理
//	 * @param data 要删除的数据
//	 */
//	public void remove(Comparable<T> data) {
//		if(this.root == null) { //根结点不存在
//			return; //结束调用
//		} else {
//			if(this.root.data.compareTo((T)data) == 0) { //要删除的是根结点
//				Node moveNode = this.root.right;  //移动的节点
//				while(moveNode.left != null ) { //现在还有左边的节点
//					moveNode = moveNode.left; //一直向左找
//				} //就可以确定删除节点的右节点的最小的左节点
//
//				if(this.root.right != moveNode) { //如果root的右节点有左节点
//					moveNode.parent.left = null; //断开原本的连接
//					moveNode.right = this.root.right;
//				}
//				moveNode.left = this.root.left;
//				this.root = moveNode; //改变根结点
//				this.count --;
//			} else {
//				Node removeNode = this.root.getRemoveNode(data);  //找到要删除的节点
//				if(removeNode != null) { //找到要删除的对象信息
//					//情况一：没子节点
//					if(removeNode.left == null && removeNode.right == null) {
//						if(removeNode == removeNode.parent.left) {//是父节点的左节点则断开左
//							removeNode.parent.left = null;
//						} else if(removeNode == removeNode.parent.right) { //是右则断开右
//							removeNode.parent.right = null;
//						}
////				removeNode.parent.left = null;
////				removeNode.parent.right = null;
////				removeNode.parent = null;
//					} else if(removeNode.left != null && removeNode.right == null ) { //左边不为空
////				removeNode.parent.left = removeNode.left;
////				removeNode.left.parent = removeNode.parent;
//						if(removeNode == removeNode.parent.left) {//是父节点的左节点则孩子变为左
//							removeNode.parent.left = removeNode.left;
//						} else if(removeNode == removeNode.parent.right) { //是父节点的右
//							removeNode.parent.right = removeNode.left;
//						}
//					} else if (removeNode.left == null && removeNode.right != null ) { //右边无节点
////				removeNode.parent.right = removeNode.right;
////				removeNode.right.parent = removeNode.parent;
//						if(removeNode == removeNode.parent.left) {//是父节点的左节点则孩子变为左
//							removeNode.parent.left = removeNode.right;
//						} else if(removeNode == removeNode.parent.right) { //是父节点的右
//							removeNode.parent.right = removeNode.right;
//						}
//					} else { //两边都有节点，则将右边节点中最左边的节点找到改变指向
//						//右的最左，或者左的最右
//						Node moveNode = removeNode.right;  //移动的节点
//						while(moveNode.left != null ) { //现在还有左边的节点
//							moveNode = moveNode.left; //一直向左找
//						} //就可以确定删除节点的右节点的最小的左节点
//						if(removeNode.right != moveNode) { //如果removeNode的右节点有左节点
//							moveNode.parent.left = null; //断开原本的连接
//							moveNode.right = removeNode.right;
//						} else { //moveNode就是remove的右节点
//							moveNode.parent.right = null;
//						}
//						moveNode.parent = removeNode.parent;
//						moveNode.left = removeNode.left;
//						if (removeNode == removeNode.parent.left) {//是父节点的左节点
//							removeNode.parent.left = moveNode;
//						} else if(removeNode == removeNode.parent.right) { //是父节点的右
//							removeNode.parent.right = moveNode;
//						}
//					}
//					this.count -- ;
//				}
//			}
//		}
//	}
//}
//
//class Person implements Comparable<Person>{
//    private String name;
//    private int age;
//    public Person(String name,int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    //无参构造 setter getter略
//    @Override
//    public String toString() {
//        return "【Person类对象】姓名：" + this.name + "、年龄：" + this.age + "\n";
//    }
//
//    @Override
//    public int compareTo(Person per) {
//        return this.age - per.age;
//    }
//}


/*
14.59 StringBuffer类使用
 */
//public class JavaApiDemo {
//
//    public static void main(String[] args) {
//        StringBuffer buf = new StringBuffer();
//        for (int i = 'a'; i <= 'z'; i++) { //直接循环设置
//            buf.append((char) i);  //保存字符
//        }
//        buf.reverse().delete(0,5);  //反转处理
//        System.out.println(buf);
//    }
//}

/*
14.60 随机数组
 */
//import java.util.Arrays;
//import java.util.Random;
//public class JavaApiDemo {
//    public static void main(String[] args) {
//        int result [] = NumberFactory.create(5);
//        System.out.println(Arrays.toString(result));
//    }
//}
//class NumberFactory {
//    private static Random random = new Random();
//    /**
//     * 通过随机数来生成一个数组的内容，该内容不包括有0
//     * @param len 要开辟的数组大小
//     * @return 包含有随机数的内容
//     */
//    public static int[] create(int len) {
//        int data [] = new int[len]; //开辟新的数组
//        int foot = 0;
//        while(foot < data.length) {
//            int num =random.nextInt(30);
//            if(num != 0) {
//                data[foot ++] = num;  //保存数据
//            }
//        }
//        return data;
//    }
//}

/*
15.67 File类基本操作
 */
//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception{
//
//        File file = new File("/Users/lifei/test.txt");
//        //File file = new File("d:\\test.txt");
//        System.out.println(file.createNewFile());  //创建新的文件
//    }
//}
//
//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception{
//        File file = new File("/Users/lifei/test.txt");
//        if(file.exists()) {
//            file.delete();   //删除文件
//        } else {  //文件不存在
//            System.out.println(file.createNewFile());  //创建新的文件
//        }
//    }
//}

/*
15.68 File深入操作
 */

//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception {
//        File file = new File(
//            File.separator + "Users" + File.separator + "lifei" + File.separator + "dir1" + File.separator + "dir2"
//                + File.separator + "test.txt");
//        if (!file.getParentFile().exists()) {  //父路径不存在
//            file.getParentFile().mkdirs();   //创建父路径
//        }
//        if (file.exists()) {
//            file.delete();
//        } else {  //文件不存在
//            System.out.println(file.createNewFile());  //创建新的文件
//        }
//    }
//}


/*
15.69获取文件信息
 */
//public class JavaApiDemo {
//    public static void main(String[] args) throws Exception {
//        File file = new File(
//            File.separator + "Users" + File.separator + "lifei" + File.separator + "test.txt");
//        System.out.println("文件是否可读：" + file.canRead());
//        System.out.println("文件是否可写：" + file.canWrite());
//        System.out.println("文件大小：" + MathUtil.round(file.length() / (double) 1024 / 1024, 2));
//        System.out
//            .println("最后的修改时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));
//        System.out.println("是目录吗？ " + file.isDirectory());
//        System.out.println("是文件吗？ " + file.isFile());
//    }
//}
//
//class MathUtil {
//
//    private MathUtil() {
//    }
//
//    public static double round(double num, int scale) {
//        return Math.round(Math.pow(10, scale) * num) / Math.pow(10, scale);
//    }
//
//}
//
//public class JavaApiDemo {
//
//    public static void main(String[] args) {
//        File file = new File(File.separator + "Users" + File.separator + "lifei" + File.separator);
//        if(file.isDirectory()) {
//            File result[] = file.listFiles(); //列出目录全部内容
//            for (int i = 0; i < result.length; i++) {
//                System.out.println(result[i]);
//            }
//        }
//
//    }
//}

/*
15.70 列出目录结构
 */
//public class JavaApiDemo {
//
//    public static void main(String[] args) {
//        File file = new File("/Users/lifei/");
//        listDir(file);
//    }
//
//    public static void listDir(File file) {
//        if(file.isDirectory()) { //是一个目录
//            File results [] = file.listFiles();  //列出目录中的全部内容
//            if(results != null) {
//                for (int i = 0; i < results.length; i++) {
//                    listDir(results[i]);   //继续依次判断
//                }
//            }
//        }
//        System.out.println(file);  //获得完整路径
//
//    }
//}

/*
15.71 批量修改文件名称
 */
//
//public class JavaApiDemo {
//
//    public static void main(String[] args) throws Exception {
//        File file = new File("/Users/lifei/repository");   //是一个目录
//        renameDir(file);
//    }
//    public static void renameDir(File file) {
//        if(file.isDirectory()) { //是一个目录
//            File results [] = file.listFiles();  //列出目录中内容
//            if(results != null ) {
//                for (int i = 0; i < results.length; i++) {
//                    renameDir(results[i]);
//                }
//            }
//        } else if (file.isFile()) {
//            String fileName = null;
//            if(file.getName().contains(".")) {
//                fileName = file.getName().substring(0,file.getName().lastIndexOf(".")) + ".txt";
//            } else {
//                fileName = file.getName() + ".txt";
//            }
//            File newFile = new File(file.getParentFile(),fileName);  //新的文件名
//            file.renameTo(newFile);   //重命名
//        }
//    }
//}

/*
16.72 流的基本概念
 */

/*
17.80 字符编码
 */
//public class JavaApiDemo{
//    public static void main(String[] args) {
//        System.getProperties().list(System.out);
//    }
//}

