class Solution {
  public char[][] updateBoard(char[][] board, int[] click) {
    if (board[click[0]][click[1]] == 'M') {
      board[click[0]][click[1]] = 'X';
      return board;
    }
    dfs(board, click[0], click[1], board.length, board[0].length);
    return board;
  }
  
  private void dfs(char[][] board, int x, int y, int m, int n) {
    if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'E') return;
    
    if (board[x][y] == 'M') board[x][y] = 'X';
    else {
      int count = countMines(board, x, y, m, n);
      if (count == 0) {
        board[x][y] = 'B';
        for (int i = -1; i <= 1; ++i) {
          for (int j = -1; j <= 1; ++j) {
             dfs(board, x + i, y + j, m, n);
          } 
        }
      } else {
        board[x][y] = (char)(count + '0');
      }
    }
  }
  
  private int countMines (char[][] board, int x, int y, int m, int n) {
    int count = 0;
    
     for (int i = -1; i <= 1; ++i) {
      for (int j = -1; j <= 1; ++j) {
        int x1 = x + i;
        int y1 = y + j;
        if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && board[x1][y1] == 'M') {
          count ++;
        }
      } 
    }
    
    return count;
  } 
    
}