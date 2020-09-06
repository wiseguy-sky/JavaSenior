package com.atguigu.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-21 18:48
 */
public class MyTest {

    @Test
    public void mm() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile r = new RandomAccessFile(file, "rw");
        r.seek(3);

        StringBuilder stringBuilder = new StringBuilder((int) file.length());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = r.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, len));
        }
//        r.seek(3);
        r.write("whoami？".getBytes());
        r.write(stringBuilder.toString().getBytes());

    }

    @Test
    public void mm1() throws IOException {
        File file = new File("hello.txt");
        RandomAccessFile r = new RandomAccessFile(file, "rw");
        r.seek(3);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = r.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        r.seek(3);
        r.write("whoami？".getBytes());
        r.write(byteArrayOutputStream.toByteArray());
    }

    @Test
    public void mm2() {

    }
}
