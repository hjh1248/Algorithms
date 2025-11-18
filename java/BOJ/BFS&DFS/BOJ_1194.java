import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1194{
    static int N, M, answer;
    static char[][] map;
    static boolean[] keyVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        answer = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startR = 0;
        int startC = 0;

        map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        keyVisited = new boolean[6];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char c = str.charAt(j);
                if(c=='0'){
                    startR = i;
                    startC = j;
                }
                map[i][j] = c;
            }
        }

        visited[startR][startC] = true;
        dfs(startR, startC, 0, visited);

        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }
    static void dfs(int r, int c, int dist, boolean[][] visited){
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            int nDist = dist+1;

            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if(visited[nr][nc]) continue;

            char nextChar = map[nr][nc];
            if(nextChar == '#') continue;
            else if(nextChar == '1'){
                answer = Math.min(answer, nDist);
                return;
            }
            else if(nextChar - 'a' >= 0){
                if(keyVisited[nextChar - 'a']) continue;
                keyVisited[nextChar - 'a'] = true;
                boolean[][] nextVisited = new boolean[N][M];
                nextVisited[nr][nc] = true;
                dfs(nr, nc, nDist, nextVisited);
                keyVisited[nextChar - 'a'] = false;
                continue;
            }
            else if(nextChar - 'A' >= 0){
                if(!keyVisited[nextChar - 'A']) continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, nDist, visited);
            visited[nr][nc] = false;
        }
    }
}