package cn.mldn.util;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//public class ClassLoader4ClassLoaderDemo extends ClassLoader
//{
//    private static final String MESSAGE_CLASS_PATH_6_116 = "D:" + File.separator + "test" + File.separator  + "Message4ClassLoader.class";
//    /**
//     * ����ָ����ļ���
//     * @param className ��������  ��.������
//     * @return ָ���������
//     * @throws Exception ������ļ������ڣ����޷�����
//     */
//    public Class<?> loadData(String className) throws Exception
//    {
//        byte [] data = this.loadClassData();
//
//        if(data != null)
//        {
//            return super.defineClass(className, data, 0, data.length);
//        }
//
//        return null;
//    }
//
//    /**
//     * ͨ���ļ����������
//     * @return
//     * @throws Exception
//     */
//    private byte [] loadClassData() throws Exception
//    {
//        InputStream input = null;
//        ByteArrayOutputStream bos = null;//�����ݼ��ص��ڴ���
//        byte data[] = null;
//
//        try
//        {
//            //ʵ�����ڴ���
//            bos = new ByteArrayOutputStream();
//
//            //�ļ�������
//            System.out.println("FileInputStream:" + MESSAGE_CLASS_PATH_6_116);
//            input = new FileInputStream(new File(MESSAGE_CLASS_PATH_6_116));
//            input.transferTo(bos);
//
//            data = bos.toByteArray();
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }finally
//        {
//            if(input != null)
//            {
//                input.close();
//            }
//            if(bos != null)
//            {
//                bos.close();
//            }
//
//        }
//        System.out.println("return data:");
//        return data;
//    }
//}
