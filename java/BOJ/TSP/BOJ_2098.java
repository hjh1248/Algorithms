import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2098 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][1<<N];
    }

    static int dfs(int node, int visited){
        for(int i=1; i<=N; i++){
            if((visited & 1 << i) != 0) continue;
            dfs(i, visited | 1 << i);
        }

        
        return 0;
    }
}
