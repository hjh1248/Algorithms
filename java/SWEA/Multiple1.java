import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class Multiple1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            String[] Tokens = br.readLine().split(" ");
            int N = Integer.parseInt(Tokens[0]);
            int L = Integer.parseInt(Tokens[1]);
            int answer = -1;
             
            Tokens = br.readLine().split(" ");
            int[] nums = new int[N];
             
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(Tokens[i]);
            }
             
            for(int i=0; i<N-2; i++) {
                for(int j=i+1; j<N-1; j++) {
                    for(int k=j+1; k<N; k++) {
                        int mul = nums[i] * nums[j] * nums[k];
                        if(mul > L) continue;
                        answer = (Math.max(answer, mul));
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}