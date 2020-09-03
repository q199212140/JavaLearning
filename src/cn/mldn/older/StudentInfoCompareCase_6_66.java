import java.util.Arrays;

class Student implements Comparable<Student>
{
    private String Name;
    private int age;
    private double score;
    
    public Student(String name, int age, double score)
    {
        super();
        this.Name = name;
        this.age = age;
        this.score = score;
    }
    
    @Override
    public int compareTo(Student stu)
    {
        if(this.score < stu.score)
        {
            return 1;
        }
        else if(this.score > stu.score)
        {
            return -1;
        }
        else
        {
            return this.age - stu.age;
        }
    }
    
    @Override
    public String toString()
    {
        return "[学生信息]：姓名：" + this.Name + "、年龄：" + this.age + "、成绩：" + this.score + "\n";
    }
}

public class StudentInfoCompareCase_6_66
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.66: 学生信息比较：成绩高低，年龄低高——比较器应用：");
        
        String input = "张三:21:98|李四:22:98|王五:20:70";
        
        String result[] = input.split("\\|");
        Student students[] = new Student[result.length];
        for(int x = 0; x < result.length; x++)
        {
            String temp[] = result[x].split(":");
            students[x] = new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
        }
        
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
