package cn.mldn.older;

import java.util.Arrays;
import java.util.Comparator;

class NoComparablePerson
{
    private String name;
    private int age;
    public NoComparablePerson(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }
    
    //�޲ι��졢setter getterʡ��
    
    @Override
    public String toString()
    {
        return "NoComparablePerson [name=" + name + ", age=" + age + "]\n";
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

class PersonComparator implements Comparator<NoComparablePerson>
{
    //�����������
    @Override
    public int compare(NoComparablePerson o1, NoComparablePerson o2)
    {
        // TODO Auto-generated method stub
        return o1.getAge() - o2.getAge();
    }
}

public class ComparatorDemo
{
    public static void main(String[] args)
    {

        System.out.println("\n\nComparator�Ƚ������ڲ��޸�ԭ�� �����Ƚ������������£�������ȽϹ��ܣ� " );
        NoComparablePerson noComparablePersonArray[] = new NoComparablePerson[]
                {
                        new NoComparablePerson("Person-A", 80),
                        new NoComparablePerson("Person-B", 50),
                        new NoComparablePerson("Person-C", 100),
                };
        //ע�ͷſ���
        Arrays.sort(noComparablePersonArray, new PersonComparator());
        System.out.println("\n������������\n " + Arrays.toString(noComparablePersonArray));
        
        
        
    }
}
