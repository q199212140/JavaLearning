package cn.mldn.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Person4TreeSet implements Comparable<Person4TreeSet> {

    /*source���Զ�����hashCode��equals�ӿڣ��ﵽHashSetȥ�ص�Ŀ��*/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person4TreeSet other = (Person4TreeSet) obj;
        if (age != other.age) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    private String name;
    private int age;

    public Person4TreeSet(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person4TreeSet [name=" + name + ", age=" + age + "]";
    }

    public int compareTo(Person4TreeSet per) {
        if (this.age < per.age) {
            return -1;
        } else if (this.age > per.age) {
            return 1;
        } else {
            return (this.name.compareTo(per.name));
        }
    }

}

public class TreeSetDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.132 Set�ӿڼ�飺");

        //Set�������ݱ��棬�����ظ����� JDK1.9֧��
        Set<String> all = new TreeSet<String>();
        all.add("Hello");
        all.add("Aello");
        all.add("Hello");
        all.add("World");
        all.add("Leooo");
        all.add("!!!");

        all.forEach(System.out::println);
        /*���������
         * Lesson 6.132 Set�ӿڼ�飺
        !!!
        Aello
        Hello
        Leooo
        World
        */

        System.out.println("\nʹ���Զ�����ʵ������������Զ��������ʵ��Comparable�ӿڣ���������Ƚ���䵽TreeSet�У�");
        //Set<Person4TreeSet> allPerson = new HashSet<Person4TreeSet>();
        Set<Person4TreeSet> allPerson = new TreeSet<Person4TreeSet>();

        allPerson.add(new Person4TreeSet("����", 33));
        allPerson.add(new Person4TreeSet("����", 44));
        allPerson.add(new Person4TreeSet("����", 11));
        allPerson.add(new Person4TreeSet("����", 22));
        allPerson.add(new Person4TreeSet("����", 22));

        allPerson.forEach(System.out::println);
        /*
         * Person4TreeSet [name=����, age=11]
        Person4TreeSet [name=����, age=22]
        Person4TreeSet [name=����, age=33]
        Person4TreeSet [name=����, age=44]*/

        System.out.println("\nLesson.6.135 Iterator���������");
        Iterator<Person4TreeSet> itr = allPerson.iterator();

        while (itr.hasNext()) {
            Person4TreeSet per = itr.next();
            if (per.compareTo(new Person4TreeSet("����", 22)) == 0) {
                //allPerson.remove(new Person4TreeSet("����", 22));
                /*����Collection�ӿڵ�ɾ������������������ɾ��ʧ��
                 * Lesson.6.135 Iterator���������
                Person4TreeSet [name=����, age=11]
                Exception in thread "main" java.util.ConcurrentModificationException*/

                itr.remove();//ɾ���ɹ�
            } else {
                System.out.println(per);
            }
        }
        //��ӡɾ���ڵ���Set
        while (itr.hasNext()) {
            Person4TreeSet per = itr.next();
            System.out.println(per);
        }
        System.out.println("All: " + allPerson);
    }
}
