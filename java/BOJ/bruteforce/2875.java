import java.io.*;
import java.util.*;

class Main2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i<K; i++){
            if(N > 2*M) N -= 1;
            else M -= 1;
        }
        System.out.println(Math.min(N/2, M));

    }
}
