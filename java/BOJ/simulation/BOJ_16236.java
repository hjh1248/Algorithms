
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16236 {
    static int N, answer = 0;
    static int[][] map;
    // {r, c, size, cnt}
    static int[] shark = new int[4];
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        // 상어 크기
        shark[2] = 2;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                // 상어일 때 좌표 기록 후 맵 0으로 변경
                if(n==9){
                    shark[0] = i;
                    shark[1] = j;
                    n = 0;
                }
                map[i][j] = n;
            }
        }
        //상어 초기 위치에서 bfs 시작
        bfs(shark[0], shark[1]);

        System.out.println(answer);
    }
    static void bfs(int r, int c){
        // 큐, 방문 배열 초기화
        for(int i=0; i<N; i++) Arrays.fill(visited[i], false);
        q.clear();

        // 먹을 수 있는 물고기 좌표 리스트
        ArrayList<int[]> canEat = new ArrayList<>();

        q.offer(new int[] {r, c});
        visited[r][c] = true;
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            // size별 bfs
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int j=0; j<4; j++){
                    int nr = cur[0] + dr[j];
                    int nc = cur[1] + dc[j];
                    if(nr<0 || nc<0 || N<=nr || N<=nc) continue;
                    if(visited[nr][nc]) continue;
                    int next = map[nr][nc];
                    // 다음 물고기가 상어보다 크면 skip
                    if(shark[2]<next) continue;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                    // 물고기를 먹을 수 있으면 canEat 리스트에 좌표 추가
                    if(next!=0 && next<shark[2]){
                        canEat.add(new int[] {nr, nc});
                    }
                }
            }
            // canEat 리스트에 좌표가 있으면 실행
            if(!canEat.isEmpty()){
                // 행, 열 순서로 정렬
                canEat.sort((a, b) -> a[0] - b[0] !=0 ? a[0] - b[0] : a[1] - b[1]);

                // 상어 먹은 물고기 수 증가
                shark[3]++;
                // 상어 크기만큼 물고기를 먹으면 상어 사이즈 증가
                if(shark[2] == shark[3]){
                    shark[2]++;
                    shark[3] = 0;
                }
                // 상어가 이동한 거리만큼 answer 증가
                answer += dist;

                // 물고기를 먹은 위치에서 bfs 재귀 호출
                int[] next = canEat.get(0);
                int nr = next[0];
                int nc = next[1];
                map[nr][nc] = 0;
                bfs(nr, nc);
                return;
            }
        }
    }
}
