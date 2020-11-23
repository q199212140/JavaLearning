package cn.mldn.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage4DynamicProxyDemo {

    public void send();

}

class MessageReal4DynamicProxyDemo implements IMessage4DynamicProxyDemo {

    public void send() {
        System.out.println("[������Ϣ]Hello world!!!!!!!");
    }
}

class MLDNProxy implements InvocationHandler {

    private Object target;//������ʵҵ�����

    /**
     * ������ʵҵ�������������֮��İ󶨴���
     *
     * @param target ��ʵҵ�����
     * @return Proxy���ɵĴ���ҵ�����
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public boolean connect() {
        System.out.println("[��Ϣ����]��Ϣ����ͨ������");
        return true;
    }

    public void close() {
        System.out.println("[��Ϣ����]�رշ���ͨ��");
    }

    /**
     * ��������������ִ�еķ������ն��Ǵ˷���
     */
    public Object invoke(Object pro, Method method, Object[] args) throws Throwable {
        Object returnData = null;

        System.out.println("******ִ�з���********");

        if (this.connect()) {
            returnData = method.invoke(this.target, args);
            this.close();
        }
        return returnData;
    }
}

public class DynamicProxyDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 118 : ��̬�������ģʽ��");

        IMessage4DynamicProxyDemo msg = (IMessage4DynamicProxyDemo) new MLDNProxy()
            .bind(new MessageReal4DynamicProxyDemo());
        msg.send();
    }
}
