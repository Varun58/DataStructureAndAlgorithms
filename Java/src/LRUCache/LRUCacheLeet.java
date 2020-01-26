package LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLeet {

  private Map<Integer, DLinkedNode> cache = new HashMap<>();
  private int size;
  private int capacity;
  private DLinkedNode head;
  private DLinkedNode tail;

  class DLinkedNode {
    int key;
    int value;
    DLinkedNode next;
    DLinkedNode prev;
  }

  public LRUCacheLeet(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    this.head = new DLinkedNode();
    this.tail = new DLinkedNode();

    head.next = tail;
    tail.prev = head;
  }

  private void addNode(DLinkedNode node) {
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(DLinkedNode node) {
    DLinkedNode next = node.next;
    DLinkedNode prev = node.prev;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(DLinkedNode node) {
    removeNode(node);
    addNode(node);
  }

  private DLinkedNode popTail() {
    DLinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if(node == null) {
      return -1;
    }

    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    DLinkedNode node = cache.get(key);
    if(node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      addNode(newNode);
      ++size;

      if(size > capacity) {
        DLinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }
}
