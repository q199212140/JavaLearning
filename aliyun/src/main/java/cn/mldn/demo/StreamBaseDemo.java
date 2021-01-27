package cn.mldn.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBaseDemo {

    public static void main(String[] args) {
        System.out.println("Lesson 5.150.Stream��������:");

        List<String> all = new ArrayList<String>();

        Collections.addAll(all, "C++", "Java", "Python", "Go", "JS", "JSP", "Json");

        Stream<String> stream = all.stream();

        //System.out.println(stream.count());//Ԫ�ظ�����4

        //System.out.println(stream.filter((ele)->ele.toLowerCase().contains("j")).count());//ͳ�Ʒ��������ĸ���

        //���ܷ������������ݣ���2��ȡ2
        List<String> result = stream.filter((ele) -> ele.toLowerCase().contains("j")).skip(2).limit(2)
            .collect(Collectors.toList());
        System.out.println(result);
    }
}
