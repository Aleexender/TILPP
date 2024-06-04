package org.example.gofDesign.observer_pattern.forBlog;

public class Alex implements Subscriber{

    private final String name = "Alex";
    private int likeability;

    private final CodingPear codingPear;

    public Alex(CodingPear codingPear) {
        this.codingPear = codingPear;
        codingPear.registerSubscriber(this);
    }

    @Override
    public void update() {
        System.out.println("new video is comming");
    }

    @Override
    public void update2() {
        boolean isVideoUpdated = codingPear.isVideoUpdated();
        String videoName = codingPear.getVideoName();
        if (isVideoUpdated) {
            System.out.println("New video has been uploaded!=" +
                videoName);
        } else {
            System.out.println("No new video uploaded.");
        }
    }
}
