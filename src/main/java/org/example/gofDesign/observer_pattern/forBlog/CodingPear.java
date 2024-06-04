package org.example.gofDesign.observer_pattern.forBlog;

import java.util.ArrayList;
import java.util.List;

public class CodingPear implements Youtuber{
    private final List<Subscriber> subscribers;
    private boolean videoUpdated;
    private String videoName;


    public CodingPear() {
        this.subscribers = new ArrayList<>();
        this.videoUpdated = false;
        this.videoName = " ";
    }


    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getClass().getName() + " subscribed ur channel");
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getClass().getName() + "cancel subscription");

    }

    @Override
    public void uploadVideo(String videoName){
        System.out.println("new video is updated");
        this.videoUpdated = true;
        this.videoName = videoName;
        notifySubscribers();
    }

    private void notifySubscribers() {
        subscribers.forEach(Subscriber::update);
    }

    public boolean isVideoUpdated() {
        return videoUpdated;
    }

    public String getVideoName() {
        return videoName;
    }
}
