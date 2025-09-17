import java.util.*;
class Pair
{
    int row;
    int col;
    int score;
    Pair(int row,int col,int score)
    {
        this.row=row;
        this.col=col;
        this.score=score;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<Pair>queue=new LinkedList<>();
       int n=grid.length;
       int m=grid[0].length;
       int[][] vist=new int[n][m];
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<m;j++)
        {
            if(grid[i][j]==2)
            {
                queue.offer(new Pair(i,j,0));
            }
        }
       }
       int ans=0;
       while(!queue.isEmpty())
       {
         Pair p=queue.poll();
         int row=p.row;
         int col=p.col;
         int score=p.score;
         ans=Math.max(ans,score);
         int[] rowArr={-1,0,1,0};
         int[] colArr={0,1,0,-1};
         for(int i=0;i<4;i++)
         {
            int nrow=row+rowArr[i];
            int ncol=col+colArr[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vist[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                vist[nrow][ncol]=1;
                queue.offer(new Pair(nrow,ncol,score+1));
            }
         }
       }
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<m;j++)
        {
            if(vist[i][j]==0 && grid[i][j]==1)
            {
              return -1;
            }
        }
       }
       return ans;
    }
}