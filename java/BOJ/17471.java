import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static List<List<Integer>> routes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] Tokens = br.readLine().split(" ");
        int[] peoples = new int[N];
        int[][] links = new int[6][];
        
        for(int i=0; i<N; i++){
            peoples[i] = Integer.parseInt(Tokens[i]);
        }
        
        for(int i=0; i<N; i++){
            Tokens = br.readLine().split(" ");
            int M = Integer.parseInt(Tokens[0]);
            links[i] = new int[M];
            for(int j=1; j<=M; j++){
                links[i][j-1] = Integer.parseInt(Tokens[j]);
            }
        }
        for(int i=1; i<N+1; i++){
            dfs(i, links, N);
        }
        System.out.println(routes);
    }
    static void dfs(int startNode, int[][] links, int N){
        boolean[] visited = new boolean[N+1];
        List<Integer> route = new ArrayList<>();
        dfs(startNode, startNode, links, visited, route);
    }
    static void dfs(int startNode, int currentNode, int[][] links, boolean visited[], List<Integer> route){
        route.add(currentNode);
        routes.add(new ArrayList<>(route));
        visited[currentNode] = true;
        for(int node: links[currentNode-1]){
            if(node>startNode && !visited[node]){
                dfs(startNode, node, links, visited, route);
                visited[node] = false;
            }
        }
        route.remove(route.size()-1);
    }
}