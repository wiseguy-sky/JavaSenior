package com.atguigu.java;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-11 10:19
 */
public class Season {

    private final String name;
    private final String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static final Season spring = new Season("春天", "春暖花开");
    public static final Season summer = new Season("春天", "春暖花开");
    public static final Season autumn = new Season("春天", "春暖花开");
    public static final Season winter = new Season("春天", "春暖花开");

    public  String getName() {
        return name;
    }

    public  String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Season.spring);
    }

}
