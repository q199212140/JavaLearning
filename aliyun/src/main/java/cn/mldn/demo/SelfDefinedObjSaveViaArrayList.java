package cn.mldn.demo;

import java.util.ArrayList;
import java.util.List;

class Person4SelfDefinedObjSaveViaArrayList {

    private String name;
    private int age;

    public Person4SelfDefinedObjSaveViaArrayList(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj) {
            return false;
        }

        if (!(obj instanceof Person4SelfDefinedObjSaveViaArrayList)) {
            return false;
        }

        Person4SelfDefinedObjSaveViaArrayList per = (Person4SelfDefinedObjSaveViaArrayList) obj;

        return ((this.name.equals(per.name)) && (this.age == per.age));
    }

    @Override
    public String toString() {
        return "Person4SelfDefinedObjSaveViaArrayList [name=" + name + ", age=" + age + "]";
    }

}

public class SelfDefinedObjSaveViaArrayList {

    public static void main(String[] args) {
        System.out.println("Lesson 6.127 �Զ�������󱣴棺");

        List<Person4SelfDefinedObjSaveViaArrayList> all = new ArrayList<Person4SelfDefinedObjSaveViaArrayList>();

        all.add(new Person4SelfDefinedObjSaveViaArrayList("����", 11));
        all.add(new Person4SelfDefinedObjSaveViaArrayList("����", 22));
        all.add(new Person4SelfDefinedObjSaveViaArrayList("Сǿ", 33));

        System.out
            .println("ʹ��List�����Զ�������������Ҫ�õ�contains��remove�������в�ѯ��ɾ������ʱ��һ��Ҫ��֤���и�дequals������");
        System.out.println(all.contains(new Person4SelfDefinedObjSaveViaArrayList("Сǿ", 33)));

        all.remove(new Person4SelfDefinedObjSaveViaArrayList("Сǿ", 33));

        all.forEach(System.out::println);//�������ô��������ͽӿ�


    }
}
