import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1102 {
    static int INF = 1000;
    static int N, P;
    static int[][] dists;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = INF;
        
        dists = new int[N][N];
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                dists[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char[] chars = br.readLine().toCharArray();
        int visited = 0;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(chars[i] == 'Y'){
                visited |= 1<<i;
                cnt++;
            }
        }
        P = Integer.parseInt(br.readLine());
        dp = new int[1<<N];
        Arrays.fill(dp, -1);

        System.out.println(dfs(visited, cnt));
        
        System.out.println(answer);
    }

    static int dfs(int visited, int cnt){
        if(cnt==P) return 0;

        if(dp[visited] != -1) return dp[visited];

        int min = INF;
        for(int i=0; i<N; i++){

        }

        return min;
    }
}
