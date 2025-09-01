import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        parent = new int[N+1];
        rank = new int[N+1];

        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=1; i<=N; i++){
            int x = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, x));
        }
        for(int i=1; i<=N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<i; j++) st.nextToken();
            for(int j=i+1; j<=N; j++){
                int x = Integer.parseInt(st.nextToken());
                edges.add(new Edge(i, j, x));
            }
        }
        Collections.sort(edges);
        for(Edge e: edges){
            if(union(e.u, e.v)) answer += e.w;
        }
        System.out.println(answer);
    }
    static class Edge implements Comparable<Edge>{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa==pb) return false;
        if(rank[pa]>rank[pb]) parent[pb] = pa;
        if(rank[pa]<rank[pb]) parent[pa] = pb;
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
}