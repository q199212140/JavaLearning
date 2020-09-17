//package cn.mldn.demo;
//
//import java.lang.reflect.Method;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//class Message4CGLIBProxy
//{
//    public void send()
//    {
//        System.out.println("[������Ϣ]Hello Leoooooooooo!");
//    }
//
//}
//
//class MLDNProxy4CGLIB implements MethodInterceptor//����������
//{
//    private Object target;//������ʵ�������
//
//    public MLDNProxy4CGLIB(Object target)
//    {
//        this.target = target;
//    }
//
//    public boolean connect()
//    {
//        System.out.println("[��Ϣ����]��Ϣ����ͨ������");
//        return true;
//    }
//
//    public void close()
//    {
//        System.out.println("[��Ϣ����]�رշ���ͨ��");
//    }
//
//    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable
//    {
//        Object returnData = null;
//
//        if(this.connect())
//        {
//            returnData = method.invoke(this.target, args);
//            this.close();
//        }
//
//        return returnData;
//    }
//
//}
//
//public class CGLIBProxyDemo
//{
//    public static void main(String[] args)
//    {
//        System.out.println("Lesson 6.119 CGLIBʵ�ִ������ģʽ����������(�ǽӿ�)");
//
//        Message4CGLIBProxy realObj = new Message4CGLIBProxy();
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(realObj.getClass());
//        enhancer.setCallback(new MLDNProxy4CGLIB(realObj));
//
//        Message4CGLIBProxy proxyObj = (Message4CGLIBProxy)enhancer.create();
//        proxyObj.send();
//    }
//}
