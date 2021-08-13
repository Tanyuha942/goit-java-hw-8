package com.goIit.homework.linkedlist;

public class TestMyLinkedList {

  public static void main(String[] args) {

//    MyArrayList аналог классу ArrayList
    MyLinkedList<String> myLinkedList = new MyLinkedList<>();
    myLinkedList.add("Peter");
    myLinkedList.add("Vasiliy");
    myLinkedList.add("Jason");
    myLinkedList.add("Stanislav");
    myLinkedList.add("Nikolay");
    System.out.println(myLinkedList);

    System.out.println("Get 2nd element of collection is => " + myLinkedList.get(2));
    System.out.println("Remove 3rd element of collection is => " + myLinkedList.remove(3));
    System.out.println("Collection after removing => " + myLinkedList);
    System.out.println("Size collection is => " + myLinkedList.size());

    myLinkedList.clear();
    System.out.println(myLinkedList);
  }
}