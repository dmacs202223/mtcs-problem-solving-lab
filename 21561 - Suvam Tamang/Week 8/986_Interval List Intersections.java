class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int leftIntersection, rightIntersection;
        while(i < firstList.length && j < secondList.length){
            leftIntersection = Math.max(firstList[i][0], secondList[j][0]);
            rightIntersection = Math.min(firstList[i][1], secondList[j][1]);
            
            if(rightIntersection >= leftIntersection)
                res.add(new int[]{leftIntersection, rightIntersection});
            
            if(firstList[i][1] == rightIntersection) i++;
            if(secondList[j][1] == rightIntersection) j++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}
