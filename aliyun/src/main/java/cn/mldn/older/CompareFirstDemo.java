package cn.mldn.older;

import java.util.Arrays;

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //�޲ι��졢setter getterʡ��

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]\n";
    }

    @Override
    public int compareTo(Person per) {
        return this.age - per.age;
    }
}

public class CompareFirstDemo {

    public static void main(String[] args) {
        System.out.println("5.52.�Ƚ����������룺");
        System.out.println("\nֻҪ�Ƕ������飬��������");
        String strArray[] = new String[]{"X", "A", "S", "P"};
        Arrays.sort(strArray);
        System.out.println("\n�ַ����������� " + Arrays.toString(strArray));

        Integer intArray[] = new Integer[]{5, 2, 9, 1};
        Arrays.sort(intArray);
        System.out.println("\n������������ " + Arrays.toString(intArray));

        System.out.println("\n�Զ������� ");
        Person perArray[] = new Person[]
            {
                new Person("Person-A", 80),
                new Person("Person-B", 50),
                new Person("Person-C", 100),
            };

        Arrays.sort(perArray);
        System.out.println("\n������������\n " + Arrays.toString(perArray));

    }
}
