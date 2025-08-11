import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            visited[i] = true;
            queue.offer(i);

            while(!queue.isEmpty()){
                int cur = queue.pop();
                for(int next:list.get(cur)){
                    if(!visited[next]){
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}