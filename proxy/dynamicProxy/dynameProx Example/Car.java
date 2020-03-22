package dynamicProxy;

/**
 * @author Fred Zhang
 * @create 2020-03-22 3:14 PM
 */
public class Car implements Movable {
    @Override
    public void inverse(int steps) {
        System.out.println("Car is going back "+steps+((steps > 1)?" steps":" step"));
    }

    @Override
    public void move() {
        System.out.println("Car is running.....");
    }
}
