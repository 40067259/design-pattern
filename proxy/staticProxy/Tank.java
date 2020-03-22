package staticProxy;

import java.util.Random;

/**
 * @author Fred Zhang
 * @create 2020-03-22 12:31 PM
 */
public class Tank implements Movable{
    @Override
    public void move() throws InterruptedException {
        System.out.println("Tank is moving.....");
        try{
            Thread.sleep(new Random().nextInt(10000));
        } catch(InterruptedException e){
             e.printStackTrace();
        }

    }
}
