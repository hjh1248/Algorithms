import java.io.*;
import java.util.*;

class Main20301 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        int cnt = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            if(cnt/M%2==0){
                for(int i=0; i<K-1; i++){
                    queue.offer(queue.pop());
                }
                sb.append(queue.pop()).append("\n");
            }
            else{
                for(int i=0; i<K-1; i++){
                    queue.push(queue.removeLast());
                }
                sb.append(queue.removeLast()).append("\n");
            }

            cnt += 1;
        }
        
        System.out.println(sb);
    }
}