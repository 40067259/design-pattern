package javaTips;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Fred Zhang
 * @create 2020-04-04 12:33 PM
 */
public class ArithmeticCalculatorProxy {

        private ArithmeticCalculator target;

        public ArithmeticCalculatorProxy(ArithmeticCalculator target){
            this.target = target;
        }

        public ArithmeticCalculator getProxy(){


            ArithmeticCalculator proxy = null;

            ClassLoader loader = target.getClass().getClassLoader();

            //proxy's type, in other words: which methods need to be executed

            Class interfaces[] = new Class[]{ArithmeticCalculator.class};

            //invocation handler
            // when call the specific method,execute the following method
            InvocationHandler h = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    /*
                      proxy: return the proxy object: $Proxy0
                      method: the calling method
                      args : the calling method's parameters
                     */
                    System.out.println("The method "+method.getName()+" begins with "+ Arrays.asList(args));
                    Object result = method.invoke(target,args);
                    System.out.println("The method "+method.getName()+" ends with "+ result);
                    return result;
                }
            };

            proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);

            return proxy;

        }

    public static void main(String[] args) {
        ArithmeticCalculator target = new ArithmeticCalculatorImp();

        ArithmeticCalculator proxy = new ArithmeticCalculatorProxy(target).getProxy();

        proxy.divide(20,10);

        proxy.add (101,99);


    }
}
