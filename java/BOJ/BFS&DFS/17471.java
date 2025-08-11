import java.io.*;
import java.util.*;

class Main {
    static int N = 0;
    static int[] population;
    static ArrayList<Integer>[] list;
    static int minDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            population[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0; i<cnt; j++){
                list[i].add(j);
            }
        }
    }
    public static void devide(int idx, Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation, int cnt){
        if(cnt==N/2 || idx==N && cnt!=0){
            check(trueSet, falseSet, zonePopulation);
        }
        falseSet.add(idx);
        devide(idx + 1, trueSet, falseSet, zonePopulation, cnt);
        falseSet.remove(falseSet.size()-1);

        trueSet.add(idx);
        int newZonePopulation = zonePopulation + population[idx];
        devide(idx + 1, trueSet, falseSet, newZonePopulation, cnt+1);
    }
    public static void check(Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation){
        boolean trueOk = false;
        boolean falseOk = false;
        for(int i=1; i<=N; i++){
            if(trueOk && falseOk){

            }
            if(!trueOk && trueSet.contains(i)){
                bfs(i, trueSet, new boolean[N+1]);
            }
            if(!falseOk && falseSet.contains(i)){
                bfs(i, falseSet, new boolean[N+1]);
            }
        }
    }
    public static void bfs(int start, Set<Integer> set, boolean[] visited){
        ArrayDeque<Point> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(new Point(start, 1));
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int next:list[now.node]){
                if(!visited[next]){
                    visited[next] = true;
                    
                    queue.offer(new Point(next, now.cnt+1));
                }
            }
        }
    }
    static class Point{
        int node, cnt;

        public Point(int node, int cnt){
            this.node = node;
            this.cnt = cnt;
        }
    }
}
