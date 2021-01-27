package cn.mldn.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface DefaultAnnotation {

    public String title();

    public String url() default "Hello Leoooooooooooo!";
}

class Message4SelfDefinedAnnotationDemo {

    @DefaultAnnotation(title = "MLDN")

    public void send(String msg) {
        System.out.println("[������Ϣ]" + msg);
    }
}

public class SelfDefinedAnnotationDemo {

    public static void main(String[] args) throws Exception, SecurityException {
        System.out.println("Lesson 6.121 �Զ���Annotation��");

        Method method = Message4SelfDefinedAnnotationDemo.class.getMethod("send", String.class);
        DefaultAnnotation anno = method.getAnnotation(DefaultAnnotation.class);
        System.out.println(anno.title());
        System.out.println(anno.url());

        String msg = anno.title() + "(" + anno.url() + ")";
        method.invoke(Message4SelfDefinedAnnotationDemo.class.getDeclaredConstructor().newInstance(), msg);
    }
}
