import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Permutation {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append("\n");
			String[] Tokens = br.readLine().split(" ");
			int N = Integer.parseInt(Tokens[0]);
			int R = Integer.parseInt(Tokens[1]);
			Tokens = br.readLine().split(" ");
			int[] numbers = new int[N];
			for(int i=0; i<N; i++){
				numbers[i] = Integer.parseInt(Tokens[i]);
			}
			visited = new boolean[N];
			perm(new ArrayList<>(), numbers, N, R);

		}
		System.out.println(sb);
	}
	static void perm(ArrayList<Integer> list, int[] numbers, int N, int R){
		if (list.size()==R){
			for(Integer i: list){
				sb.append(i);
			}
			sb.append("\n");
			return;
		}
		for (int i=0; i<N; i++){
			if (!visited[i]){
				list.add(numbers[i]);
				visited[i] = true;
				perm(list, numbers, N, R);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
	}
}
