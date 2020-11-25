package com.sunil.sun.lesson.utils;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName CollectionsUtil
 * @Description TODO
 * @Author jian.sun.qd
 * @Date 25/11/2020 11:49
 * @Version 1.0
 **/
public class CollectionsUtil {

    /**
     * List 转Iterable
     *
     * @param l
     * @param <T>
     * @return
     */
    static <T> Iterable<T> iterableReverseList(final List<T> l) {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    ListIterator<T> listIter = l.listIterator(l.size());

                    @Override
                    public boolean hasNext() {
                        return listIter.hasPrevious();
                    }

                    @Override
                    public T next() {
                        return listIter.previous();
                    }

                    @Override
                    public void remove() {
                        listIter.remove();
                    }
                };
            }
        };
    }
}
