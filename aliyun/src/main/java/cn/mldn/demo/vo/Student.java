package cn.mldn.demo.vo;

public class Student implements Comparable<Student> {

    private String name;
    private double score;

    public Student(String name, double score) {
        super();
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }

    @Override
    public int compareTo(Student obj) {
        // TODO Auto-generated method stub
        if (this.score > obj.score) {
            return -1;
        } else if (this.score < obj.score) {
            return 1;
        } else {
            return 0;
        }
    }

}
