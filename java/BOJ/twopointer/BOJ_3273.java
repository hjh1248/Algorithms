import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] Tokens = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(Tokens[i]);
        }
        Arrays.sort(arr);
        int answer = 0;
        int first_idx = 0;
        int last_idx = n-1;
        while(first_idx<last_idx){
            if (arr[first_idx] + arr[last_idx]>x){
                last_idx--;
            }
            else if (arr[first_idx] + arr[last_idx]<x){
                first_idx++;
            }
            else {
                first_idx++;
                last_idx--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

