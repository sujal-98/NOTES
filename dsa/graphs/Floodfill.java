//Link-https://leetcode.com/problems/number-of-islands/

//Approach - Flood Fill BFS
// well this problem is more like applying bfs on a matrix 
// without converting it to adajency list or matrix

// sometimes people get into the stuff which involves making a 
// matrix for directions - might increase the complexity v badle just 
// do it like its done here in this solution (its pretty fast)
// avoid using queue (can be solved with it too)
// its like encountring a 1 and incrementing the island count
// then you set its neighbours 0 via bfs


public class Floodfill {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
          return 0;
      }
      //BFS
      int m=grid.length;
      int n=grid[0].length;
      int count=0;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(grid[i][j]=='1'){
                  count++;
                  bfs(grid,i,j);
              }
          }
      }
      return count;

  }

 // flood-fill by bfs
  public void bfs(char[][] grid,int row,int col){
      if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0'){
          return;
      }
      grid[row][col]='0';
      bfs(grid,row-1,col);
      bfs(grid,row+1,col);
      bfs(grid,row,col-1);
      bfs(grid,row,col+1);
  }
}
