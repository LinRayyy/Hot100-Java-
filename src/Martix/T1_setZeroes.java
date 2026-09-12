package Martix;

public class T1_setZeroes {
    /*
    依旧原地哈希
    1.准备两个变量 firstRowHasZero 和 firstColHasZero 用来记录第0行和第0列原本有没有0存在
    2.从第一行第一列开始遍历，如果matrix[i][j]=0,则令matrix[i][0]和matrix[0][j]=0;
    3.根据matrix[0][j]和matrix[i][0]分别还原对应列和行的0情况，用firstRow和firstCol判断是否变零
     */
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;        //n 行
        int m=matrix[0].length;     //m 列
        boolean firstRowHasZero=false;
        boolean firstColHasZero=false;
        //注意：matrix[i][0] 扫的是第0列，matrix[0][j] 扫的是第0行，别写反
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0)firstColHasZero=true;
        }
        for(int j=0;j<m;j++){
            if(matrix[0][j]==0)firstRowHasZero=true;
        }
        //从第一行第一列开始遍历，用第0行第0列当标记位（此时标记位还没被破坏）
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //开始对矩阵进行化零处理，只动[1..n-1][1..m-1]，不污染第0行第0列的标记位
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)matrix[i][j]=0;
            }
        }
        //对第一行和第一列处理
        if(firstRowHasZero){
            for(int j=0;j<m;j++)matrix[0][j]=0;
        }
        if(firstColHasZero){
            for(int i=0;i<n;i++)matrix[i][0]=0;
        }

    }

    public static void main(String[] args) {
        int[][]matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        print(matrix);

        //反例：只有第0列有0、第0行没有0，用来验证两个标记位没有对调
        int[][]matrix2={{1,2,3},{0,4,5},{6,7,8}};
        setZeroes(matrix2);
        print(matrix2);
    }

    private static void print(int[][]matrix){
        for(int[]row:matrix){
            for(int v:row)System.out.print(v+" ");
            System.out.println();
        }
        System.out.println();
    }
}
