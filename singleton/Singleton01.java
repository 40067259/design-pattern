/**
 * @author Fred Zhang
 * @create 2020-03-28 12:41 AM
 */
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();// It will be initialized once class in JVM

    private Singleton01(){}

    public Singleton01 getInstance(){

        return INSTANCE;
    }
}
