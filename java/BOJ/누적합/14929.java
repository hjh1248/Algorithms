import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String nums[] = br.readLine().split(" ");
        long answer = 0;
        long sum = 0;

        for(int i=0; i<N; i++){
            long num = Integer.parseInt(nums[i]);
            answer += num * sum;
            sum += num;
        }

        System.out.println(answer);
    }
}