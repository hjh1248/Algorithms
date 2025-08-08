import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Tokens = br.readLine().split(" ");
        N = Integer.parseInt(Tokens[0]);
        M = Integer.parseInt(Tokens[1]);

        comb(new ArrayList<Integer>(), 0);

        System.out.println(sb);
    }

    public static void comb(List<Integer> list, int start){
        if(list.size()==M){
            for(int i: list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        for(int i=1+start; i<=N; i++){
            list.add(i);
            comb(list, i);
            list.remove(list.size()-1);
        }
    }
}