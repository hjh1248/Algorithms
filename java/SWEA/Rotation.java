
import java.util.Scanner;

class Rotation {
    public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#" + test_case);
            int N = sc.nextInt();
            int[][] array = new int[N][N];
            int[][] array1 = new int[N][N];
            int[][] array2 = new int[N][N];
            int[][] array3 = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                	array[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    array1[j][N-i-1] = array[i][j];
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    array2[j][N-i-1] = array1[i][j];
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    array3[j][N-i-1] = array2[i][j];
                }
            }
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    System.out.print(array1[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j<N; j++){
                    System.out.print(array2[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j<N; j++){
                    System.out.print(array3[i][j]);
                }
                System.out.println();
            }
            sc.close();
		}
	}
}
