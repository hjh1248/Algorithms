import java.io.IOException;
import java.util.Scanner;

class Main1158 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("<");
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        int idx = 0;

        int[] arr = new int[N];
        int[] visited = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                if(idx>=N) idx = 0;
                if(visited[idx]==1){
                    j--;
                }
                else if(j==K-1){
                    sb.append(arr[idx]);
                    if(i<N-1) sb.append(", ");
                    visited[idx] = 1;
                }
                idx++;
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}