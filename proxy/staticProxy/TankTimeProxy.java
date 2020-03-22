package staticProxy;

/**
 * @author Fred Zhang
 * @create 2020-03-22 12:33 PM
 */

/**
 * Static proxy is used to add some universal additional functions to basic method
 * 1. we need to create a interface
 * 2. class1 implements the interface and override interface
 * 3. class2 implements the interface and pass a o1 of c1
 *    it overrides the interface: <1> add more functions </1>
 *                                <2> call the o1's interface</2>
 * Therefore,o2 is the proxy of o1 and 02.method add itself function
 *
 * It is an application of polymorphism
 *
 */
public class TankTimeProxy implements Movable {

    Movable tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        tank.move();
        Long endTime = System.currentTimeMillis();
        Long time = endTime - startTime;
        System.out.println("Tank moved "+time+" mill seconds");

    }
    public static void main(String[] args) throws InterruptedException {

        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}
