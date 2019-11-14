package Logger;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Logger {
  private Queue<Log> queue;
  private Set<String> messages;

  public Logger() {
    queue = new LinkedList<>();
    messages = new HashSet<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    while(!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10 ) {
      String expiredMessage = queue.remove().message;
      messages.remove(expiredMessage);
    }

    if(!messages.contains(message)) {
      queue.offer(new Log(timestamp, message));
      messages.add(message);
      return true;
    }

    return false;
}

  public static void main(String[] args) {
    Logger logger = new Logger();

// logging string "foo" at timestamp 1
    System.out.println(logger.shouldPrintMessage(1, "foo")); // returns true;

// logging string "bar" at timestamp 2
    System.out.println(logger.shouldPrintMessage(2,"bar")); // returns true

// logging string "foo" at timestamp 3
    System.out.println(logger.shouldPrintMessage(3,"foo")); // returns false

// logging string "bar" at timestamp 8
    System.out.println(logger.shouldPrintMessage(8,"bar")); // returns false

// logging string "foo" at timestamp 10
    System.out.println(    logger.shouldPrintMessage(10,"foo")); // returns false

// logging string "foo" at timestamp 11
    System.out.println(logger.shouldPrintMessage(11,"foo")); // returns true
  }

  class Log {
    int timestamp;
    String message;

    Log(int timestamp, String message) {
      this.timestamp = timestamp;
      this.message = message;
    }
  }
}
