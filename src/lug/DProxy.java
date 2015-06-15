package lug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Mryang on 15-4-3.
 */
public class DProxy implements InvocationHandler{
    private Subject subject = null;

    public DProxy(Subject subject){
        this.subject = subject;
    }

    public Subject newProxyInstance(ClassLoader cl, Class<?>[] interfaces){
        Subject subject1 = (Subject) Proxy.newProxyInstance(cl, interfaces, this);
        return subject1;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.subject,args);
    }


    public static void main(String[] args){
        Subject s = new RealSubject();

        Subject proxy = new DProxy(s).newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces());

        proxy.doSomething("ok");
    }
}
