package me.yushuo.concurrency.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample3 {

    // java.util.ConcurrentModificationException 建议进行标记，遍历结束后删除
    private static void test1(Vector<Integer> v) { // foreach
        for (Integer i : v) {
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException 建议进行标记，遍历结束后删除
    private static void test2(Vector<Integer> v) { // iterator
        Iterator<Integer> iterator = v.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v.remove(i);
            }
        }
    }

    // success
    private static void test3(Vector<Integer> v) { // for
        for (int i = 0; i < 3; i++) {
            if (v.get(i).equals(3)) {
                v.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test1(vector);
    }
}
