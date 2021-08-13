package com.goIit.homework.myarraylist;

import java.util.*;

public class MyArrayList<E> {

  private static final int DEFAULT_CAPACITY = 10;
  private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};
  transient Object[] elementData = new Object[0];
  private int size;

  private Object[] grow(int minCapacity) {
    int oldCapacity = elementData.length;
    if (oldCapacity > 0 || elementData != DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
      return elementData = Arrays.copyOf(elementData, minCapacity++);
    } else {
      return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
    }
  }

  private Object[] grow() {
    return grow(size + 1);
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("[");
    for (Object e : elementData) {
      if (e != null) {
        s.append(e)
            .append(", ");
      }
    }
    s.append("]");
    return s.toString().replace(", ]", "]");
  }

  public int size() {
    return size;
  }

  private void add(Object value, Object[] elementData, int s) {
    if (s == elementData.length) {
      elementData = grow();
    }
    elementData[s] = value;
    size = s + 1;
  }

  public void add(Object value) {
    add(value, elementData, size);
  }

  public void clear() {
      elementData = new Object[0];
  }

  private void fastRemove(Object[] es, int indexRemove) {
    final int newSize = size - 1;
    if (newSize > indexRemove)
      System.arraycopy(es, indexRemove + 1, es, indexRemove, newSize - indexRemove);
    es[size = newSize] = null;
  }

  public E remove(int index) {
    Object[] newList = elementData;
    @SuppressWarnings("unchecked")
    E deleteValue = (E) newList[index];
    fastRemove(elementData, index);
    return deleteValue;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    return (E) elementData[index];
  }
}