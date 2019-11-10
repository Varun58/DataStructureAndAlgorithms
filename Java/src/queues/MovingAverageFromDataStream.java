package queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class MovingAverageFromDataStream {
  // https://leetcode.com/problems/moving-average-from-data-stream/solution/

  public static void main(String[] args) {
    MovingAverageFromDataStream.MovingAverage1 m = new MovingAverageFromDataStream.MovingAverage1(3);
    System.out.println(m.next(1));
    System.out.println(m.next(10));
    System.out.println(m.next(3));
    System.out.println(m.next(5));

    MovingAverageFromDataStream.MovingAverage2 m2 = new MovingAverageFromDataStream.MovingAverage2(3);
    System.out.println(m2.next(1));
    System.out.println(m2.next(10));
    System.out.println(m2.next(3));
    System.out.println(m2.next(5));

    MovingAverageFromDataStream.MovingAverage3 m3 = new MovingAverageFromDataStream.MovingAverage3(3);
    System.out.println(m3.next(1));
    System.out.println(m3.next(10));
    System.out.println(m3.next(3));
    System.out.println(m3.next(5));
  }

  // Approach 3: Circular Queue with Array
  static class MovingAverage3 {
    int size;
    int head = 0;
    int count = 0;
    int windowSum = 0;
    int queue[];

    public MovingAverage3(int size) {
      this.size = size;
      this.queue = new int[size];
    }

    public double next(int val) {
      ++count;
      int tail = (head + 1) % size;
      windowSum = windowSum - queue[tail] + val;
      head = (head + 1) % size;
      queue[head] = val;

      return (windowSum * 1.0) / Math.min(count, size);
    }
  }

  // Approach 2: Double-ended Queue O(1)
  static class MovingAverage2 {
    int size;
    int count = 0;
    int windowSum = 0;
    Deque<Integer> queue = new ArrayDeque<>();

    public MovingAverage2(int size) {
      this.size = size;
    }

    public double next(int val) {
      ++count;
      queue.add(val);

      int tail = count > size ? queue.poll() : 0;

      windowSum = windowSum - tail + val;

      return (windowSum * 1.0) / Math.min(count, size);
    }
  }

  // Approach 1: Array or List O(n)
  static class MovingAverage1 {
    int size;
    List<Integer> queue = new ArrayList<>();

    public MovingAverage1(int size) {
      this.size = size;
    }

    public double next(int val) {
      queue.add(val);

      int ws = 0;
      for (int i = Math.max(0, queue.size() - size); i < queue.size(); i++) {
        ws += queue.get(i);
      }
      return (ws * 1.0) / Math.min(queue.size(), size);
    }
  }
}
