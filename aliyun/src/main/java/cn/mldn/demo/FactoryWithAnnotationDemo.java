package cn.mldn.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage4FactoryWithAnnotation {

    public void send(String msg);
}

class MessageImpl4FactoryWithAnnotation implements IMessage4FactoryWithAnnotation {

    public void send(String msg) {
        System.out.println("[��Ϣ����]" + msg);
    }

}

class NetMessageImpl4FactoryWithAnnotation implements IMessage4FactoryWithAnnotation {

    public void send(String msg) {
        System.out.println("[������Ϣ����]" + msg);
    }

}

class MessageProxy4FactoryWithAnnotation implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public boolean connect() {
        System.out.println("[�������] ������Ϣ����ͨ������");
        return true;
    }

    public void close() {
        System.out.println("[�������] �ر�����ͨ��");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        try {
            if (this.connect()) {
                return method.invoke(this.target, args);
            } else {
                throw new Exception("[Error] ��Ϣ�޷����з��ͣ�");
            }
        } finally {
            this.close();
        }
    }
}

class Factory4FactoryWithAnnotation {

    private Factory4FactoryWithAnnotation() {
    }

    public static <T> T getInstance(Class<T> clazz) {
        try {
            return (T) new MessageProxy4FactoryWithAnnotation().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

//ͨ��ע������������չ����ͨ��ע����Ƴ����ִ��
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage {

    public Class<?> clazz();
}

//@UseMessage(clazz=MessageImpl4FactoryWithAnnotation.class)
@UseMessage(clazz = NetMessageImpl4FactoryWithAnnotation.class)
class MessageService4FactoryWithAnnotation {

    private IMessage4FactoryWithAnnotation message;

    public MessageService4FactoryWithAnnotation() {
        UseMessage use = MessageService4FactoryWithAnnotation.class.getAnnotation(UseMessage.class);
        this.message = (IMessage4FactoryWithAnnotation) Factory4FactoryWithAnnotation.getInstance(use.clazz());
    }

    public void send(String msg) {
        this.message.send(msg);
    }
}

public class FactoryWithAnnotationDemo {

    public static void main(String[] args) {
        System.out.println("6.122.����ģʽ��Annotation����");

        //������ֻ��Ҫ��ע���������������ݷ��ͣ������Ķ���װ�ڷ�������
        MessageService4FactoryWithAnnotation messageService = new MessageService4FactoryWithAnnotation();
        messageService.send("Hello Leoooooooooooooooooooo!");
    }
}
