package com.goIit.homework.queue;

import com.goIit.homework.myarraylist.MyArrayList;

class MyQueue<E> extends MyArrayList<E> {

  public Object peek() {
    return get(0);
  }

  public Object poll() {
    Object removeElement = get(0);
    remove(0);
    return removeElement;
  }
}