import java.io.*;

public class BOJ_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<2*N-1; i++){
            for(int j=0; j<cnt; j++){
                System.out.print(" ");
            }
            for(int j=0; j<2*N-cnt*2-1; j++){
                System.out.print("*");
            }
            System.out.println();
            if(i<N-1) cnt++;
            else cnt--;
        }
    }
}