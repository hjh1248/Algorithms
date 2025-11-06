
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N*N+1][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                map[n][0] = i;
                map[n][1] = j;
            }
        }
        int number = 1;
        int answer = -1;
        // 이전 움직임이 비숍이나 나이트가 가능했는지 여부
        boolean check = false;
        // 1: 룩, 2: 비숍, 3: 나이트
        int status = 0;
        while(number<N*N){
            boolean tmpCheck = false;
            int r = map[number][0];
            int c = map[number][1];

            int cnt = 0;
            while(true){
                if(number + cnt + 1>N*N) break;
                int tmpR = map[number+cnt][0];
                int tmpC = map[number+cnt][1];
                int nr = map[number + cnt + 1][0];
                int nc = map[number + cnt + 1][1];
                if(tmpR+tmpC != nr+nc && tmpR-tmpC != nr-nc) break;
                cnt++;
            }
            if(cnt>=2){
                if(check) answer--;
                status = 2;
                number += cnt;
                answer += cnt+1;
                continue;
            }
            if(cnt==1) tmpCheck=true;

            cnt=0;
            while(true){
                if(number + cnt + 1>N*N) break;
                int tmpR = map[number+cnt][0];
                int tmpC = map[number+cnt][1];
                int nr = map[number + cnt + 1][0];
                int nc = map[number + cnt + 1][1];
                if(Math.abs(nr-tmpR) + Math.abs(nc-tmpC) !=3 ) break;
                if(nr-tmpR==0 || nc-tmpC==0) break;
                cnt++;
            }
            if(cnt>=2){
                if(check) answer--;
                status = 3;
                number += cnt;
                answer += cnt+1;
                continue;
            }
            if(cnt==1) tmpCheck=true;

            if(status != 1){
                answer++;
                status = 1;
            }
            int nr = map[number+1][0];
            int nc = map[number+1][1];
            if(r!=nr && c!=nc) answer++;
            answer++;
            number++;
            check = tmpCheck;
        }
        System.out.println(answer);
    }
}
