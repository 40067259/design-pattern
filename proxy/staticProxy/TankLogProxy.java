package staticProxy;

/**
 * @author Fred Zhang
 * @create 2020-03-22 12:33 PM
 */
public class TankLogProxy implements Movable {

    Movable tankTimeProxy;

    public TankLogProxy(Movable tankTimeProxy){
        this.tankTimeProxy =tankTimeProxy;
    }

    @Override
    public void move() throws InterruptedException {
        System.out.println("Tank starts to move");
        tankTimeProxy.move();
        System.out.println("Tank ends to move");

    }


}
