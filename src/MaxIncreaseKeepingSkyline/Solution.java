package MaxIncreaseKeepingSkyline;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] skyline1 = new int[grid.length];
        int[] skyline2 = new int[grid.length];
        
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid.length;j++){
                if(grid[j][i] > skyline1[i]) {
                    skyline1[i] = grid[j][i];
                }
                if(grid[i][j] > skyline2[i]) {
                    skyline2[i] = grid[i][j];
                }
            }
        }
        
        int sum = 0;
        
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid.length;j++){
                sum += min(skyline1[j],skyline2[i]) - grid[i][j];
            }
        }
        
        return sum;
    }
    
    public int min(int a,int b){
        if(a < b) return a;
        else return b;
    }
}