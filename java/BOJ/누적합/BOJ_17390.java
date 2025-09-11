import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] Tokens = br.readLine().split(" ");
        int N = Integer.parseInt(Tokens[0]);
        int T = Integer.parseInt(Tokens[1]);
        Tokens = br.readLine().split(" ");
        int[] nums = new int[N];
        int[] sums = new int[N+1];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(Tokens[i]);
        }
        Arrays.sort(nums);
        int tmp = 0;
        for(int i = 1; i<=N; i++){
            tmp += nums[i-1];
            sums[i] = tmp;
        }
        for(int tc = 1; tc<=T; tc++){
            Tokens = br.readLine().split(" ");
            int L = Integer.parseInt(Tokens[0]);
            int R = Integer.parseInt(Tokens[1]);
            sb.append(sums[R] - sums[L-1]).append("\n");
        }
        System.out.println(sb);
    }
}

