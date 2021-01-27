package cn.mldn.older;

import java.util.Arrays;

class Student implements Comparable<Student> {

    private String Name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        super();
        this.Name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student stu) {
        if (this.score < stu.score) {
            return 1;
        } else if (this.score > stu.score) {
            return -1;
        } else {
            return this.age - stu.age;
        }
    }

    @Override
    public String toString() {
        return "[ѧ����Ϣ]��������" + this.Name + "�����䣺" + this.age + "���ɼ���" + this.score + "\n";
    }
}

public class StudentInfoCompareCase_6_66 {

    public static void main(String[] args) {
        System.out.println("Lesson 6.66: ѧ����Ϣ�Ƚϣ��ɼ��ߵͣ�����͸ߡ����Ƚ���Ӧ�ã�");

        String input = "����:21:98|����:22:98|����:20:70";

        String result[] = input.split("\\|");
        Student students[] = new Student[result.length];
        for (int x = 0; x < result.length; x++) {
            String temp[] = result[x].split(":");
            students[x] = new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
        }

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
