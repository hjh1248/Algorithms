import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Village3 {
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            answer = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = st.nextToken().charAt(0);
                }
            }
            dfs(0, 0, new boolean[N][N], 0, false);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int r, int c, boolean[][] visited, int dist, boolean conv){
        visited[r][c] = true;
        if(map[r][c]=='M') conv = true;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && map[nr][nc]!='X'){
                if(nr==N-1 && nc==N-1 && conv){
                    answer = Math.max(answer, dist+1);
                    return;
                }
                visited[nr][nc] = true;
                dfs(nr, nc, visited, dist+1, conv);
                visited[nr][nc] = false;
            }
        }
    }      
}
