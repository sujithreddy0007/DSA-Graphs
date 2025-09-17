class Solution {
    public void dfs(int[][] graph,int[] vist,int start)
    {
        vist[start]=1;
        for(int i=0;i<graph.length;i++)
        {
            if(graph[start][i]==1 && vist[i]==0)
            {
                dfs(graph,vist,i);
            }
        }
    }
    public int findCircleNum(int[][] graph) {
        int n=graph.length;
        int vist[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vist[i]==0)
            {
                dfs(graph,vist,i);
                count++;
            }
        }
        return count;
    }
}git push -u origin main