import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Multiple3 {
    static int N;
    static int L;
    static int[] nums;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            answer = -1;

            st = new StringTokenizer(br.readLine());
            nums = new int[N];
            
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            multiple(0, 1,0);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void multiple(int idx, int mul, int cnt){
        if(mul>L) return;

        if(idx==N){
            if(cnt==0) return;
            answer = Math.max(answer,mul);
            return;
        }
        
        multiple(idx+1, mul*nums[idx], cnt+1);
        
        multiple(idx+1, mul, cnt);
    }
}