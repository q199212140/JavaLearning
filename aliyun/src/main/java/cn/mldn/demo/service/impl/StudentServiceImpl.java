package cn.mldn.demo.service.impl;

import java.io.File;
import java.util.Arrays;

import cn.mldn.demo.service.IStudentService;
import cn.mldn.demo.vo.Student;
import cn.mldn.util.FileUtil;

public class StudentServiceImpl implements IStudentService {

    private String content;
    private Student students[];
    private static final File STUDENT_DATA_SAVE_FILE = new File(
        "D:" + File.separator + "test" + File.separator + "student.txt" + File.separator);

    public StudentServiceImpl() {
        super();
        this.content = FileUtil.load(STUDENT_DATA_SAVE_FILE);
        this.studentGen();
    }

    @Override
    public void append(String str) {
        if (str.startsWith("|"))//ǰ�������ߣ���ȡ���ߺ��沿��
        {
            str = str.substring(1);
        }

        if (!str.endsWith("|"))//���ݺ�������ֱ��׷��
        {
            str = str + "|";//����ĩβ�����ߣ�׷������
        }

        //�����ļ�����׷��
        FileUtil.append(STUDENT_DATA_SAVE_FILE, str);
    }

    private void studentGen()//�ַ������ݴ������,����ѧ��
    {
        if ((null == this.content) || "".equals(this.content)) {
            return;//û�����ݿ��Դ���
        }

        String result[] = this.content.split("\\|");

        this.students = new Student[result.length];

        for (int x = 0; x < result.length; x++) {
            String temp[] = result[x].split(":");
            this.students[x] = new Student(temp[0], Double.parseDouble(temp[1]));
        }
    }

    @Override
    public Student[] getData() {
        // TODO Auto-generated method stub
        Arrays.sort(this.students);
        return this.students;
    }

}
