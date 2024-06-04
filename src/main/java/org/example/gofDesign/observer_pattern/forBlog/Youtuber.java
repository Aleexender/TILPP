package org.example.gofDesign.observer_pattern.forBlog;

public interface Youtuber {
    void registerSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void uploadVideo(String videoName);
}
