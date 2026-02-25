
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int five = N / 5;
        int remain = N % 5;

        if(remain%3==0){
            System.out.println(five + remain/3);
            return;
        }

        while(five > 0){
            five --;
            remain += 5;

            if(remain % 3==0){
                System.out.println(five + remain/3);
                return;
            }
        }
        System.out.println(-1);
    }
}
