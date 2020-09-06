package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-27 10:44
 */
public class MyTest {

    @Test
    public void test1() {
        //empty():创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        if(!op1.isPresent()){//Optional封装的数据是否包含数据
            System.out.println("数据为空");

        }
        System.out.println(op1);
        System.out.println(op1.isPresent());
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value.
//        System.out.println(op1.get());



    }

    public static Stream<Character> flapTest(String s) {

        ArrayList<Character> characters = new ArrayList<>();

        for (Character c : s.toCharArray()) {
            characters.add(c);
        }

        Stream<Character> stream = characters.stream();

        return stream;


    }

}
