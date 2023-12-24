import java.util.ArrayDeque;
import java.util.Queue;

/*
*You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate
is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {
    private final int INF = Integer.MAX_VALUE;
    private final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] wallsAndGates(int[][] rooms) {
        //corner case, if the array is empty:
        if (rooms == null || rooms.length == 0) {
            return rooms;
        }
        // put all the zero value (gates) into a queue, start to look through 4 directions. If it is a wall then skip, if it is an INF
        // push into the queue and change the value to += 1, until we don't have anything in the queue.
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); // find the points of the current level
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                rooms[cur[0]][cur[1]] = distance;
                for (int[] dir : DIRS) {
                    // add into the queue
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < rooms.length && x >= 0 && y < rooms[0].length && y >= 0 && !visited[x][y] && rooms[x][y] == INF) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            distance++;
        }
        return rooms;
    }
}
