package com.goIit.homework.queue;

public class TestMyQueue {

  public static void main(String[] args) {

//  класс MyQueue аналог класса Queue, который работает по принципу FIFO (first-in-first-out)
    MyQueue<Integer> myQueue = new MyQueue<>();
    myQueue.add(1);
    myQueue.add(2);
    myQueue.add(3);
    myQueue.add(4);
    myQueue.add(5);
    myQueue.add(6);
    myQueue.add(7);
    System.out.println("Print added collection => " + myQueue);

    System.out.println("Remove 4th element of collection is => " + myQueue.remove(4));
    System.out.println("Collection after removing => " + myQueue);
//    peek() возвращает первый элемент в очереди (FIFO)
    System.out.println("Get element of collection => " + myQueue.peek());
    System.out.println("Print collection => " + myQueue);
//    poll() возвращает первый элемент в очереди и удаляет его из коллекции (FIFO)
    System.out.println("Take element of queue and remove from collection => " + myQueue.poll());
    System.out.println("Queue after getting => " + myQueue);
    System.out.println("Get size of collection => " + myQueue.size());
    myQueue.clear();
    System.out.println("Clear collection: " + myQueue);
  }
}