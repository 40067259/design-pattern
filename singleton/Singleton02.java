import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * @author Fred Zhang
 * @create 2020-03-28 12:49 AM
 */
public class Singleton02 {

    private static Singleton02 INSTANCE;

    private Singleton02(){}

    public static Singleton02 getINSTANCE(){  //multiple threads unsafe

        if(INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton02();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singleton02.getINSTANCE().hashCode());
            }).start();
        }
    }

}
