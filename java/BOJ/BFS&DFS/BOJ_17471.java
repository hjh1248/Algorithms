import java.io.*;
import java.util.*;

public class BOJ_17471 {
    static int N = 0;
    static int[] population;
    static int wholePopulation;
    static ArrayList<Integer>[] list;
    static int minDiff = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int pop = Integer.parseInt(st.nextToken());
            population[i] = pop;
            wholePopulation += pop;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=1; j<=cnt; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        Set<Integer> trueSet = new HashSet<>();
        Set<Integer> falseSet = new HashSet<>();
        trueSet.add(1);
        divide(2, trueSet, falseSet, population[1]);
        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }
    public static void divide(int idx, Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation){
        if(idx>N){
            check(trueSet, falseSet, zonePopulation);
            return;
        }

        falseSet.add(idx);
        divide(idx + 1, trueSet, falseSet, zonePopulation);
        falseSet.remove(idx);

        trueSet.add(idx);
        divide(idx + 1, trueSet, falseSet, zonePopulation + population[idx]);
        trueSet.remove(idx);
    }

    static void check(Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation){
        if(trueSet.isEmpty() || falseSet.isEmpty()) return;
        if(bfs(trueSet) && bfs(falseSet)){
            minDiff = Math.min(Math.abs(2 * zonePopulation - wholePopulation), minDiff);
        }
    }

    static boolean bfs(Set<Integer> set){
        queue.clear();
        Arrays.fill(visited, false);

        int start = set.iterator().next();
        visited[start] = true;
        queue.offer(start);
        int cnt = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next:list[now]){
                if(!visited[next] && set.contains(next)){
                    visited[next] = true;
                    cnt++;
                    queue.offer(next);
                }
            }
        }
        return cnt==set.size();
    }
}
