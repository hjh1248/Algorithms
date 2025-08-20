import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};


        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                char c = str.charAt(j);
                if(c=='S'){
                    visited[i][j] = true;
                    q.offer(new int[] {i, j, 0});
                }
                if(c=='*'){
                    visited[i][j] = true;
                    q.push(new int[] {i, j, 1});
                }
                map[i][j] = c;
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(0<=nr && nr<R && 0<=nc && nc<R && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    if(cur[2]==1){
                        
                    }
                }
            }
            
        }
        
    }
}