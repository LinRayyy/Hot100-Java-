package Retrace;

public class T6_exist {

    int[][]direct={{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
            //先遍历，找到符合word首字母的字符
        boolean flag = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    int[][] visited = new int[board.length][board[0].length];
                    visited[i][j]=1;
                    if(dfs(board,0,i,j,visited,word)){
                        return true;
                    }
                }
            }
        }//然后开始bfs,符合的字母标记访问
        return false;
    }

    public boolean dfs(char[][] board,int index, int row, int col, int[][] visited,String word) {
        if(index==word.length()-1){
            return true;
        }
        for(int[]dir:direct){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if(newRow<0||newRow>=board.length||newCol<0||newCol>=board[0].length||visited[newRow][newCol]==1)continue;
            if(board[newRow][newCol]==word.charAt(index+1)){
                visited[newRow][newCol]=1;
                boolean res = dfs(board,index+1,newRow,newCol,visited,word);
                if(res){
                    return true; // 子分支找到，直接向上传递true
                }
                visited[newRow][newCol]=0;
            }
        }
        return false;
    }
}

