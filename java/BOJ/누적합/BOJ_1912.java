import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = n;
        int sum = n;
        for(int i=1; i<N; i++){
            n= Integer.parseInt(st.nextToken());
            sum = Math.max(n, sum+n);
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
