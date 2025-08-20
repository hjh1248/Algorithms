import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Multiple2 {
    static int N;
    static int R;
    static int L;
    static int[] nums;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] Tokens = br.readLine().split(" ");
            N = Integer.parseInt(Tokens[0]);
            R = Integer.parseInt(Tokens[1]);
            L = Integer.parseInt(Tokens[2]);
            answer = -1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            nums = new int[N];
            
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            multiple(0, 0, 1);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static void multiple(int start, int cnt, int mul){
        if(cnt==R){
            if(mul>L) return;
            answer = (Math.max(answer, mul));
            return;
        }
        for(int i=start; i<N; i++){
            multiple(i+1, cnt+1, mul*nums[i]);
        }
    }
}