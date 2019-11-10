package arrays;

import java.util.Arrays;

public final class ImplementArrayList<E> {

  private int capacity;
  private int actSize;
  private transient Object[] elements;

  private static final int DEFAULT_CAPACITY = 10;

  public ImplementArrayList() {
    this.elements = new Object[DEFAULT_CAPACITY];
    this.capacity = DEFAULT_CAPACITY;
  }

  public ImplementArrayList(int capacity) {
    if (capacity > 0) {
      this.elements = new Object[capacity];
      this.capacity = capacity;
    } else if (capacity == 0) {
      this.elements = new Object[DEFAULT_CAPACITY];
      this.capacity = DEFAULT_CAPACITY;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void add(Object element) {
    if (actSize == capacity) {
      ensureCapacity();
    }

    elements[actSize++] = element;
  }

  private void ensureCapacity() {
    elements = Arrays.copyOf(elements, (actSize * 2));
    capacity = actSize * 2;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < actSize) {
      return (E) elements[index];
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < actSize) {
      Object obj = elements[index];
      elements[index] = null;
      int tempPos = index;
      while (tempPos < actSize - 1) {
        elements[tempPos] = elements[tempPos + 1];
        elements[tempPos + 1] = null;
        tempPos++;
      }

      actSize++;
      return (E) obj;
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public static void main(String[] args) {
    ImplementArrayList arrayList = new ImplementArrayList(20);
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    System.out.println(arrayList.get(2));
    System.out.println(arrayList.remove(2));
    System.out.println(arrayList.get(2));

    ImplementArrayList arrayList2 = new ImplementArrayList(0);
    arrayList2.add(12);
    System.out.println(arrayList2.actSize);
    System.out.println(arrayList2.capacity);
  }
}
