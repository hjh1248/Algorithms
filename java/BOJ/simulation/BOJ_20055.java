import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] hasRobot = new boolean[2 * N];
        int up = 0;
        int zeroCnt = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
            if (belt[i] == 0) zeroCnt++;
        }

        ArrayDeque<Integer> robotQ = new ArrayDeque<>();

        while (zeroCnt < K) {
            cnt++;
            up = (up - 1 + 2 * N) % (2 * N);
            int down = (up + N - 1) % (2 * N);

            if (hasRobot[down]) {
                hasRobot[down] = false;
            }

            int qSize = robotQ.size();
            for (int i = 0; i < qSize; i++) {
                int robot = robotQ.poll();

                if (!hasRobot[robot]) continue;

                int next = (robot + 1) % (2 * N);

                if (!hasRobot[next] && belt[next] > 0) {
                    hasRobot[robot] = false;
                    belt[next]--;
                    
                    if (belt[next] == 0) {
                        zeroCnt++;
                    }

                    if (next == down) {
                    } else {
                        hasRobot[next] = true;
                        robotQ.offer(next);
                    }
                } else {
                    robotQ.offer(robot);
                }
            }

            if (belt[up] > 0 && !hasRobot[up]) {
                hasRobot[up] = true;
                belt[up]--;
                
                if (belt[up] == 0) {
                    zeroCnt++;
                }
                robotQ.offer(up);
            }
        }

        System.out.println(cnt);
    }
}