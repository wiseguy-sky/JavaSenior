package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wy  wiseguy_sky@outlook.com
 * @create 2020-08-25 16:51
 */
public class MyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Object proxy = MyProxy.getProxy(new Man());

       /* Class[] interfaces = proxy.getClass().getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }*/

        /*System.out.println(proxy instanceof People);
        People proxy1 = (People) proxy;
        proxy1.does();*/

        ClothFactory clothFactory = (ClothFactory) MyProxy.getProxy(new NikeClothFactory());
        clothFactory.produceCloth();

        /*Class proxy2 = MyProxy.getProxy2(proxy);
        Object o = proxy2.newInstance();
        ((People)o).does();*/


    }
}

interface People {

    void does();
}

class Man implements People {

    @Override
    public void does() {
        System.out.println("男人打工挣钱");
    }
}

class MyProxy {


    public static Object getProxy(Object object) {

//        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new myInvocation(object));
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new myInvocation(object));


    }
    public static Class getProxy2(Object object) {

        Class proxyClass = Proxy.getProxyClass(object.getClass().getClassLoader(), object.getClass().getInterfaces());
        return proxyClass;

    }
}

class myInvocation implements InvocationHandler {

    private Object object;

    public myInvocation(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(object, args);

        return invoke;
    }
}

