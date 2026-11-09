package Graph;

public class T1_numIslands {
    char[][]grids;
    int[][]visited;
    int count;
    int n;
    int m;
    int[][]dist={{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        grids=grid;
        visited=new int[n][m];
        count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //访问每一个点，如果已经访问过，直接跳过
                if(visited[i][j]==1)continue;
                //如果是陆地，则把相邻的所有陆地标记为访问过，并count++
                if(grids[i][j]=='1'){
                    count++;
                    visited[i][j]=1;
                    dfs(i,j);
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j){
        for(int[]dis:dist){
            int x=i+dis[0];
            int y=j+dis[1];
            if(x<0||y<0||x>=n||y>=m||grids[x][y]=='0'||visited[x][y]==1)continue;
            visited[x][y]=1;
            dfs(x,y);
        }
        return;
    }


}
