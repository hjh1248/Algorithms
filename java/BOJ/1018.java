import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][];
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        int min = R*C;
        for(int i = 0; i<R-7; i++){
            for(int j = 0; j<C-7; j++){
                min = Math.min(min, repaint(board, i, j, 'W'));
                min = Math.min(min, repaint(board, i, j, 'B'));
            }
        }
        System.out.println(min);
    }

    static int repaint(char[][] board, int row, int col, char start_color){
        int cnt = 0;
        for(int r = row; r<row+8; r++){
            for(int c = col; c<col+8; c++){
                if((r+c)%2 == 0){
                    if(board[r][c] != start_color){
                        cnt++;
                    }
                }
                else{
                    if(board[r][c] == start_color){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}