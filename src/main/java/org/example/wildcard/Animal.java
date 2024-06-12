package org.example.wildcard;

import java.util.List;

public interface Animal {
    void makeFriends(List<? extends Animal> animals);
}
