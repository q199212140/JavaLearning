package cn.mldn.older;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
class SerialPerson implements Serializable
{
    /**
     * 
     */
    //private static final long serialVersionUID = 1L;//��ͬ������ϱ��ⷴ���л����⣬����Ҫ������ѹ��
    private transient String name;
    private int age;
    
    public SerialPerson(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }

    @Override
    public String toString()
    {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    
    
}

public class SerializableDemo
{
    private static final File SAVE_FILE = new File("d:" + File.separator + "test" + File.separator + "serializableDemo.txt");
    
    public static void saveObject(Object obj) throws Exception
    {
        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        oos.writeObject(obj);//���л�
        oos.close();
    }  
    
    public static Object loadObject() throws Exception
    {
        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object obj = ois.readObject();//���л�
        ois.close(); 
        return obj;
    }
    
    public static void main(String[] args) throws Exception
    {
        System.out.println("Lesson 6.88 �������л��������");
        
        //saveObject(new SerialPerson("Leoo", 28));//���л�����
        System.out.println(loadObject());//�����л�����
    }
}
