import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[2][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        int computedMaxN = 1;

        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());

            if (N > computedMaxN) {
                int[][] newDp = new int[N + 1][2];
                System.arraycopy(dp, 0, newDp, 0, dp.length);

                for (int i = computedMaxN + 1; i <= N; i++) {
                    newDp[i][0] = newDp[i - 1][0] + newDp[i - 2][0];
                    newDp[i][1] = newDp[i - 1][1] + newDp[i - 2][1];
                }
                dp = newDp;
                computedMaxN = N;
            }
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}