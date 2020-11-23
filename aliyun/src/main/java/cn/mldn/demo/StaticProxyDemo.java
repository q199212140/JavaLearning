package cn.mldn.demo;

interface IMessage4StaticProxyDemo {

    public void send();

}

class MessageReal4StaticProxyDemo implements IMessage4StaticProxyDemo {

    public void send() {
        System.out.println("[������Ϣ]Hello world!!!!!!!");
    }
}

/**
 * ��Ϣ������
 *
 * @author Leo123_
 */
class MessageProxy4StaticProxyDemo implements IMessage4StaticProxyDemo {

    //��Ϣ������һ��ҪΪ������������
    private IMessage4StaticProxyDemo message;

    public MessageProxy4StaticProxyDemo(IMessage4StaticProxyDemo message) {
        this.message = message;
    }

    //������ʵҵ������Ľӿڣ��ڶ�̬��������£���Ҫ��Խ����ӿڴ���
    public void send() {
        // TODO Auto-generated method stub
        if (this.connect()) {
            this.message.send();
            this.close();
        }
    }

    public boolean connect() {
        System.out.println("[��Ϣ����]��Ϣ����ͨ������");
        return true;
    }

    public void close() {
        System.out.println("[��Ϣ����]�رշ���ͨ��");
    }

}

public class StaticProxyDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 6.117 ��̬�������ģʽ");

        IMessage4StaticProxyDemo msg = new MessageProxy4StaticProxyDemo(new MessageReal4StaticProxyDemo());
        msg.send();
    }
}
