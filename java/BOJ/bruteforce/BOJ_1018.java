import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static void main(String[] args) throws IOException {

        // N, M 받아오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 체스판 배열 생성
        char[][] board = new char[R][];
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }

        //체스판 돌면서 체스판 칠하기
        int min = 32;
        for(int i = 0; i<R-7; i++){
            for(int j = 0; j<C-7; j++){
                min = Math.min(min, repaint(board, i, j));
            }
        }
        System.out.println(min);
    }

    // 8x8 체스판 칠하는 함수
    static int repaint(char[][] board, int row, int col){
        int cnt = 0;
        for(int r = row; r<row+8; r++){

            // r+c가 짝수인 칸과 홀수인 칸 색이 달라야 함
            for(int c = col; c<col+8; c++){
                if((r+c)%2 == 0){
                    if(board[r][c] == 'W'){
                        cnt++;
                    }
                }
                else{
                    if(board[r][c] == 'B'){
                        cnt++;
                    }
                }
            }
        }
        //다른 색으로 시작하는 cnt는 64-cnt
        return Math.min(cnt, 64-cnt);
    }
}