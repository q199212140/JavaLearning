package cn.mldn.older;

import java.util.Arrays;

/**
 * ʵ�ֶ����������ݲ���
 * @author Leo123_
 *
 */
class BinaryTree<T extends Comparable<T>>
{
    private class Node
    {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(Comparable<T> data)
        {
            this.data = data;
        }
        
        /**
         * ʵ�ֽڵ����ݵ��ʵ�λ�ô洢
         * @param newNode
         */
        public void addNode(Node newNode)
        {
          //�ȵ�ǰ�ڵ�����С��������
            if(newNode.data.compareTo((T)this.data) <= 0)
            {
                if(null == this.left)//��������
                {
                    this.left = newNode;
                    newNode.parent = this;
                }
                else
                {
                    this.left.addNode(newNode);
                }
            }
            else//�ȵ�ǰ�ڵ����ݴ�������
            {
                //��������
                if(null == this.right)
                {
                    this.right = newNode;
                    newNode.parent = this;
                }
                else
                {
                    this.right.addNode(newNode);
                }
            }
        }
        
        /**
         * �������ʵ���������ݻ�ȡ
         */
        public void toArrayNode()
        {
            //�������ǿ�
            if(this.left != null)
            {
                this.left.toArrayNode();
            }
            BinaryTree.this.returnData[BinaryTree.this.foot ++] = this.data;
            
            if(this.right != null)
            {
                this.right.toArrayNode();
            }
            
        }
        
        /**
         * 
         * @param data
         * @return
         */
        public boolean containsNode(Comparable<T> data)
        {
            //�ҵ���
            if(data.compareTo((T)this.data) == 0)
            {
                return true;
            }
            else if (data.compareTo((T)this.data) < 0)//���������
            {
                if(this.left != null)
                {
                    return this.left.containsNode(data);
                }
                else
                {
                    return false;
                }              
            }
            else
            {
                if(this.right != null)
                {
                    return this.right.containsNode(data);
                }
                else
                {
                    return false;
                }  
            }
        }
        
        /**
         * ��ȡҪɾ���Ľڵ����
         * @param data �Ƚ϶���
         * @return Ҫɾ���Ľڵ���󣬶���һ������
         */
        public Node getRemoveNode(Comparable<T> data)
        {
            //�ҵ���
            if(data.compareTo((T)this.data) == 0)
            {
                return this;
            }
            else if (data.compareTo((T)this.data) < 0)//���������
            {
                if(this.left != null)
                {
                    return this.left.getRemoveNode(data);
                }
                else
                {
                    return null;
                }              
            }
            else
            {
                if(this.right != null)
                {
                    return this.right.getRemoveNode(data);
                }
                else
                {
                    return null;
                }  
            }
        }
    }
    
    //����ʵ�ֶ������Ĺ���
    private Node root;
    private int count;//���ݸ���
    private Object[] returnData;
    private int foot = 0;//�ű�
    
    /**
     * 
     * @param data
     */
    public void add(Comparable<T> data)
    {
        if(null == data)
        {
            throw new NullPointerException("��������ݲ�����Ϊ��");
        }
        
        Node newNode = new Node(data);
        if(null == this.root)//�޸��ڵ㣬����ӵĽڵ���Ϊ���ڵ㱣��
        {
            this.root = newNode;
        }
        else
        {
            this.root.addNode(newNode);
        }
        this.count++;
    }
    
    /**
     * ���ڵļ�����Ҫ��������COmparableʵ�ֵ����ݱȽ�
     * @param data
     * @return
     */
    public boolean contains(Comparable<T> data)
    {
        if(0 == this.count)
        {
            return false;
        }
        //�ò������뽻��Node�����
        return this.root.containsNode(data);
    }
    
    /**
     * �Զ����������ʽ��������
     * @return Object[]
     */
    public Object[] toArray()
    {
        if(0 == this.count)
        {
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;
        this.root.toArrayNode();
        return this.returnData;
    }
    
    /**
     * ִ��ɾ������
     * @param data Ҫɾ��������
     */
    public void remove(Comparable<T> data)
    {
        //���ڵ㲻����
        if(null == this.root)
        {
            return;
        }
        else
        {
            //Ҫɾ�����Ǹ��ڵ�
            if(this.root.data.compareTo((T)data) == 0)
            {
                Node moveNode = this.root.right;
                //һֱ����������
                while(moveNode.left != null)
                {
                    moveNode = moveNode.left;
                }
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
                this.root = moveNode;    
            }
            //Ҫɾ���ķǸ��ڵ�
            else
            {
                //�ҵ�Ҫɾ���Ľڵ�
                Node removeNode = this.root.getRemoveNode(data);
                //Ҫɾ�������ݴ���
                if(removeNode != null)
                {
                    if((null == removeNode.left) && (null == removeNode.right))
                    {
                        //���ڵ�Ͽ�����
                        removeNode.parent.right = null;
                        removeNode.parent.left = null;
                        removeNode.parent = null;
                    }
                    //��߲�Ϊ��
                    else if((removeNode.left != null) && (null == removeNode.right))
                    {
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    }
                    //�ұ߲�Ϊ��
                    else if((removeNode.right != null) && (null == removeNode.left))
                    {
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    }
                    //���߶��нڵ㣬�ҵ�����ߵĽڵ�
                    else
                    {
                        Node moveNode = removeNode.right;
                        //һֱ����������
                        while(moveNode.left != null)
                        {
                            moveNode = moveNode.left;
                        }
                        //�Ͽ�ԭ��������
                        removeNode.parent.left = moveNode;
                        moveNode.parent.left = null;
                        moveNode.parent = removeNode.parent;
                        moveNode.right = removeNode.right;
                        moveNode.left = removeNode.left;                       
                    }                                       
                }
            }                        
            this.count--;
        }       
    }
}

class BTreePerson implements Comparable<BTreePerson>
{
    private String name;
    private int age;
    public BTreePerson(String name, int age)
    {
        this.name = name;
        this.age  = age;
    }
    
    //�޲ι��졢setter getterʡ��
    
    @Override
    public String toString()
    {
        return "BTreePerson [name=" + name + ", age=" + age + "]\n";
    }
    
    @Override
    public int compareTo(BTreePerson per)
    {
        return this.age - per.age;
    }
}

public class BTreeDemo
{
    public static void main(String[] args)
    {
        System.out.println("������ʵ�֣�");
        
        BinaryTree<BTreePerson> tree = new BinaryTree<BTreePerson>();
        tree.add(new BTreePerson("Сǿ-80", 80));
        tree.add(new BTreePerson("Сǿ-50", 50));
        tree.add(new BTreePerson("Сǿ-60", 60));
        tree.add(new BTreePerson("Сǿ-30", 30));
        tree.add(new BTreePerson("Сǿ-90", 90));
        tree.add(new BTreePerson("Сǿ-10", 10));
        tree.add(new BTreePerson("Сǿ-55", 55));
        tree.add(new BTreePerson("Сǿ-70", 70));
        tree.add(new BTreePerson("Сǿ-85", 85));
        tree.add(new BTreePerson("Сǿ-95", 95));
        tree.remove(new BTreePerson("Сǿ-80", 80));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}
