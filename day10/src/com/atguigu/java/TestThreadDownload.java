package com.atguigu.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class TestThreadDownload {


    /**
     * 目标：将旧文件dldl.txt中的内容用多线程与随机存取文件流复制到dldl1.txt文件中，并未涉及断点续传。
     *
     * 经测试：
     * 1.当程序包含多线程是似乎只能使用main方法测试，不能使用Junit单元测试。（个人猜测是单元测试时分线程会受到主线程的影响？）
     * 2.经测试文本文件、图片、视频都可以正常复制（下载）
     *
     */
//    public static void main(String[] args) {
//        File file = new File("dldl.txt");
//
//        RandomAccessFile raf1 = null;
//        long length = 0;
//        try {
//            raf1 = new RandomAccessFile("dldl2.txt", "rw");
//
//            length = file.length();
//            System.out.println(length);
//            raf1.setLength(length);
//
//            long len = length / 5;
//
//            for (int i = 0; i < 4; i++) {
//                new DownloadThread(len*i,len*(i+1),"dldl.txt","dldl2.txt").start();
//            }
//            new DownloadThread(len*4,length,"dldl.txt","dldl2.txt").start();
//
//            //测试复制图片通过
//            /*for (int i = 0; i < 4; i++) {
//                new DownloadThread(len * i, len * (i + 1), "爱情与友情.jpg", "爱情与友情3.jpg").start();
//            }
//            new DownloadThread(len * 4, length, "爱情与友情.jpg", "爱情与友情3.jpg").start();*/
////            new DownloadThread(0, len, "爱情与友情.jpg", "爱情与友情3.jpg").start();
//
//            //测试赋值一个java文件无误（虽暂时未发现乱码问题，但个人觉得或许仍存在隐患，毕竟其中也包含了部分中文）
//           /*for (int i = 0; i < 4; i++) {
//                new DownloadThread(len*i,len*(i+1),"RandomAccessFileTest.java","RandomAccessFileTest1.java").start();
//            }
//            new DownloadThread(len*4,length,"RandomAccessFileTest.java","RandomAccessFileTest1.java").start();*/
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (raf1 != null) {
//
//                try {
//                    raf1.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
    public static void main(String[] args) {
        downloadThread("226320354_nb2-1-64.flv", "226320354.flv");
    }
    public static void downloadThread(String basicFilePath,String targetFilePath) {
        File file = new File(basicFilePath);

        RandomAccessFile raf1 = null;
        long length = 0;
        try {
            raf1 = new RandomAccessFile(targetFilePath, "rw");

            length = file.length();
            System.out.println(length);
            raf1.setLength(length);

            //分成5份，用5个线程同时进行
            long len = length / 5;

            for (int i = 0; i < 4; i++) {
                //传入本线程的起始点与终止点的后一位
                new DownloadThread(len*i,len*(i+1),basicFilePath,targetFilePath).start();
            }
            new DownloadThread(len*4,length,basicFilePath,targetFilePath).start();

            //测试复制图片通过
            /*for (int i = 0; i < 4; i++) {
                new DownloadThread(len * i, len * (i + 1), "爱情与友情.jpg", "爱情与友情3.jpg").start();
            }
            new DownloadThread(len * 4, length, "爱情与友情.jpg", "爱情与友情3.jpg").start();*/
//            new DownloadThread(0, len, "爱情与友情.jpg", "爱情与友情3.jpg").start();

            //测试复制java文件通过
           /*for (int i = 0; i < 4; i++) {
                new DownloadThread(len*i,len*(i+1),"RandomAccessFileTest.java","RandomAccessFileTest1.java").start();
            }
            new DownloadThread(len*4,length,"RandomAccessFileTest.java","RandomAccessFileTest1.java").start();*/


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    static class DownloadThread extends Thread {

        private long start;
        private long end;
        private long stop;
        private RandomAccessFile rafRead;
        private RandomAccessFile rafWrite;

        public DownloadThread(long start, long end, String basicFilePath, String targetFilePath) throws FileNotFoundException {
            this.start = start;
            this.end = end;
            this.rafRead = new RandomAccessFile(basicFilePath, "r");
            this.rafWrite = new RandomAccessFile(targetFilePath, "rw");
        }

        @Override
        public void run() {

            try {
                /*System.out.println("start："+ start);
                System.out.println("end："+ end);*/
                rafRead.seek(start);
                rafWrite.seek(start);
                //此1024或可更换为效率更高的数（暂忽略）
                byte[] bytes = new byte[1024];
                int len, lensub;
                while (true) {
//                    System.out.println(Thread.currentThread().getName()+"  "+rafRead.getFilePointer());
                    //lensub，用来记录当前点位距离终止点位的字节距离，防止写入超出，造成乱码
                    if ((lensub = (int) (end - rafRead.getFilePointer())) >= bytes.length) {
                        //最后一组之前的复制
                        rafRead.read(bytes);
                        rafWrite.write(bytes, 0, bytes.length);
                    } else {
                        //最后一组复制
                        rafRead.read(bytes);
                        System.out.println(lensub);
                        rafWrite.write(bytes, 0, lensub);
                        break;
                    }

                }
                /*System.out.println("最后一行");
                System.out.println(len + "：" + rafRead.getFilePointer());*/


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (rafRead != null) {

                    try {
                        rafRead.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (rafWrite != null) {

                    try {
                        rafWrite.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }

    }

}
