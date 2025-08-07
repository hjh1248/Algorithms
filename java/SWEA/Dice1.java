import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dice1 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			perm(new ArrayList<Integer>(), N);
			}
            System.out.println(sb);
		
//		for(int i=1; i<7; i++) {
//			for(int j=1; j<7; j++) {
//				for(int k=1; k<7; k++) {
//					sb.append(i).append(j).append(k).append("\n");
//				}
//			}
//		}
		
		
	}
	static void perm(ArrayList<Integer> list, int N){
				
	}
}
