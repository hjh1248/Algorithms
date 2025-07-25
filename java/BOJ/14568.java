import java.io.*;

class Main14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 2; i<=N-4; i+=2){
            for(int j = N-i-1; j>=3; j--){
                if(j<=N-i-j+1) break;
                answer++;
            }
        }
        System.out.println(answer);
    }
}