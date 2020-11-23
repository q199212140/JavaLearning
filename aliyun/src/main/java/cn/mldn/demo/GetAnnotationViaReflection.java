package cn.mldn.demo;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@FunctionalInterface
//@Deprecated(since="1.0")
interface IMessage4Annotation //��2��annotation
{

    public void send(String msg);
}

@SuppressWarnings("serial")
class MessageImpl4Annotation implements IMessage4Annotation, Serializable {

    public void send(String msg) {
        System.out.println("[��Ϣ����]  " + msg);

    }

}

public class GetAnnotationViaReflection {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        System.out.println("Lesson 6.120 ����ȥ��annotation��Ϣ��");

        System.out.println("�ӿڵ�annotation��Ϣ��");

        //��ȡ�ӿ��ϵ�annotation��Ϣ
        {
            Annotation annotations[] = IMessage4Annotation.class.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }

        System.out.println("\n�ӿڵ�annotation��Ϣ���գ��޷�������ʱ��ȡ");
        {
            Annotation annotations[] = MessageImpl4Annotation.class.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }

        System.out.println("\n��ȡtoString������annotation��Ϣ���գ��޷�������ʱ��ȡ");
        {
            Method method = MessageImpl4Annotation.class.getDeclaredMethod("send", String.class);
            Annotation annotations[] = method.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
    }
}
