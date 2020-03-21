package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Fred Zhang
 * @create 2020-03-21 11:27 AM
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {



        //---------There methods to obtain a class-----------//
        Student student = new Student();
        Class c1 = String.class;
        HashMap<Integer,Integer> hp = new HashMap<>();
        Class c2 = hp.getClass();
        Class c3 = student.getClass();
        Class c4 = Class.forName("reflect.Reflection");

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
        /**
         * out result:
         * class java.lang.String
         * class java.util.HashMap
         * class reflect.Student
         * class reflect.Reflection
         */


        //-------------obtain the class' methods information through reflection--------
        // we need import ---->  java.lang.reflect.Method
            Class c = Class.forName("reflect.Student");
            Object o = c.newInstance();
            Method method = c.getMethod("fun", String.class, int.class);
            method.invoke(o, "Fred", 38);

        /**
         * print result:  My name is Fred my age is 38
         *
         * With this approach, we can get a specific reflection of a method.
         *
         * How about all ?
         */

        //----------------get all methods of a class--------------------
        /**
         * we use for(Method m: methods) to iterate all declared methods
         */
        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods){
            String methodName = m.getName();
            System.out.println(methodName);
        }
        /**
         * result:
         * getName
         * setName
         * getJob
         * setJob
         * getAge
         * setAge
         * fun
         * Notice: we just got the declared methods not those from Father Class
         *
         * if we change getDeclaredMethods to getMethods,the Object Class' methods will
         * add:
         * wait  notify notifyAll equals getClass toString hashCode
         *
         *Now we can get methods' information, what about instance variables???
         */

        //--------------------get variable information-------------------
         //we need to import java.lang.reflect.Field
        try {
            Field field = c.getDeclaredField("name");//private need DeclaredField
            Object o1 = c.newInstance();
            field.setAccessible(true); // private variables need to reset
            Object name = field.get(o1);// get the field value of the field
            System.out.println(name);
        }
        catch(Exception e){

        }

        /**
         * result:Big Guy
         * What about all the fields
         */

        //-----------------get all fields---------------
        Field[] fields = c.getDeclaredFields();
        for(Field f : fields){
            String fieldName = f.getName();// get the instance variables' names
            f.setAccessible(true);
            Object value = f.get(o);// get the value of each variable
            System.out.println(fieldName+": "+value);
        }

        //---------------get all constructors via reflection
        Constructor[] constructors = c.getDeclaredConstructors();
        for(Constructor constructor: constructors){
            System.out.println(constructor);
        }
        /**
         * result:
         * public reflect.Student()
         * public reflect.Student(java.lang.String,int,java.lang.String)
         */

        //--------------------an interesting test------------------
        /**
         * we know that the generic to make the same type into a collection
         * this checkout process is working in compiler
         * now let's skip compiler and add a different type to a generic collection
         */
        ArrayList list1 = new ArrayList();            // no generic constrain
        ArrayList<String> list2 = new ArrayList<>();  // type constrains
        list2.add("hello");    //satisfy the constrains
       // list2.add(100);     violate the rule
        System.out.println("list2's length is: "+list2.size());

        //let's test the list1 and list2 classes
        System.out.println(list1.getClass()==list2.getClass());

        Class aClass = list2.getClass();
        Object aObject = aClass.newInstance();
        Method addMethod =aClass.getDeclaredMethod("add",Object.class);
        addMethod.invoke(list2,20);
        System.out.println("The length of list2 is:"+list2.size());// the length is 2
        //System.out.println(list2.get(1)); when we get the element, we trigger the compiler

    }

}

