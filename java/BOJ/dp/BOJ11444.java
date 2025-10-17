import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11444 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        final int MOD = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int prev2 = 0;
        int prev1 = 1;

        for(int i=2; i<=n; i++){
            int cur = prev2 + prev1;
            prev2 = prev1;
            prev1 = cur%MOD;
        }
        System.out.println(prev1);
    }
}
