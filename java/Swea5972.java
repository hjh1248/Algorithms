import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연습장{
    static int[] weights;
    static int N;
    static int answer;
    static int[] dists;
    static ArrayList<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dists = new int[N+1];
        for(int i=0; i<=N; i++){
            dists[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list[a].add(new int[] {b, d});
            list[b].add(new int[] {a, d});
        }
        dijkstra(1, 1);
        System.out.println(dists[N]);

    }
    static void dijkstra(int idx, int cnt){
        if(cnt==N) return;
        int minDist = Integer.MAX_VALUE;
        int[] next;
        int nextNode = 0;
        for(int i=0; i<list[idx].size(); i++){
            next = list[idx].get(i);
            if(next[1]<minDist){
                nextNode = next[0];
                minDist = next[1];
            }
        }
        dists[nextNode] = Math.min(dists[nextNode], dists[idx] + minDist);
        dijkstra(nextNode, cnt + 1);
    }
}
        