import java.util.Scanner;

class DoubleArray {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case=1; test_case<=T; test_case++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] array1;
            int[] array2;


            if(N>M){
                array1 = new int[M];
                array2 = new int[N];
                for(int i=0; i<N; i++){
                    array2[i] = sc.nextInt();
                }
                for(int i=0; i<M; i++){
                    array1[i] = sc.nextInt();
                }
            }
            else{
                array1 = new int[N];
                array2 = new int[M];
                for(int i=0; i<N; i++){
                    array1[i] = sc.nextInt();
                }
                for(int i=0; i<M; i++){
                    array2[i] = sc.nextInt();
                }
            }
            int diffrence = Math.abs(M-N);
            int min = Math.min(M, N);
            int max = 0; 
            for(int i = 0; i <= diffrence; i++){
                int sum = 0;
                for(int j = 0; j < min; j++){
                    sum += array1[j]*array2[j+i];
                }
                max = Math.max(max, sum);
            }
            System.out.println("#"+test_case+" "+max);
            sc.close();
        }
    }
}
