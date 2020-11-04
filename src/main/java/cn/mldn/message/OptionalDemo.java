package cn.mldn.message;

import java.util.Optional;

interface IMessage
{
    public String getContent();
}

class MessageImpl implements IMessage
{
    @Override
    public String getContent()
    {
        return "Hello World!";
    }
}

class MessageUtil
{
    private MessageUtil() {}
    
    //返回IMessage的Optional的包装对象
    public static Optional<IMessage> getMessage()
    {
        //return Optional.of(new MessageImpl());//null
        //return Optional.of(null);//null
        
        return Optional.ofNullable(null);//xception in thread "main" java.util.NoSuchElementException: No value present
    }
    
    public static void useMessage(IMessage msg)
    {
        System.out.println(msg.getContent());
    }
}

public class OptionalDemo
{
    public static void main(String[] args)
    {
        MessageUtil.useMessage(MessageUtil.getMessage().get());
    }
}
