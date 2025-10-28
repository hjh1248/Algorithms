
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189{
    static int R, C, K, answer=0;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(chars[j]=='T') visited[i][j] = true;
            }
        }

        visited[R-1][0] = true;
        dfs(R-1, 0, 1);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int dist){
        if(dist==K){
            if(r==0 && c==C-1) answer++;
            return;
        }
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
            if(visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, dist+1);
            visited[nr][nc] = false;
        }
    }
}