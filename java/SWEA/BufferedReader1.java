import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class BufferedReader1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());	//테스트 케이스 개수
        int N, M;				//행, 열
        int[][] map;			//숫자 정보 저장 배열

        StringBuilder sb = new StringBuilder();
        for (int tc=1; tc<=T; tc++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //3
            M = Integer.parseInt(st.nextToken()); //4

            map = new int[N][M];
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#").append(tc).append("\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
