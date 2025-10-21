import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int start = 0;
        
        int[] sum = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            while(sum[i] - sum[start] >= S) {
                answer = Math.min(answer, i - start);
                start++;
            }
        }
        System.out.println(answer==Integer.MAX_VALUE?0:answer);
    }
}
