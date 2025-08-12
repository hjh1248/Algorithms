import java.io.*;
import java.util.*;

class Main {
    static int N = 0;
    static int[] population;
    static int wholePopulation;
    static boolean devideCheck;
    static ArrayList<Integer>[] list;
    static int minDiff = -1;

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
            int pop = Integer.parseInt(st.nextToken());;
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
        devide(1, new HashSet<>(), new HashSet<>(), 0, 0);
        System.out.println(minDiff);
    }
    public static void devide(int idx, Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation, int cnt){
        if(cnt==N/2){
            for(int i=idx; i<=N; i++){
                falseSet.add(i);
            }
            check(trueSet, falseSet, zonePopulation);
            for(int i=idx; i<=N; i++){
                falseSet.remove(i);
            }
            return;
        }
        if(idx>N){
            check(trueSet, falseSet, zonePopulation);
            return;
        }
        falseSet.add(idx);
        devide(idx + 1, trueSet, falseSet, zonePopulation, cnt);
        falseSet.remove(idx);

        trueSet.add(idx);
        int newZonePopulation = zonePopulation + population[idx];
        devide(idx + 1, trueSet, falseSet, newZonePopulation, cnt+1);
        trueSet.remove(idx);
    }
    public static void check(Set<Integer> trueSet, Set<Integer> falseSet, int zonePopulation){
        if(trueSet.isEmpty() || falseSet.isEmpty()) return;
        boolean trueOk = false;
        boolean falseOk = false;
        for(int i=1; i<=N; i++){
            if(!trueOk && trueSet.contains(i)){
                if(!bfs(i, trueSet, new boolean[N+1])) return;
                else trueOk = true;
            }
            else if(!falseOk && falseSet.contains(i)){
                if(!bfs(i, falseSet, new boolean[N+1])) return;
                else falseOk = true;
            }
            if(trueOk && falseOk){
                if(!devideCheck){
                    minDiff = Math.abs(2*zonePopulation - wholePopulation);
                    devideCheck = true;
                }
                minDiff = Math.min(Math.abs(2*zonePopulation - wholePopulation), minDiff);
                return;
            }
        }
    }
    public static boolean bfs(int start, Set<Integer> set, boolean[] visited){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
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
        if(cnt==set.size()){
            return true;
        }
        else return false;
    }
}
