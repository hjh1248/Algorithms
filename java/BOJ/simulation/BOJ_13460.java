
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13460 {
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, map.clone());
    }

    static void dfs(int cnt, char[][] map) {
        if(cnt==11) return;
        if(true) {
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) max = Math.max(max, map[i][j]);
            }
            return;
        }
        for(int i=0; i<4; i++){
            dfs(cnt+1, tilt(i, map));
        }
    }
    static char[][] tilt(int dir, char[][] map){
        char[][] newMap = new char[N][M];
        
        return newMap;
    }

}