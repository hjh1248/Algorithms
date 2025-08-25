import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Swea_realBFS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] mom = new int[N+1];
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] son = new ArrayList[N+1];

            for(int i=1; i<=N; i++){
                son[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=2; i<=N; i++){
                int a = Integer.parseInt(st.nextToken());
                son[a].add(i);
                mom[i] = a;
            }
            q.offer(1);
            int dist = -2;
            int tmp = 1;
            while(!q.isEmpty()){
                System.out.println(q);
                int cur = q.poll();
                dist += 2;
                boolean s = false;
                while(mom[cur] != mom[tmp]){
                    if(!s){
                        tmp = mom[tmp];
                        s = true;
                    }
                    else{
                        cur = mom[cur];
                        s = false;
                    }
                    dist++;
                }
                
                if(son[cur].size()==0){
                    tmp = cur;
                    continue;
                }
                for(int next : son[cur]){
                    q.offer(next);
                    dist += 2;
                    tmp = next;
                }
                dist--;
            }
            sb.append("#").append(tc).append(" ").append(dist).append("\n");
        }
        System.out.println(sb);
    }
}
