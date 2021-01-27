package cn.mldn.demo;

import java.lang.reflect.InvocationTargetException;

interface IReflectionMessage {

    public void send();
}

class ReflectionNetMessage implements IReflectionMessage {

    public void send() {
        System.out.println("������Ϣ���ͣ�net ��hello world!!!!!");
    }
}

class ReflectionCloudMessage implements IReflectionMessage {

    public void send() {
        System.out.println("����Ϣ���ͣ�cloud��hello world!!!!!");
    }
}


interface IReflectionService {

    public void reflectionService();
}

class HouseService implements IReflectionService {

    @Override
    public void reflectionService() {
        System.out.println("[service]:Ϊ����ס���ṩ����");
    }
}

/**
 * һ���߿��õĹ�������������ָ���Ľӿ�
 *
 * @author Leo123_
 */
class ReflectionFactory {

    //���캯��˽�л�����û�в���ʵ�������������
    private ReflectionFactory() {
    }

    /**
     * ��ȡ�ӿ�ʵ�������󡪡��������ͣ�ʵ��ͨ�õĽӿڶ��󷵻�
     *
     * @param className  �ӿ�����
     * @param classInput ��������һ���ӿڵ�����
     * @return �����������򷵻�ָ���ӿ�ʵ��������
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className, Class<T> classInput) {
        T instance = null;

        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*
        //new����+if else �������󣬱���֪���������ͣ���newInstance���԰���������е�����ת��Ϊ��������
        if("ReflectionNetMessage".equals(className))
        {
            return new ReflectionNetMessage();
        }
        else if("ReflectionCloudMessage".equals(className))
        {
            return new ReflectionCloudMessage();
        }
        */

        return instance;
    }
}

public class ReflectionWithFactory {

    public static void main(String[] args) {
        System.out.println("Lesson 6.102 �����빤�����ģʽ��");

        //IReflectionMessage msg = new ReflectionNetMessage(); //ֱ��ʵ������һ����������⣬��һ���ӿ�һ�㲻ֻ��һ������
        
        /*
        //��׼�������ģʽ
        IReflectionMessage netMsg = ReflectionFactory.getInstance("ReflectionNetMessage");
        netMsg.send();      
        IReflectionMessage cloudMsg = ReflectionFactory.getInstance("ReflectionCloudMessage");
        cloudMsg.send();
        */

        System.out.println("\n���÷������ʵ�ֵĹ��������������������䲻Ӱ�칤�̵�ʵ�֣�");
        System.out.println("ʵ�ʳ����У��϶���ֹһ���ӿڵģ������һ�������������нӿڵ��������������ͣ�");
        IReflectionMessage netMsg = ReflectionFactory
            .getInstance("cn.mldn.demo.ReflectionNetMessage", IReflectionMessage.class);
        netMsg.send();
        IReflectionMessage cloudMsg = ReflectionFactory
            .getInstance("cn.mldn.demo.ReflectionCloudMessage", IReflectionMessage.class);
        cloudMsg.send();

        IReflectionService service = ReflectionFactory
            .getInstance("cn.mldn.demo.HouseService", IReflectionService.class);
        service.reflectionService();
    }
}
