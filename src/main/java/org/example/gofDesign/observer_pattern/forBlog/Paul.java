package org.example.gofDesign.observer_pattern.forBlog;

public class Paul implements Subscriber{

    private final String name = "Paul";
    private int likeability;

    private final CodingPear codingPear;

    public Paul(CodingPear codingPear) {
        this.codingPear = codingPear;
        codingPear.registerSubscriber(this);
    }


    @Override
    public void update() {
        System.out.println("new video is comming");
    }

    @Override
    public void update2() {

    }
}
