import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        perm(0, 0, new int[M]);

        System.out.println(sb);
    }
    static void perm(int idx, int start, int[] subArr){
        if(idx==M){
            for(int i=0; i<M; i++){
                sb.append(subArr[i]);
                if(i!=M-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        int last_val = 0;
        for(int i=start; i<N; i++){
            if(arr[i] == last_val) continue; 

            subArr[idx] = arr[i];
            last_val = arr[i];

            perm(idx+1, i, subArr);
            visited[i] = false;
        }
    }
}
