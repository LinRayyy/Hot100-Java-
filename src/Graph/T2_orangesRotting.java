package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class T2_orangesRotting {
    int[][]gird;
    int[][]dist={{1,0},{0,1},{0,-1},{-1,0}};
    int n,m;
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.gird = gird;
        int minutes = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        //先初始化扫一遍，看看有几个新鲜橙子
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if(fresh==0)return 0;

        //用队列进行bfs
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                for (int[] dis : dist) {
                    int x = arr[0] + dis[0];
                    int y = arr[1] + dis[1];
                    if (x >= 0 && x < n && y >=0 && y <m && grid[x][y] == 1 ) {
                        fresh--;
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes-1:-1;
    }

    public static void main(String[] args) {
        T2_orangesRotting t2r = new T2_orangesRotting();
        int[][]grids={{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(t2r.orangesRotting(grids));
    }
}
