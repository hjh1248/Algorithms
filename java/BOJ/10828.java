import java.io.*;
import java.util.*;

class Main10828 {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int line=1; line<=N; line++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                }
            if(str.equals("size")) System.out.println(stack.size());
            if(str.equals("empty")){
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            if(str.equals("top")){
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
            if(str.equals("pop")) {
                if(stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            }
        }
    }
}