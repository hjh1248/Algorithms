import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Village2 {
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
            dfs(0, 0, new boolean[N][N], 0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int r, int c, boolean[][] visited, int dist){
        if(dist==11) return;
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && map[nr][nc]=='.'){
                if(nr==N-1 && nc==N-1) answer++;
                visited[nr][nc] = true;
                dfs(nr, nc, visited, dist+1);
                visited[nr][nc] = false;
            }
        }
    }      
}
