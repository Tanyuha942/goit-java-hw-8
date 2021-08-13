package com.goIit.homework.queue;

import com.goIit.homework.myarraylist.MyArrayList;

class MyQueue<E> extends MyArrayList<E> {

//  peek() возвращает первый элемент в очереди (FIFO)
  public Object peek() {
    return get(0);
  }

//  poll() возвращает первый элемент в очереди и удаляет его из коллекции (FIFO)
  public Object poll() {
    Object removeElement = get(0);
    remove(0);
    return removeElement;
  }
}