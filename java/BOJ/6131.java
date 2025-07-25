import java.io.*;

class Main6131 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1; i<=500; i++){
            for(int j = i; j<=500; j++){
                int diff = j*j - i*i;
                if(diff>=N){
                    if(diff == N) answer += 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }    
}
