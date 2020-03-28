/**
 * @author Fred Zhang
 * @create 2020-03-28 1:13 AM
 */
public class Singleton03 {

    private static Singleton03 INSTANCE;

    private Singleton03() {}

    public static Singleton03 getINSTANCE() {  //multiple threads safe


        if (INSTANCE == null) {
            synchronized(Singleton03.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton03();
                }
            }
        }

        return INSTANCE;
    }
    public static void main(String[] args) {

        for(int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singleton03.getINSTANCE().hashCode());
            }).start();
        }
    }

}
