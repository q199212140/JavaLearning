package cn.mldn.demo;

import java.util.HashMap;
import java.util.Map;

class Person4SelfDefKeyInMap
{
    private String name;
    private int age;
    
    public Person4SelfDefKeyInMap(String name, int age)
    {
        super();
        this.name = name;
        this.age  = age;
    }

    @Override
    public int hashCode()
    {
        final int prime  = 31;
        int       result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person4SelfDefKeyInMap other = (Person4SelfDefKeyInMap) obj;
        if (age != other.age)
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
     
}

public class SelfDefKeyInMap
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 5.145.利用Iterator输出Map集合:");
        
        Map<Person4SelfDefKeyInMap, String> map = new HashMap<Person4SelfDefKeyInMap, String>();
        map.put(new Person4SelfDefKeyInMap("xiaozhang", 30), "张三");
        
        System.out.println(map.get(new Person4SelfDefKeyInMap("xiaozhang", 30)));
    }
}
