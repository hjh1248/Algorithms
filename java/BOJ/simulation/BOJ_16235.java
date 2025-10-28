
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_16235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] d = {-1, 0, 1};
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] food = new int[N][N];
        int[][] sup = new int[N][N];
        LinkedList<int[]> trees = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                food[i][j] = 5;
                sup[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            int[] arr = new int[3];
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken())-1;
            arr[1] = Integer.parseInt(st.nextToken())-1;
            arr[2] = Integer.parseInt(st.nextToken());
            trees.add(arr);
        }

        int year = 0;
        while(year<K){
            ArrayList<int[]> die = new ArrayList<>();
            int[][] breed = new int[N][N];

            // 봄
            Iterator<int[]> iter = trees.iterator();
            while(iter.hasNext()){
                int[] tree = iter.next();
                int r = tree[0];
                int c = tree[1];
                int tYear = tree[2];

                if(tYear > food[r][c]){
                    die.add(tree);
                    iter.remove();
                    continue;
                }
                food[r][c] -= tYear;
                tree[2] = ++tYear;

                if(tYear%5==0){
                    for(int i=0; i<3; i++){
                        for(int j=0; j<3; j++){
                            if(i==1&&j==1) continue;
                            int nr = r + d[i];
                            int nc = c + d[j];
                            if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                            breed[nr][nc]++;
                        }
                    }
                }

            }
            
            //여름
            for(int[] tree : die){
                int r = tree[0];
                int c = tree[1];
                int tYear = tree[2];
                food[r][c] += tYear/2;
            }

            //가을
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<breed[i][j]; k++){
                        trees.addFirst(new int[] {i, j, 1});
                    }
                    //겨울
                    food[i][j] += sup[i][j];
                }
            }
            year++;
        }

        System.out.println(trees.size());
    }
}
