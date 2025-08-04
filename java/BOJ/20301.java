import java.io.IOException;
import java.util.Scanner;

class Main20301 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        int idx = 0;
        int cnt = 0;

        int[] arr = new int[N];
        int[] visited = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                if(idx>=N) idx = 0;
                if(idx<=-1) idx = N-1;
                if(visited[idx]==1){
                    j--;
                }
                else if(j==K-1){
                    sb.append(arr[idx]).append("\n");
                    visited[idx] = 1;
                    cnt++;
                }
                if(cnt/M%2==0) idx++;
                else idx--;
            }
        }
        System.out.println(sb);
    }
}