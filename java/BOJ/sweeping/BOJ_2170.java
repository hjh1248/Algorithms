import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        ArrayList<int[]> map = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            answer += b-a;
            map.add(new int[] {a, 0});
            map.add(new int[] {b, 1});
        }

        map.sort((a, b) -> a[0] - b[0]);
        
        int count = 0;
        int prev = 0;
        for(int[] node: map){
            if(node[1] == 0){
                answer -= (node[0] - prev)*(count-1);
                count++;
                prev = node[0];
            }
            else{
                answer -= (node[0] - prev)*(count-1);
                prev = node[0];
                count--;
            }
        }

        System.out.println(answer);

    }
}
