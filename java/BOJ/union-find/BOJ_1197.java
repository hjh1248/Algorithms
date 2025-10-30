
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int answer = 0;
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        rank = new int[V+1];

        int[][] edges = new int[E][3];
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][0] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        for(int i=0; i<E; i++){

        }

    }
    static int find(int n){
        if(parent[n] == 0) return n;
        return parent[n] = find(n);
    }
    static boolean union(int a, int b){
        return false;
    }
}
