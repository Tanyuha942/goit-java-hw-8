package com.goIit.homework.stack;

public class TestMyStack {

  public static void main(String[] args) {

    MyStack<Integer> myStack = new MyStack<>();
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    myStack.push(4);
    myStack.push(5);
    myStack.push(6);
    myStack.push(7);
    System.out.println("Print added collection => " + myStack);

    System.out.println("Remove 3rd element of collection is => " + myStack.remove(3));
    System.out.println("Collection after removing => " + myStack);
//    peek() возвращает первый элемент в стеке (LIFO)
    System.out.println("Get element of collection => " + myStack.peek());
    System.out.println("Print collection => " + myStack);
//    pop() возвращает первый элемент в стеке и удаляет его из коллекции (LIFO)
    System.out.println("Take element of stack and remove from collection => " + myStack.pop());
    System.out.println("Stack after getting => " + myStack);
    System.out.println("Get size of collection => " + myStack.size());
    myStack.clear();
    System.out.println("Clear collection: " + myStack);
  }
}