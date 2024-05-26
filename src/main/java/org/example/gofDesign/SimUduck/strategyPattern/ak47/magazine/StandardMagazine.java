package org.example.gofDesign.SimUduck.strategyPattern.ak47.magazine;

public class StandardMagazine implements MagazineStrategy{

    public void load() {
        System.out.println("Loading standard magazine");
    }
}
