import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Island {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(tc);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 1 && !visited[i][j]) sb.append(" ").append(dfs(i, j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int r, int c){
        visited[r][c] = true;
        int size = 1;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc] && map[nr][nc]==1){
                size += dfs(nr, nc);
            }
        }
        return size;
    }
}