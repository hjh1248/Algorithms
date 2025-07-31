import java.util.Scanner;

class Eight {
    public static void main(String[] args){
        int[] d = { -1, 0, 1 };

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int sum = 0;

            int[][] arr = new int[N][M];
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    String a = sc.next();
                    char b = a.charAt(0);
                    int c = 0;
                    if (b != 'X'){
                        c = b - '0';
                    }
                    arr[i][j] = c;
                }
            }

            int[][] visited = new int[N][M];

            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if (arr[i][j] == 0){
                        for (int x=0; x<3; x++){
                            for (int y=0; y<3; y++){
                                if (0<=i+d[x] && i+d[x]<N && 0<=j+d[y] && j+d[y]<M){
                                    if (visited[i+d[x]][j+d[y]] == 0){
                                        sum += arr[i+d[x]][j+d[y]];
                                        visited[i+d[x]][j+d[y]] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
            sc.close();
        }
    }
}
