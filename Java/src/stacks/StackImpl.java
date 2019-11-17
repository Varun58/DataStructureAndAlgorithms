package stacks;

import java.util.Arrays;

public final class StackImpl {

  private int[] stack;
  private int size;
  private int top;
  private static final int DEFAULT_SIZE = 10;
  private int capacity;

  public StackImpl(int capacity) {
    this.stack = new int[capacity];
    this.capacity = capacity;
  }

  public StackImpl() {
    this.stack = new int[DEFAULT_SIZE];
    this.capacity = DEFAULT_SIZE;
  }

  public boolean push(int ele) {
    if (size >= capacity) {
      throw new IllegalStateException("Stack Overflow");
    }
    stack[top++] = ele;
    size++;
    return true;
  }

  public boolean pushDynamicExpand(int ele) {
    if (size >= capacity) {
      expand();
      return false;
    }
    stack[top++] = ele;
    size++;
    return true;
  }

  private void expand() {
    int[] newStack = new int[capacity * 2];
    System.arraycopy(stack, 0, newStack, 0, size);
    capacity = capacity * 2;
    stack = newStack;
  }

  private void shrink() {
    int[] newStack = new int[capacity / 2];
    System.arraycopy(stack, 0, newStack, 0, capacity / 2);
    capacity = capacity / 2;
    stack = newStack;
  }

  public int pop() {
    if (isEmpty()) {
      throw new  IllegalStateException("Stack Underflow");
    }

    int ele = stack[--top];
    stack[top] = 0;
    size--;

    if (size < capacity / 4) {
      shrink();
    }
    return ele;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack Underflow");
    }
    int ele = stack[top - 1];
    return ele;
  }

  public void printStack() {
    for (int i = this.size - 1; i >= 0; i--) {
      System.out.print(stack[i] + " ");
    }
    System.out.println();
  }

  public int getCapacity() {
    return capacity;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    StackImpl si = new StackImpl(20);
    si.pushDynamicExpand(23);
    si.pushDynamicExpand(32);
    si.pushDynamicExpand(4);
    si.pushDynamicExpand(3);
    si.pushDynamicExpand(65);
    si.printStack();
    si.pop();
    System.out.println(si.peek());
    Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}).forEach(x -> si.pushDynamicExpand(x));
    si.printStack();
    System.out.println(si.getCapacity());
    System.out.println(si.size());
    Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).forEach(x -> si.pushDynamicExpand(x));
    System.out.println(si.getCapacity());
    System.out.println(si.size());
    Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).forEach(x -> si.pop());
    Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}).forEach(x -> si.pop());
    System.out.println(si.getCapacity());
    System.out.println(si.size());
    Arrays.stream(new int[] {1, 2, 3, 4, 5}).forEach(x -> si.pop());
    System.out.println(si.getCapacity());
    System.out.println(si.size());
  }
}
