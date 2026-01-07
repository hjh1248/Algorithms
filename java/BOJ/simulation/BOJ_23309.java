import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[1000001][2];

        st = new StringTokenizer(br.readLine());
        int[] tmp = new int[N];
        for(int i=0; i<N; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }

        map[tmp[0]][0] = tmp[N-1];
        map[tmp[N-1]][1] = tmp[0];
        for(int i=0; i<N-1; i++){
            map[tmp[i]][1] = tmp[i+1];
            map[tmp[i+1]][0] = tmp[i];
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.charAt(0)=='B'){
                if(cmd.charAt(1)=='N'){
                    int cur = Integer.parseInt(st.nextToken());
                    int next = map[cur][1];
                    int newP = Integer.parseInt(st.nextToken());

                    map[cur][1] = newP;
                    map[next][0] = newP;
                    map[newP][0] = cur;
                    map[newP][1] = next;

                    sb.append(next).append("\n");
                }
                else{
                    int cur = Integer.parseInt(st.nextToken());
                    int prev = map[cur][0];
                    int newP = Integer.parseInt(st.nextToken());

                    map[cur][0] = newP;
                    map[prev][1] = newP;
                    map[newP][0] = prev;
                    map[newP][1] = cur;

                    sb.append(prev).append("\n");
                }
            }

            else{
                if(cmd.charAt(1)=='N'){
                    int cur = Integer.parseInt(st.nextToken());
                    int next = map[cur][1];
                    int nextNext = map[next][1];

                    map[cur][1] = nextNext;
                    map[nextNext][0] = cur;
                    
                    sb.append(next).append("\n");
                }
                else{
                    int cur = Integer.parseInt(st.nextToken());
                    int prev = map[cur][0];
                    int prevPrev = map[prev][0];

                    map[cur][0] = prevPrev;
                    map[prevPrev][1] = cur;

                    sb.append(prev).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
