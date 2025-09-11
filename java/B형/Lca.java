
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lca {
    static int[] parent0;
    static int[][] parent;
    static ArrayList<Integer>[] child;
    static int[] depths;
    static int maxDepth, maxLog;
    static int[] subTree;
    

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            child = new ArrayList[N+1];
            for(int i=1; i<=N; i++) child[i] = new ArrayList<>();
            parent0 = new int[N+1];
            depths = new int[N+1];
            subTree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                child[a].add(b);
                parent0[b] = a;
            }
            maxDepth = 0;
            dfs(1, 0);
            maxLog = (int) Math.ceil(Math.log(maxDepth) / Math.log(2));
            parent = new int[maxLog][N+1];
            parent[0] = parent0;

            for(int i=1; i<maxLog; i++){
                for(int j=1; j<=N; j++){
                    parent[i][j] = parent[i-1][parent[i-1][j]];
                }
            }
            int lca = lca(A, B);
            sb.append("#").append(tc).append(" ").append(lca).append(" ").append(subTree[lca]).append("\n");
        }
        System.out.println(sb);
    }
    static int dfs(int node, int depth){
        int sub = 1;
        maxDepth = Math.max(maxDepth, depth);
        depths[node] = depth;
        for(int i: child[node]){
            sub += dfs(i, depth+1);
        }
        subTree[node] = sub;
        return sub;
    }
    static int lca(int a, int b){
        // b의 깊이가 더 높게 설정
        if(depths[a] > depths[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }
        for(int i=maxLog-1; i>=0; i--){
            if(depths[b] - depths[a] >= 1<<i){
                b = parent[i][b];
            }
        }

        if(a==b) return a;
        
        for(int i=maxLog-1; i>=0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
