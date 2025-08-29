import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Swea_realBFS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
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
            int dist = 0;
            int tmp = 1;
            while(!q.isEmpty()){
                int cur = q.poll();
                boolean s = false;
                int curCopy = cur;
                while(curCopy != tmp){
                    if(!s){
                        curCopy = mom[curCopy];
                        s = true;
                    }
                    else{
                        tmp = mom[tmp];
                        s = false;
                    }
                    dist++;
                }
                tmp = cur;
                for(int next : son[cur]){
                    q.offer(next);
                }
            }
            sb.append("#").append(tc).append(" ").append(dist).append("\n");
        }
        System.out.println(sb);
    }
}