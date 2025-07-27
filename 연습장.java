import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연습장{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++){
                String str = br.readLine();
                for (int j = 0; j < N; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = N / 2 - cnt; j <= N / 2 + cnt; j++) {
                    sum += arr[i][j];
                }
                if (i < N/2) cnt++;
                else cnt--;                
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}

