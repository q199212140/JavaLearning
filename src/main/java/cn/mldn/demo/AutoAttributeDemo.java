package cn.mldn.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

class StringUtils
{
    public static String initcap(String str)
    {
        if((null == str) || "".equals(str))
        {
            return str;
        }
        
        if(str.length() == 1)
        {
            return str.toUpperCase();
        }
        else
        {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }
}

/**
 * 实现属性设置
 * @author Leo123_
 *
 */
class BeanUtils
{
    private BeanUtils() {}
    
    /**
     * 实现指定对象的属性设置
     * @param obj 要进行反射操作的实例化对象
     * @param value 包含有指定内容的字符串，格式为“内容|属性:内容|属性:内容”
     */
    public static void setValue(Object obj, String value)
    {
        //按照“|”进行每一组属性的拆分
        String results[] = value.split("\\|");
        //循环设置属性内容
        for(int x = 0; x < results.length; x++)
        {
            //获取属性内容  attVal[0]为属性名称， attVal[1]为属性内容
            String attVal[] = results[x].split(":");
                        
            //获取成员          
            try
            {
                if(attVal[0].contains("."))//多级配置
                {
                    String temp[] = attVal[0].split("\\.");
                    Object currentObj = obj;
                    //System.out.println(Arrays.toString(temp));
                    //最后一位肯定是指定类的属性名称，不需要处理
                    for(int y = 0; y < temp.length - 1; y++)//实例化
                    {
                        //调用相应getter方法，若getter返回null，说明相应对象未实例化
                        Method getMethod = currentObj.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[y]));
                        
                        Object tempObj = getMethod.invoke(currentObj);
                        if(null == tempObj)//对象并没有被实例化
                        {
                            Field field = currentObj.getClass().getDeclaredField(temp[y]);//获取属性类型
                            Method method = currentObj.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[y]), field.getType());
                            Object newObj = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObj, newObj);
                            currentObj = newObj;
                        }
                        else
                        {
                            currentObj = tempObj;
                        }
                        //System.out.println(temp[y] + "--" + currentObj);
                    }
                    
                    //进行属性内容设置
                    Field field = currentObj.getClass().getDeclaredField(temp[temp.length-1]);
                    Method setMethod = currentObj.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[temp.length-1]), field.getType());
                    Object convertVal = BeanUtils.convertAttributeValue(field.getType().getName(), attVal[1]);
                    
                    //调用setter方法设置内容
                    setMethod.invoke(currentObj, convertVal);
                }
                else
                {
                    Field field = obj.getClass().getDeclaredField(attVal[0]);
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attVal[0]), field.getType());
                    
                    Object convertVal = BeanUtils.convertAttributeValue(field.getType().getName(), attVal[1]);
                    
                    //调用setter方法设置内容
                    setMethod.invoke(obj, convertVal);
                    
                    //System.out.println("set field[" + field.getType().getName() + "], val[" + attVal[1] + "]" );                 
                }
            } catch (NoSuchFieldException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SecurityException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }
            
        }
    }
    
    /**
     * 实现属性类型转换处理
     * @param type 属性类型，通过Field获取
     * @param value 属性的内容，传入的都是字符串，主要转化为指定类型
     * @return 转换后的类型值
     */
    private static Object convertAttributeValue(String type, String value)
    {
        System.out.println("type = " + type + "、value = " + value);
        if (("long".equals(type)) || "java.lang.Long".equals(type))
        {
            return Long.parseLong(value);
        }
        else if(("int".equals(type)) || "java.lang.int".equals(type))
        {
            return Integer.parseInt(value);
        }
        else if(("double".equals(type)) || "java.lang.double".equals(type))
        {
            return Double.parseDouble(value);
        }
        else if("java.util.Date".equals(type))
        {           
            SimpleDateFormat sdf = null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}"))
            {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            else if(value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) 
            {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }           
            else
            {
                return new Date();
            }
            
            try
            {
                return sdf.parse(value);
            } catch (ParseException e)
            {
                System.out.println("parse exception:");
                return new Date();
            }
        }
        else
        {
            //System.out.println("convert failed! type[" + type + "]、value[" + value + "]");
            return value;
        }       
    }
}

class Company
{
    private String name;
    private Date createDate;
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Date getCreateDate()
    {
        return createDate;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
}

class Dept
{
    private String dname;
    private String loc;
    private Company company;
    
    public String getDname()
    {
        return dname;
    }
    public void setDname(String dname)
    {
        this.dname = dname;
    }
    public String getLoc()
    {
        return loc;
    }
    public void setLoc(String loc)
    {
        this.loc = loc;
    }
    public Company getCompany()
    {
        return company;
    }
    public void setCompany(Company company)
    {
        this.company = company;
    }
       
}
//单级类属性， 无其他关联，仅描述类本身的属性
class Emp
{
    private String name;
    private String job;
    private long empNo;
    private double salary;
    private Date hireDate;
    private Dept dept;
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getJob()
    {
        return job;
    }
    public void setJob(String job)
    {
        this.job = job;
    }

    public long getEmpNo()
    {
        return empNo;
    }
    public void setEmpNo(long empNo)
    {
        this.empNo = empNo;
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public Date getHireDate()
    {
        return hireDate;
    }
    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }
    public Dept getDept()
    {
        return dept;
    }
    public void setDept(Dept dept)
    {
        this.dept = dept;
    }
    @Override
    public String toString()
    {
        return "Emp [name=" + name + ", job=" + job + ", empNo=" + empNo + ", salary=" + salary + ", hireDate="
                + hireDate + ", dept=" + dept + "]";
    }     
}

/**
 * 实例化对象并调用BeanUtils实现属相内容设置
 * @author Leo123_
 *
 */
class ClassInstanceFactory
{
    private ClassInstanceFactory() {}
    
    /**
                * 实例化对象的创建方法，根据输入的字符串“内容|属性:内容|属性:内容”，获取对象
     * @param clazz 要进行反射实例化的CLass类对象，有Class就可以反射实例化对象
     * @param value 要设置给对象的属性内容
     * @return 一个已经设置好属性内容的Java类对象
     */
    public static <T> T create(Class<?> clazz, String value)
    {
        //若要采用反射进行简单Java类对象属性设置，必须要有无参构造
        try
        {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);//通过反射设置属性
            return (T)obj;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }       
    }
}

public class AutoAttributeDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.110 属性自动赋值实现思路");
        System.out.println("Lesson 6.111 单级属性赋值");
        System.out.println("Lesson 6.112 设置多种数据类型");
        System.out.println("Lesson 6.113 级联对象实例化");
        System.out.println("Lesson 6.114 级联属性赋值");
        
        System.out.println("通过  属性:内容|属性:内容|属性:内容 方式对简单Java类进行初始化");
        String value = "name:Smith|job:Clerk|empNo:15843|salary:18888.8|hireDate:2017-10-18|" +
        "dept.dname:财务部|dept.company.name:MLDN";
        
        Emp emp = ClassInstanceFactory.create(Emp.class, value);
        System.out.println("getDept:" + emp.getDept().getDname());
        System.out.println("getCompany:" + emp.getDept().getCompany().getName());
        System.out.println(emp);
    }
}
