import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_binary_search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long Z = X==0 ? 0 : Y * 100 / X;

        if(Z >= 99){
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = 1000000000;

        while(left<=right){
            int mid = (left + right) / 2;
            if((Y+mid)*100 / (X+mid) == Z) left = mid+1;
            else right = mid-1;
        }

        System.out.println(left);
    }
}
