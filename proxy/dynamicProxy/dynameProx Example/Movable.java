package dynamicProxy;

/**
 * @author Fred Zhang
 * @create 2020-03-22 1:04 PM
 */

/**
 * what if we want to proxy a random object ? For example: log and timeRecord
 * For the previous version, the type of Movable just can be proxy.
 * we don't know the class Type and don't know which methods need to proxy
 *
 * the dynamic proxy is introduced: the proxy class is generated by JVM not programmer
 * You can't see the codes of the proxy class
 * You can display it use System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 * in (package com.sun.proxy;) name: $Proxy0
 *
 *
 */
public interface Movable {

    public void inverse(int steps);

    public void move();



}