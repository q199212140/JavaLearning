package cn.mldn.demo;

class ReflectionSingleton
{
    //volatile 对象被实例化后应立刻与主内存中的数据对象进行同步
    private static volatile ReflectionSingleton instance = null;
    
    private ReflectionSingleton() 
    {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "实例化 ReflectionSingleton对象");
    }
    
    //public static synchronized ReflectionSingleton getInstance()会导致整个方法串行化，性能降低
    public static ReflectionSingleton getInstance()
    {        
        if(null == instance)
        {
          //只需要instance对象操作时才需要加同步
            synchronized (ReflectionSingleton.class)
            {
                if(null == instance)
                {
                    instance = new ReflectionSingleton();
                }
            }           
        }
        
        return instance;
    }
    
    public void print()
    {
        System.out.println("[单例] Hello world!");
    }
}

public class ReflectionAndSingletonDemo
{
    public static void main(String[] args)
    {
        System.out.println("Lesson 6.103 反射与单例设计模式");
        
        for(int x = 0; x < 3; x++)
        {
            new Thread(()->{
                ReflectionSingleton.getInstance().print();
            }, "单例消费端-" + x) .start();;
        }       
    }
}
