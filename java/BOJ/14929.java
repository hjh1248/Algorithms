import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String tokens[] = br.readLine().split(" ");
        int arr[] = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens[i]);
        }
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                answer += arr[i] * arr[j];
            }
        }
        System.out.println(answer);
    }
}