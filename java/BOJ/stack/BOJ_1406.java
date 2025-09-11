import java.io.*;
import java.util.*;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L" -> {
                    if(!list.isEmpty()) stack.push(list.remove(list.size()-1));
                }
                case "D" -> {
                    if(!stack.isEmpty()) list.add(stack.pop());
                }
                case "B" -> {
                    if(!list.isEmpty()) list.remove(list.size()-1);
                }
                case "P" -> list.add(command[1]);
                default -> {
                }
            }
        }
        for(String str: list) sb.append(str);
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}