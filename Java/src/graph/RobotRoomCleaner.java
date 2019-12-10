package graph;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

  interface Robot {
    public boolean move();

    public void turnLeft();

    public void turnRight();

    public void clean();
  }

  // https://www.youtube.com/watch?v=VQp7pfij7_Q
  public void cleanRoom(Robot robot) {
    HashSet<String> visited = new HashSet<>();
    cleanRoom(robot, 0, 0, 0, visited);
  }

  private void cleanRoom(Robot robot, int x, int y, int dir, Set<String> visited) {
    String cell = x + "-" + y;
    if (visited.contains(cell)) {
      return;
    }

    robot.clean();
    visited.add(cell);

    for (int i = 0; i < 4; i++) {
      if (robot.move()) {
        int newX = x;
        int newY = y;
        switch (dir) {
          case 0:
            newX = x - 1;
            break;
          case 90:
            newY = y + 1;
            break;
          case 180:
            newX = x + 1;
            break;
          case 270:
            newY = y - 1;
            break;
        }
        cleanRoom(robot, newX, newY, dir, visited);

        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();

      }
      robot.turnRight();
      dir += 90;
      dir = dir % 360;
    }
  }
}