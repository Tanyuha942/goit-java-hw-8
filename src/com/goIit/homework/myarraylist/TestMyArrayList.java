package com.goIit.homework.myarraylist;

public class TestMyArrayList {

  public static void main(String[] args) {

    MyArrayList<String> myArrayList = new MyArrayList<>();
    myArrayList.add("Tom");
    myArrayList.add("Alice");
    myArrayList.add("Kate");
    myArrayList.add("Sam");
    myArrayList.add("Bob");
    myArrayList.add("5464");
    System.out.println(myArrayList);

    System.out.println("Get 5th element of collection is => " + myArrayList.get(3));
    System.out.println("Size collection is => " + myArrayList.size());
    System.out.println("Remove 5th element of collection is => " + myArrayList.remove(5));
    System.out.println("After remove => " + myArrayList);
    myArrayList.clear();
    System.out.println("Clear collection: " + myArrayList);
  }
}
