import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int rTmp = 0;
        int cTmp = 0;
        int answer = 0;
        
        for(int i=N-1; i>=0; i--){
            if(r>=rTmp + (1<<i)){
                answer += (1 << (2*i+1));
                rTmp += 1<<i;
            }
            if(c>=cTmp + (1<<i)){
                answer += (1 << (2*i));
                cTmp += 1<<i;
            }
        }
        System.out.println(answer);
    }
}
