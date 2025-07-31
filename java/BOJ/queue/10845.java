import java.io.*;
import java.util.*;

class Main10845 {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int line=1; line<=N; line++){
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push" -> {
                    int num = Integer.parseInt(command[1]);
                    stack.offer(num);
                }
                case "pop" -> {
                    if(stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.pop()).append("\n");
                }
                case "size" -> sb.append(stack.size()).append("\n");
                case "empty" -> {
                    if(stack.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
                case "front" -> {
                    if(stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.peek()).append("\n");
                }
                case "back" -> {
                    if(stack.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(stack.peekLast()).append("\n");
                }
                default -> {
                }
            }
        }
        System.out.println(sb);
    }
}