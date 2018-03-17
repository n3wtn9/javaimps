package algorithms;

import java.util.*;

public class AStar {
    static class FScore implements Comparable<FScore> {
        Point p;
        double score;
        public FScore(Point p, double score) {
            this.p = p;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FScore fScore = (FScore) o;

            if (p != fScore.p) return false;
            return score == fScore.score;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = p != null ? p.hashCode() : 0;
            temp = Double.doubleToLongBits(score);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        public int compareTo(FScore fScore2) {
            if (fScore2 == null) throw new NullPointerException();

            return Double.compare(score, fScore2.score);
        }
    }

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
    PriorityQueue<FScore> fScore = new PriorityQueue();
    Point start;
    Point end;

    public AStar(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    void findPath(int[][] grid, Point start, Point end) {

    }
}
