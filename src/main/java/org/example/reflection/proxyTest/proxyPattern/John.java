package org.example.reflection.proxyTest.proxyPattern;

public class John implements Killer {
    private final String targetName;

    public John(String name) {
        this.targetName = name;
    }

    @Override
    public void acceptMission() {
        System.out.println(targetName + " might die");
    }
}
