import java.util.Arrays;

/**
 * 实现二叉树的数据操作
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
         * 实现节点数据的适当位置存储
         * @param newNode
         */
        public void addNode(Node newNode)
        {
          //比当前节点数据小，左子树
            if(newNode.data.compareTo((T)this.data) <= 0)
            {
                if(null == this.left)//无左子树
                {
                    this.left = newNode;
                    newNode.parent = this;
                }
                else
                {
                    this.left.addNode(newNode);
                }
            }
            else//比当前节点数据大，右子树
            {
                //无右子树
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
         * 中序遍历实现所有数据获取
         */
        public void toArrayNode()
        {
            //右子树非空
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
            //找到了
            if(data.compareTo((T)this.data) == 0)
            {
                return true;
            }
            else if (data.compareTo((T)this.data) < 0)//左边有数据
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
         * 获取要删除的节点对象
         * @param data 比较对象
         * @return 要删除的节点对象，对象一定存在
         */
        public Node getRemoveNode(Comparable<T> data)
        {
            //找到了
            if(data.compareTo((T)this.data) == 0)
            {
                return this;
            }
            else if (data.compareTo((T)this.data) < 0)//左边有数据
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
    
    //以下实现二叉树的功能
    private Node root;
    private int count;//数据个数
    private Object[] returnData;
    private int foot = 0;//脚标
    
    /**
     * 
     * @param data
     */
    public void add(Comparable<T> data)
    {
        if(null == data)
        {
            throw new NullPointerException("保存的数据不允许为空");
        }
        
        Node newNode = new Node(data);
        if(null == this.root)//无根节点，则添加的节点作为根节点保存
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
     * 现在的检索主要依靠的是COmparable实现的数据比较
     * @param data
     * @return
     */
    public boolean contains(Comparable<T> data)
    {
        if(0 == this.count)
        {
            return false;
        }
        //该操作必须交给Node类完成
        return this.root.containsNode(data);
    }
    
    /**
     * 以对象数组的形式返回数据
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
     * 执行删除处理
     * @param data 要删除的数据
     */
    public void remove(Comparable<T> data)
    {
        //根节点不存在
        if(null == this.root)
        {
            return;
        }
        else
        {
            //要删除的是根节点
            if(this.root.data.compareTo((T)data) == 0)
            {
                Node moveNode = this.root.right;
                //一直向左子树找
                while(moveNode.left != null)
                {
                    moveNode = moveNode.left;
                }
                moveNode.left = this.root.left;
                moveNode.right = this.root.right;
                moveNode.parent.left = null;
                this.root = moveNode;    
            }
            //要删除的非根节点
            else
            {
                //找到要删除的节点
                Node removeNode = this.root.getRemoveNode(data);
                //要删除的数据存在
                if(removeNode != null)
                {
                    if((null == removeNode.left) && (null == removeNode.right))
                    {
                        //父节点断开引用
                        removeNode.parent.right = null;
                        removeNode.parent.left = null;
                        removeNode.parent = null;
                    }
                    //左边不为空
                    else if((removeNode.left != null) && (null == removeNode.right))
                    {
                        removeNode.parent.left = removeNode.left;
                        removeNode.left.parent = removeNode.parent;
                    }
                    //右边不为空
                    else if((removeNode.right != null) && (null == removeNode.left))
                    {
                        removeNode.parent.left = removeNode.right;
                        removeNode.right.parent = removeNode.parent;
                    }
                    //两边都有节点，找到最左边的节点
                    else
                    {
                        Node moveNode = removeNode.right;
                        //一直向左子树找
                        while(moveNode.left != null)
                        {
                            moveNode = moveNode.left;
                        }
                        //断开原本的连接
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
    
    //无参构造、setter getter省略
    
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
        System.out.println("二叉树实现：");
        
        BinaryTree<BTreePerson> tree = new BinaryTree<BTreePerson>();
        tree.add(new BTreePerson("小强-80", 80));
        tree.add(new BTreePerson("小强-50", 50));
        tree.add(new BTreePerson("小强-60", 60));
        tree.add(new BTreePerson("小强-30", 30));
        tree.add(new BTreePerson("小强-90", 90));
        tree.add(new BTreePerson("小强-10", 10));
        tree.add(new BTreePerson("小强-55", 55));
        tree.add(new BTreePerson("小强-70", 70));
        tree.add(new BTreePerson("小强-85", 85));
        tree.add(new BTreePerson("小强-95", 95));
        tree.remove(new BTreePerson("小强-80", 80));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}
