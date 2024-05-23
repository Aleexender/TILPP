package org.example.reflection.proxyTest.proxyPattern;

public class ProxyMain {
    public static void main(String[] args) {
        Killer killer = new ProxyJohn("Alex");
        Killer killer1 = new ProxyJohn("Mac");

        killer.acceptMission();
        killer1.acceptMission();


    }
}
