package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AStar {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    Set<Point> closedSet = new HashSet();
    Set<Point> openSet = new HashSet();
    Map<Point, Point> cameFrom = new HashMap();
    Map<Point, Integer> gScore = new HashMap();
    Map<Point, Integer> fScore = new HashMap();
    Point start;
    Point end;

    public AStar(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    void findPath(int[][] grid, Point start, Point end) {

    }
}
