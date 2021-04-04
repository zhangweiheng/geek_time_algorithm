class Solution {
  boolean [][] row = new boolean[9][10];
  boolean [][] col = new boolean[9][10];
  boolean [][] block = new boolean[9][10];
  
  public void solveSudoku(char[][] board) {
    // 预处理， 把所有已经有的数字扫一遍。
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '0';
          row[i][num] = true;
          col[j][num] = true;
          block[i/3 * 3 + j/3][num] = true;
        }
      }
    }
    slove(0, 0, board);
  }
  
  private boolean slove(int x, int y, char[][] board) {
    // 到最后一行就终止了
    if (x == 9) return true;
    
    // 计算下一层去哪个格子，注意这个手法。
    int ny = (y + 1) % 9;
    int nx = ny == (y + 1) ? x : x + 1;
    
    // 递归向下尝试。
    if (board[x][y] != '.')  return slove(nx, ny, board);
    else {
      for (int num = 1; num <= 9; ++num) {
        if (row[x][num] || col[y][num] || block[x/3 * 3 + y/3][num]) continue;
        
        board[x][y] = (char) (num + '0');
        row[x][num] = true;
        col[y][num] = true;
        block[x/3 * 3 + y/3][num] = true; 
        
        if (slove(nx, ny, board)) return true;
        
        board[x][y] = '.';
        row[x][num] = false;
        col[y][num] = false;
        block[x/3 * 3 + y/3][num] = false;
      }
    }
      
    return false;
  }
  
}