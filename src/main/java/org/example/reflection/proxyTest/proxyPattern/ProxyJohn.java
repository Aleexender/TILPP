package org.example.reflection.proxyTest.proxyPattern;

public class ProxyJohn implements Killer {
    private final String targetName;
    private John john;

    public ProxyJohn(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public void acceptMission() {
        if (john == null) {
            john = new John(targetName);
        }
        john.acceptMission();
    }
}
