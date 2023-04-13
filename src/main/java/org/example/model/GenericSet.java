package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class GenericSet<T extends Identifiable> {
    private Map<Integer, T> map;

    public GenericSet() {
        map = new HashMap<Integer, T>();
    }

    public void add(T item) {
        if (!map.containsKey(item.getId())) {
            map.put(item.getId(), item);
        }else {
            System.out.println("Element Already exist with same ID.");
        }
    }

    public T remove(int id) {
        return map.remove(id);
    }

    public boolean peek(int id) {
        return map.containsKey(id);
    }

    public int size() {
        return map.size();
    }

    public boolean equals(Object object) {
        if (object instanceof GenericSet<?>) {
            GenericSet<?> otherSet = (GenericSet<?>) object;
            if (otherSet.size() != size()) {
                return false;
            }
            for (T item : map.values()) {
                if (!otherSet.peek(item.getId())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        for (T item : map.values()) {
            System.out.println(item);
        }
    }
}
