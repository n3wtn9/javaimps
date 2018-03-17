package algorithms;

import org.junit.Test;

public class SimpleMatrixTraversalTest {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0},
                {0,0,0},
                {0,1,0}
        };
        SimpleMatrixTraversal.Point start = new SimpleMatrixTraversal.Point(0,0);
        SimpleMatrixTraversal.Point end = new SimpleMatrixTraversal.Point(2,2);

        SimpleMatrixTraversal smt = new SimpleMatrixTraversal();
        smt.start(grid, start, end);
    }

}
