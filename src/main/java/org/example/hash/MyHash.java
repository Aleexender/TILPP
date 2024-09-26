package org.example.hash;

import org.example.gofDesign.observer_pattern.forBlog.Alex;
import org.example.gofDesign.observer_pattern.forBlog.CodingPear;

public class MyHash {

    static final int hash(Object key) { // use XOR
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        int hash = MyHash.hash("as");
        int hash2 = MyHash.hash("a");
        int hash3 = MyHash.hash(new Alex(new CodingPear()));
        int hash4 = MyHash.hash(new Alex(new CodingPear()));


        System.out.println(hash);
        System.out.println(hash2);
        System.out.println(hash3);
        System.out.println(hash4);
    }
}
