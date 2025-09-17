import java.util.*;
class Solution {
    void bfs(int[][] mat,int[] vis,int start)
    {
        Queue<Integer>queue=new LinkedList<>();
        queue.offer(start);
        vis[start]=1;
        while(!queue.isEmpty())
        {
            start=queue.poll();
            for(int i=0;i<mat.length;i++)
            {
                if(vis[i]!=1 && mat[start][i]==1)
                {
                    queue.offer(i);
                    vis[i]=1;
                }
            }
        }

    }
    public int findCircleNum(int[][] mat) {
        int v=mat.length;
        int[] vis=new int[v];
        int ans=0;
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                ans++;
                bfs(mat,vis,i);
            }
        }
        return ans;
    }
}