package javaTips;

import java.sql.SQLOutput;

/**
 * @author Fred Zhang
 * @create 2020-04-04 12:28 PM
 */
public class ArithmeticCalculatorImp implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("The result ---->" +(i + j) );
        return i + j;
    }

    @Override
    public int subtract(int i, int j) {
        System.out.println("The result ---->" +(i - j) );
        return i - j;
    }

    @Override
    public int multiple(int i, int j) {
        System.out.println("The result ---->" +(i * j) );
        return i * j;
    }

    @Override
    public int divide(int i, int j) {
        int tem = 0;
        try{
            tem = i / j;
        }catch (IllegalArgumentException e){
            System.out.println("can't be divided by zero");
        }
        System.out.println("The result ---->" +(i / j) );

        return tem;
    }
}
