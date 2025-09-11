import java.io.*;
import java.util.*;

public class BOJ_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] questions = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                questions[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i=123; i<1000; i++){
            if(check(questions, ""+i)) cnt++;
        }
        System.out.println(cnt);
    }
    static Boolean check(int[][] questions, String number){
        for(int i =0; i<3; i++){
            for(int j =0; j<3; j++){
                if(i==j) continue;
                if(number.charAt(j)=='0') return false;
                if(number.charAt(i)==number.charAt(j)) return false;
            }
        }
        for(int[] question:questions){
            String questionNumber = ""+question[0];
            int strike = question[1];
            int ball = question[2];
            int xstrike = 0;
            int xball = 0;
            for(int i=0; i<3; i++){
                if (number.charAt(i)==questionNumber.charAt(i)) xstrike++;
                else{
                    for(int j=0; j<3; j++){
                        if (number.charAt(i)==questionNumber.charAt(j)) xball++;
                    }
                }
            }
            if(strike!=xstrike || ball!=xball) return false;
        }
        return true;
    }
}
