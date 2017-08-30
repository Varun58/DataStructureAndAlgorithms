package LRUCache;

import java.util.HashMap;

public class LRUCache {

	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head;
	private Node end;

	public LRUCache(int size) {
		this.capacity = size;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;

		if (head != null) {
			head.pre = n;
		}

		head = n;

		if (end == null)
			end = head;
	}

	public void remove(Node node) {
		if (node.pre != null) {
			node.pre = node.pre.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			end = node.pre;
		}
	}

	public void set(int key, int newValue) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = newValue;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, newValue);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);
			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}

}

class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + ", pre=" + pre + ", next=" + next + "]";
	}

}
