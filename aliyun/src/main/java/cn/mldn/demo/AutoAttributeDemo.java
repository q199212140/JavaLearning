package cn.mldn.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class StringUtils {

    public static String initcap(String str) {
        if ((null == str) || "".equals(str)) {
            return str;
        }

        if (str.length() == 1) {
            return str.toUpperCase();
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}

/**
 * ʵ����������
 *
 * @author Leo123_
 */
class BeanUtils {

    private BeanUtils() {
    }

    /**
     * ʵ��ָ���������������
     *
     * @param obj   Ҫ���з��������ʵ��������
     * @param value ������ָ�����ݵ��ַ�������ʽΪ������|����:����|����:���ݡ�
     */
    public static void setValue(Object obj, String value) {
        //���ա�|������ÿһ�����ԵĲ��
        String results[] = value.split("\\|");
        //ѭ��������������
        for (int x = 0; x < results.length; x++) {
            //��ȡ��������  attVal[0]Ϊ�������ƣ� attVal[1]Ϊ��������
            String attVal[] = results[x].split(":");

            //��ȡ��Ա          
            try {
                if (attVal[0].contains("."))//�༶����
                {
                    String temp[] = attVal[0].split("\\.");
                    Object currentObj = obj;
                    //System.out.println(Arrays.toString(temp));
                    //���һλ�϶���ָ������������ƣ�����Ҫ����
                    for (int y = 0; y < temp.length - 1; y++)//ʵ����
                    {
                        //������Ӧgetter��������getter����null��˵����Ӧ����δʵ����
                        Method getMethod = currentObj.getClass()
                            .getDeclaredMethod("get" + StringUtils.initcap(temp[y]));

                        Object tempObj = getMethod.invoke(currentObj);
                        if (null == tempObj)//����û�б�ʵ����
                        {
                            Field field = currentObj.getClass().getDeclaredField(temp[y]);//��ȡ��������
                            Method method = currentObj.getClass()
                                .getDeclaredMethod("set" + StringUtils.initcap(temp[y]), field.getType());
                            Object newObj = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObj, newObj);
                            currentObj = newObj;
                        } else {
                            currentObj = tempObj;
                        }
                        //System.out.println(temp[y] + "--" + currentObj);
                    }

                    //����������������
                    Field field = currentObj.getClass().getDeclaredField(temp[temp.length - 1]);
                    Method setMethod = currentObj.getClass()
                        .getDeclaredMethod("set" + StringUtils.initcap(temp[temp.length - 1]), field.getType());
                    Object convertVal = BeanUtils.convertAttributeValue(field.getType().getName(), attVal[1]);

                    //����setter������������
                    setMethod.invoke(currentObj, convertVal);
                } else {
                    Field field = obj.getClass().getDeclaredField(attVal[0]);
                    Method setMethod = obj.getClass()
                        .getDeclaredMethod("set" + StringUtils.initcap(attVal[0]), field.getType());

                    Object convertVal = BeanUtils.convertAttributeValue(field.getType().getName(), attVal[1]);

                    //����setter������������
                    setMethod.invoke(obj, convertVal);

                    //System.out.println("set field[" + field.getType().getName() + "], val[" + attVal[1] + "]" );                 
                }
            } catch (NoSuchFieldException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SecurityException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * ʵ����������ת������
     *
     * @param type  �������ͣ�ͨ��Field��ȡ
     * @param value ���Ե����ݣ�����Ķ����ַ�������Ҫת��Ϊָ������
     * @return ת���������ֵ
     */
    private static Object convertAttributeValue(String type, String value) {
        System.out.println("type = " + type + "��value = " + value);
        if (("long".equals(type)) || "java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        } else if (("int".equals(type)) || "java.lang.int".equals(type)) {
            return Integer.parseInt(value);
        } else if (("double".equals(type)) || "java.lang.double".equals(type)) {
            return Double.parseDouble(value);
        } else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();
            }

            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                System.out.println("parse exception:");
                return new Date();
            }
        } else {
            //System.out.println("convert failed! type[" + type + "]��value[" + value + "]");
            return value;
        }
    }
}

class Company {

    private String name;
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

class Dept {

    private String dname;
    private String loc;
    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}

//���������ԣ� �������������������౾�������
class Emp {

    private String name;
    private String job;
    private long empNo;
    private double salary;
    private Date hireDate;
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp [name=" + name + ", job=" + job + ", empNo=" + empNo + ", salary=" + salary + ", hireDate="
            + hireDate + ", dept=" + dept + "]";
    }
}

/**
 * ʵ�������󲢵���BeanUtilsʵ��������������
 *
 * @author Leo123_
 */
class ClassInstanceFactory {

    private ClassInstanceFactory() {
    }

    /**
     * ʵ��������Ĵ�������������������ַ���������|����:����|����:���ݡ�����ȡ����
     *
     * @param clazz Ҫ���з���ʵ������CLass�������Class�Ϳ��Է���ʵ��������
     * @param value Ҫ���ø��������������
     * @return һ���Ѿ����ú��������ݵ�Java�����
     */
    public static <T> T create(Class<?> clazz, String value) {
        //��Ҫ���÷�����м�Java������������ã�����Ҫ���޲ι���
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);//ͨ��������������
            return (T) obj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

public class AutoAttributeDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.110 �����Զ���ֵʵ��˼·");
        System.out.println("Lesson 6.111 �������Ը�ֵ");
        System.out.println("Lesson 6.112 ���ö�����������");
        System.out.println("Lesson 6.113 ��������ʵ����");
        System.out.println("Lesson 6.114 �������Ը�ֵ");

        System.out.println("ͨ��  ����:����|����:����|����:���� ��ʽ�Լ�Java����г�ʼ��");
        String value = "name:Smith|job:Clerk|empNo:15843|salary:18888.8|hireDate:2017-10-18|" +
            "dept.dname:����|dept.company.name:MLDN";

        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        System.out.println("getDept:" + emp.getDept().getDname());
        System.out.println("getCompany:" + emp.getDept().getCompany().getName());
        System.out.println(emp);
    }
}
