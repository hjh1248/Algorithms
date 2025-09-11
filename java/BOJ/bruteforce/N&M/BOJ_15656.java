import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_15656 {
    static int N;
    static int M;
    static int nums[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Tokens = br.readLine().split(" ");
        N = Integer.parseInt(Tokens[0]);
        M = Integer.parseInt(Tokens[1]);
        Tokens = br.readLine().split(" ");
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(Tokens[i]);
        }
        Arrays.sort(nums);

        perm(new ArrayList<>());

        System.out.println(sb);
    }

    public static void perm(List<Integer> list){
        if(list.size()==M){
            for(int i: list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            list.add(nums[i]);
            perm(list);
            list.remove(list.size()-1);
        }
    }
}