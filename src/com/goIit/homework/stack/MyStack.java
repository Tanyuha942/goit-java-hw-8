package com.goIit.homework.stack;

import com.goIit.homework.myarraylist.MyArrayList;
import java.util.EmptyStackException;

class MyStack<E> extends MyArrayList<E> {

  public Object push(Object value) {
    add(value);
    return value;
  }

  public Object peek() {
    if (size() == 0)
      throw new EmptyStackException();
    return get(size() - 1);
  }

  public Object pop() {
    if (size() == 0)
      throw new EmptyStackException();
    Object popElement = get(size()-1);
    remove(size()-1);
    return popElement;
  }
}