import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int filterR = 0;

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n==-1) filterR = i;
            }
        }

        for(int time=0; time<T; time++){

            //확산 값 정리
            int[][] spread = new int[R][C];
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    int n = map[i][j];
                    if(n<5) continue;
                    int x = n/5;
                    int cnt = 0;
                    for(int dir=0; dir<4; dir++){
                        int nr = i + dr[dir];
                        int nc = i + dr[dir];
                        if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                        if(map[nr][nc] == -1) continue;
                        spread[nr][nc] += x;
                        cnt++;
                    }
                    spread[i][j] -= x*cnt;
                }
            }

            // 확산
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    map[i][j] += spread[i][j];
                }
            }

            //이동
            for(int i=1; i<C-1; i++){
                
            }
        }

    }
}
