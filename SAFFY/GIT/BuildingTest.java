import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildingTest {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] d = {-1, 0, 1};

        for (int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];
            int max = 2;

            for(int i = 0; i < N; i++){
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input[j].charAt(0);
                }
            }
            for(int i=0; i<N; i++){
                outer:
                for(int j=0; j<N; j++){
                    if (arr[i][j] == 'B'){
                        for (int x = 0; x<3; x++){
                            for (int y = 0; y<3; y++){
                                if(0<=i+d[x] && i+d[x]<N && 0<=j+d[y] && j+d[y]<N){
                                    if(arr[i+d[x]][j+d[y]] == 'G'){
                                        continue outer;
                                    }
                                }
                            }
                        }
                        int sum = -1;
                        for (int x = 0; x<N; x++){
                            if (arr[x][j]=='B'){
                                sum += 1;
                            }
                        }
                        for (int y = 0; y<N; y++){
                            if (arr[i][y]=='B'){
                                sum += 1;
                            }
                        }
                        max = Math.max(max, sum);
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
	}
}