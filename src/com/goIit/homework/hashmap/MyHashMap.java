package com.goIit.homework.hashmap;

import java.util.*;

class MyHashMap<K,V> {

  private int size;
  private Node[] table;
  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 16
  static final int MAXIMUM_CAPACITY = 1 << 30;
  static final float DEFAULT_LOAD_FACTOR = 0.75f;
  private int threshold;

  static int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("{");
    for (Object o : table) {
      if (o != null) {
        s.append(o).append(", ");
      }
    }
    return (s.toString().substring(0, s.length()) + "}").replace(", }", "}");
  }

  public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(key)) == null ? null : e.value;
  }

  private Node<K,V> getNode(Object key) {

    Node<K,V>[] tab;
    Node<K,V> first;
    int n, hash;
    K k;

    if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & (hash = hash(key))]) != null) {
      if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))
        return first;
    }
    return null;
  }

  public void put(K key, V value) {
    putVal(hash(key), key, value);
  }

  private Node<K,V>[] resize() {

    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;

    if (oldCap > 0) {
      if (oldCap >= MAXIMUM_CAPACITY) {
        threshold = Integer.MAX_VALUE;
        return oldTab;
      }
      else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)
        newThr = oldThr << 1;
    }
    else if (oldThr > 0)
      newCap = oldThr;
    else {
      newCap = DEFAULT_INITIAL_CAPACITY;
      newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
      float loadFactor = 0;
      float ft = (float)newCap * loadFactor;
      newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ? (int)ft : Integer.MAX_VALUE);
    }

    threshold = newThr;

    @SuppressWarnings({"unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
      for (int j = 0; j < oldCap; ++j) {
        Node<K,V> e;
        if ((e = oldTab[j]) != null) {
          oldTab[j] = null;
          if (e.next == null)
            newTab[e.hash & (newCap - 1)] = e;
          else {
            Node<K,V> loHead = null, loTail = null;
            Node<K,V> hiHead = null, hiTail = null;
            Node<K,V> next;
            do {
              next = e.next;
              if ((e.hash & oldCap) == 0) {
                if (loTail == null)
                  loHead = e;
                else
                  loTail.next = e;
                loTail = e;
              }
              else {
                if (hiTail == null)
                  hiHead = e;
                else
                  hiTail.next = e;
                hiTail = e;
              }
            } while ((e = next) != null);
            if (loTail != null) {
              loTail.next = null;
              newTab[j] = loHead;
            }
            if (hiTail != null) {
              hiTail.next = null;
              newTab[j + oldCap] = hiHead;
            }
          }
        }
      }
    }
    return newTab;
  }
// класс односвязной Node
  private Node<K,V> removeNode(int hash, Object key) {

    Node<K,V>[] tab;
    Node<K,V> p;
    int n, index;

    if ((tab = table) != null && (n = tab.length) > 0 &&
        (p = tab[index = (n - 1) & hash]) != null) {
      Node<K,V> node = null;
      K k;
      if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
        node = p;
      if (node != null) {
        tab[index] = node.next;
        --size;
        return node;
      }
    }
    return null;
  }

  public V remove(Object key) {
    Node<K,V> e;
    return (e = removeNode(hash(key), key)) == null ? null : e.value;
  }

  public void clear() {
      Arrays.fill(table, null);
  }

  private Node<K,V> newNode(int hash, K key, V value) {
    return new Node<>(hash, key, value, null);
  }

  private void putVal(int hash, K key, V value) {

    Node<K,V> p;
    int n, i;
    Node<K,V> e;
    K k;

    if (table == null || (n = table.length) == 0)
      n = (table = resize()).length;
    if ((p = table[i = (n - 1) & hash]) == null)
      table[i] = newNode(hash, key, value);
    else {
      if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
        e = p;
      else {
        for (; ; ) {
          if ((e = p.next) == null) {
            p.next = newNode(hash, key, value);
            break;
          }
          if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
            break;
          p = e;
        }
      }
      if (e != null) {
        e.value = value;
        return;
      }
    }
    if (++size > threshold)
      resize();
  }

  private static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    private Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
      this.hash = hash;
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }

    @Override
    public final String toString() {
      return key + "=" + value;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    @Override
    public V setValue(V newValue) {
      V oldValue = value;
      value = newValue;
      return oldValue;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this)
        return true;
      if (o instanceof Map.Entry<?, ?> e) {
        return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
      }
      return false;
    }
  }
}