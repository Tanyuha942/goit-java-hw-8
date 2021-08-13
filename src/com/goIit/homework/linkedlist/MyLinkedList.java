package com.goIit.homework.linkedlist;

import java.io.Serializable;
import java.util.*;

class MyLinkedList<E> extends AbstractCollection<Object> implements Serializable {

  private int size = 0;
  private Node<Object> first;
  private Node<Object> last;
  private Node<Object> next;

  private void linkLast(Object value) {
    Node<Object> l = last;
    Node<Object> newNode = new Node<>(l, value, null);
    last = newNode;
    if (l == null)
      first = newNode;
    else
      l.next = newNode;
    size++;
  }

  private void linkBefore(Object value, Node<Object> su) {
    Node<Object> prev = su.prev;
    Node<Object> newNode = new Node<>(prev, value, su);
    su.prev = newNode;
    if (prev == null)
      first = newNode;
    else
      prev.next = newNode;
    size++;
  }

  public boolean add(Object value) {
    if (next == null)
      linkLast(value);
    else
      linkBefore(value, next);
    return true;
  }

  public void clear() {
    first = last = null;
    size = 0;
  }

  Object unlink(Node<Object> x) {
    Object element = x.item;
    Node<Object> next = x.next;
    Node<Object> prev = x.prev;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      x.prev = null;
    }

    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }

    x.item = null;
    size--;
    return element;
  }

  public Object remove(int index) {
    return unlink(node(index));
  }

  Node<Object> node(int index) {

    Node<Object> x;
    if (index < (size >> 1)) {
      x = first;
      for (int i = 0; i < index; i++)
        x = x.next;
    } else {
      x = last;
      for (int i = size - 1; i > index; i--)
        x = x.prev;
    }
    return x;
  }

  public Object get(int index) {
    return node(index).item;
  }

  private class Itr implements Iterator<Object> {
    int cursor = 0;
    int last = -1;

    public boolean hasNext() {
      return cursor != size();
    }

    public Object next() {
      try {
        int i = cursor;
        Object next = get(i);
        last = i;
        cursor = i + 1;
        return next;
      } catch (IndexOutOfBoundsException e) {
        throw new NoSuchElementException(e);
      }
    }
  }

  public Iterator<Object> iterator() {
    return new Itr();
  }

  public int size() {
    return size;
  }
}

class Node<Object> {

  Object item;
  Node<Object> next;
  Node<Object> prev;

  public Node(Node<Object> prev, Object element, Node<Object> next) {
    this.item = element;
    this.next = next;
    this.prev = prev;
  }
}