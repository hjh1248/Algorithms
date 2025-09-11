import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23842 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String answer = "impossible";
        int[] array = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        A: for(int i=0; i<100; i++){
            for(int j=0; j<100-i; j++){
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%02d", i));
                sb.append("+");
                sb.append(String.format("%02d", j));
                sb.append("=").append(String.format("%02d", i+j));
                char[] arr = sb.toString().toCharArray();
                int num = 0;
                for(char ch:arr){
                    if(Character.isDigit(ch)){
                        num += array[ch-'0'];
                    }
                }
                if(num == N-4){
                    answer = sb.toString();
                    break A;
                }
            }
        }
        System.out.println(answer);
    }
}