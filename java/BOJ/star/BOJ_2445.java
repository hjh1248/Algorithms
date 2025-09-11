import java.io.*;
import java.util.*;

public class BOJ_2445 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 1;

        for(int i=1; i<2*N; i++){
            for(int j=1; j<=cnt; j++){
                System.out.print("*");
            }
            for(int j=1; j<=2*(N - cnt); j++){
                System.out.print(" ");
            }
            for(int j=1; j<=cnt; j++){
                System.out.print("*");
            }
            if(i<N) cnt++;
            else cnt--;
            System.out.println();

        }
        sc.close();
    }
}