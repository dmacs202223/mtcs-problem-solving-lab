class Solution {
    int[] parent;
    int[] rank;
    
    public int find(int m)
    {
        if(parent[m]==m)
            return m;
        return parent[m]=find(parent[m]);
    }
    
    public boolean union(int m, int n)
    {
        int parm = find(m);
        int parn = find(n);
        if(parm!=parn)
        {
            if(rank[parm]>rank[parn])
                parent[parn]=parm;
            else if(rank[parn]>rank[parm])
                parent[parm]=parn;
            else
           {
                parent[parn]=parm;
                rank[parm]++;
           }
            return true;
        }
        return false;
    }
    
    public int findCircleNum(int[][] isConnected) {
        parent= new int[isConnected.length+1];
        rank = new int[isConnected.length+1];
        int m,n;
        for(int j=0;j<parent.length;j++)
        {
            parent[j]=j;
            rank[j]=0;
        }
        
        int count= isConnected.length;
        for(int i=0;i<isConnected.length;i++)
        {
            for(int k=i+1;k<isConnected[i] .length;k++)
            {
                if(isConnected[i][k]==1)
                {
                    if(union(i,k))
                        count-=1;
                }
                
            }
        }
        return count;
    }
}
