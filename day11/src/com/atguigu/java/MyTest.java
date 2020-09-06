package com.atguigu.java;

import org.junit.Test;

import java.io.PrintWriter;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-24 09:10
 */
public class MyTest {
    @Test
    public void test1() throws Exception {


        /*PrintWriter ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text1.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintWriter(fos, true);
//            ps = new PrintStream("text1.txt");
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
//                System.setOut(ps);
            }


            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                ps.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    ps.println(); // 换行
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }*/
/*
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text1.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
//            ps = new PrintStream("text1.txt");
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }


            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
*/

        PrintWriter printWriter = new PrintWriter("text1.txt");
        for (int i = 0; i <= 255; i++) { // 输出ASCII字符
//            System.out.print((char) i);
            printWriter.print((char)i);
            if (i % 50 == 0) { // 每50个数据一行
//                System.out.println(); // 换行
                printWriter.println();
            }
//            printWriter.flush();
        }
        printWriter.close();


    }

}






