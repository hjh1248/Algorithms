import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1774 {
    static int[] parent, rank;
    static int unionCnt;

    static class Edge implements Comparable<Edge>{
        int u, v;
        double w;

        public Edge(int u, int v, double w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double answer = 0;
        unionCnt = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        rank = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        double[][] node = new double[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            node[i][0] = Double.parseDouble(st.nextToken());
            node[i][1] = Double.parseDouble(st.nextToken());
        }
        int maxIdx = N*(N-1)/2;
        // u, v, cost
        Edge[] edges = new Edge[maxIdx];
        int idx = 0;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                Edge edge = new Edge(i, j, Math.hypot(node[j][0] - node[i][0], node[j][1] - node[i][1]));
                edges[idx] = edge;
                idx++;
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(a, b);
        }

        Arrays.sort(edges);

        for(Edge edge: edges){
            int u = edge.u;
            int v = edge.v;
            double cost = edge.w;

            if(union(u, v)) answer += cost;
            if(unionCnt==N-1) break;
        }

        System.out.printf("%.2f", answer);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        if(rank[pa] > rank[pb]) parent[pb] = pa;
        else if(rank[pa] < rank[pb]) parent[pa] = pb;
        else{
            parent[pb] = pa;
            rank[pa]++;
        }
        unionCnt++;
        return true;
    }
}