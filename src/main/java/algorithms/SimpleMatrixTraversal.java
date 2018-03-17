package algorithms;

import java.util.*;

public class SimpleMatrixTraversal {
    static class Point {
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point p = (Point) o;
            return x == p.x ? (y == p.y ? true : false) : false;
        }

        @Override
        public int hashCode() {
            int result = x;
            return 31 * result + y;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(x);
            sb.append(",");
            sb.append(y);
            sb.append(")");
            return sb.toString();
        }

        public Point add(Point other) {
            return new Point(x + other.x, y + other.y);
        }
    }

    Set<Point> closed = new HashSet<Point>();
    Map<Point, Point> parent = new HashMap<Point, Point>();
    Stack<Point> open = new Stack<Point>();

    boolean start(int[][] grid, Point start, Point end) {
        open.push(start);

        while (!open.empty()) {
            Point curr = open.pop();
            closed.add(curr);

            List<Point> dests = chartCourse(grid, curr);

            for (Point dest : dests) {
                parent.put(dest, curr);

                if (dest.equals(end)) {
                    printCourse(end);
                    return true;
                }
                else {
                    open.push(dest);
                }
            }
        }

        return false;
    }

    List<Point> chartCourse(int[][] grid, Point curr) {
        Point[] directions = {
                new Point( 1, 0),
                new Point(-1, 0),
                new Point( 0, 1),
                new Point( 0,-1)
        };

        List<Point> newDests = new ArrayList<Point>();
        int rows = grid.length;
        int columns = grid[0].length;

        for (Point dir : directions) {
            Point dest = curr.add(dir);
            if (!closed.contains(dest) &&
                dest.x >= 0 &&
                dest.x < rows &&
                dest.y >= 0 &&
                dest.y < columns &&
                grid[dest.x][dest.y] == 0) {
                newDests.add(dest);
            }
        }

        return newDests;
    }

    void printCourse(Point end) {
        Point p = end;
        do {
            System.out.println(p);
            p = parent.get(p);
        } while (p != null);
    }
}
