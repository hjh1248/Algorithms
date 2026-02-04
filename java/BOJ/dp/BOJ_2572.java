import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2572 {
    static int N, answer;
    static int[][] visited;
    static ArrayList<int[]>[] map;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = 0;
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        cards = new int[N+1];
        for(int i=1; i<=N; i++){
            cards[i] = convert(st.nextToken().charAt(0));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new int[N+1][M+1];
        map = new ArrayList[M+1];
        for(int i=1; i<=M; i++) map[i] = new ArrayList<>();

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int color = convert(st.nextToken().charAt(0));

            map[u].add(new int[] {v, color});
            map[v].add(new int[] {u, color});
        }
        bfs();
        System.out.println(answer);

    }
    static void bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 1, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int dist = cur[0];
            if(dist>N) break;
            int village = cur[1];
            int point = cur[2];
            if(point < visited[dist+1][village]) continue;

            for(int[] next: map[village]){
                int nDist = dist + 1;
                int nVillage = next[0];
                int nPoint = point;

                if(cards[dist]==next[1]) nPoint += 10;

                if(nPoint >= visited[nDist][nVillage]){
                    q.offer(new int[] {nDist, nVillage, nPoint});
                    visited[nDist][nVillage] = nPoint;
                }
            }
        }
        for(int i=1; i<N; i++) answer = Math.max(answer, visited[N][i]);
    }

    static int convert(char c){
        if(c=='R') return 1;
        else if(c=='G') return 2;
        else if(c=='B') return 3;
        else return 0;
    }
}
