package com.goIit.homework.hashmap;

import java.util.HashMap;

public class StartMyHashMap {

  public static void main(String[] args) {

    MyHashMap<Integer, String> hashMap = new MyHashMap<>();
    hashMap.put(1, "First");
    hashMap.put(2, "Second");
    hashMap.put(3, "Third");
    hashMap.put(4, "Fourth");
    hashMap.put(5, "Fifth");
    hashMap.put(7, "Seventh");

    System.out.println("Print added collection => " + hashMap);
    System.out.println("Size collection is => " + hashMap.size());
    System.out.println("Get 4th element of collection is => " + hashMap.get(4));
    System.out.println("Remove 2nd element of collection is => " + hashMap.remove(2));
    System.out.println("Collection after removing => " + hashMap);
    hashMap.clear();
    System.out.println("Clear collection: " + hashMap);

  }
}