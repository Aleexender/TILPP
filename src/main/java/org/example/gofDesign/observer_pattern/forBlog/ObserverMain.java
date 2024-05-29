package org.example.gofDesign.observer_pattern.forBlog;

public class ObserverMain {
    public static void main(String[] args) {
        CodingPear codingPear = new CodingPear();

        Subscriber alex = new Alex(codingPear);

        Subscriber paul = new Paul(codingPear);


        //
        codingPear.notifySubscriber();

        System.out.println(codingPear.getLikeability());
    }
}
