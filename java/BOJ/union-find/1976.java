import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        rank = new int[N+1];
        
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                if(st.nextToken().equals("1")){
                    union(i, j);
                }
            }
        }
        String answer = "YES";
        st = new StringTokenizer(br.readLine());
        int tmp = find(Integer.parseInt(st.nextToken()));
        for(int i=0; i<M-1; i++){
            int cur = find(Integer.parseInt(st.nextToken()));
            if(tmp!=cur){
                answer = "NO";
                break;
            }
            tmp = cur;
        }
        System.out.println(answer);
    }
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa==pb) return;
        if(rank[pa]>rank[pb]){
            parent[pb] = pa;
        }
        else if(rank[pa]<rank[pb]){
            parent[pa] = pb;
        }
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}